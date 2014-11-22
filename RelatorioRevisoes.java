	import java.io.*;
	import java.util.*;
	import java.text.*;

	public class RelatorioRevisoes{

		private Revista revista;
		public RelatorioRevisoes(Revista revista){
			this.revista = revista;
		}
		// Ordena o conjunto de artigos revisados
		public Set<Artigo> ordenaArtigosPorMedia(){
			return new TreeSet<Artigo>(revista.getEdicao().getArtigos());
		}
		// Registra o relatório de revisões de acordo com as especificações
		public void escreveRelatorio() throws IOException {

			FileWriter relatorio = new FileWriter("relat-revisoes.csv");
			BufferedWriter buffer = new BufferedWriter(relatorio);

	 		NumberFormat nf = new DecimalFormat("###0.00", new DecimalFormatSymbols (new Locale("pt","BR")));

			buffer.write("Artigo;Autor de contato;Média das avaliações;Revisor 1; Revisor 2; Revisor 3");
	    
			for(Artigo artigo : ordenaArtigosPorMedia()){
				buffer.newLine();
				buffer.write(artigo.getTitulo() + ";" + artigo.getContato() + ";" + nf.format(artigo.getMedia()) + ";");
				for(Avaliacao avaliacao : artigo.getRevisao())
					buffer.write(avaliacao.getRevisor().getNome() + ";" );	
			}

			
			buffer.close();
		}
	}