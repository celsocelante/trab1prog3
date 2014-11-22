	import java.io.*;
	import java.util.*;
	import java.text.*;

	public class RelatorioRevisores {

		private Revista revista;
		public RelatorioRevisores(Revista revista){
			this.revista = revista;
		}
		// Retorna a média das notas atribuídas por um revisor
		public Double getMediaNotasAtribuidas(Revisor revisor){
			Double media = new Double(0);

			for(Artigo artigo : revisor.getRevisoes())
				for(Avaliacao avaliacao : artigo.getRevisao())
					if(revisor.getNome().equals(avaliacao.getRevisor().getNome()))
						media = media + avaliacao.getSomaNotas();
			return (media)/revisor.getQuantidadeArtigos();		
		}
		// Registra o relatório de revisores de acordo com as especificações
		public void escreveRelatorio() throws IOException{

			FileWriter relatorio = new FileWriter("relat-revisores.csv");
			BufferedWriter buffer = new BufferedWriter(relatorio);

	 		NumberFormat nf = new DecimalFormat("###0.00", new DecimalFormatSymbols (new Locale("pt","BR")));

			buffer.write("Revisor;Qtd. artigos revisados;Média das notas atribuídas");

			for(Colaborador c : revista.getColaboradores()){
				if(c instanceof Revisor){
					Revisor r = (Revisor)c;
					if(r.participouDaEdicao()){
						buffer.newLine();	
						buffer.write(r.getNome() + ";" + r.getQuantidadeArtigos() + ";" + nf.format(getMediaNotasAtribuidas(r)));
					}
				}	
			}
			buffer.close();

		}
	}