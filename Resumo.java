	import java.io.*;
	import java.text.*;
	import java.util.*;

	public class Resumo{

		private Revista revista;
		
		public Resumo(Revista revista) {
			this.revista = revista;
		}
		// Registra o relatório de resumo de acordo com as especificações
		public void escreveResumo() throws IOException {
			
			Edicao edicao = revista.getEdicao();

			FileWriter resumo = new FileWriter("relat-resumo.txt");
			BufferedWriter buffer = new BufferedWriter(resumo);
			// Cabeçalho do resumo
			buffer.write("EngeSoft, num. " + edicao.getNumero() + ", volume " + edicao.getVolume() + " - " + edicao.getData());
			buffer.newLine();
			
			if(edicao.getTema()!=null) {
				buffer.write("Tema: " + edicao.getTema().getTitulo());
				buffer.newLine();
			}
			buffer.write("Editor-chefe: ");
			if(edicao.getEditorChefe()!=null) {
				buffer.write(edicao.getEditorChefe().getNome());
			}
			buffer.newLine();		
			buffer.newLine();

			buffer.write("Consistência dos dados:");
			if (!revista.getInconsistencias().isEmpty())
				// Imprime no arquivo de saída todas as inconsistências armazenadas no objeto revista
				for(Inconsistencia i : revista.getInconsistencias()){
				buffer.newLine();
				buffer.write("- "+ i.toString());
				}
			else {
				// Caso não haja qualquer inconsistência, uma mensagem informando a situação é inserida no arquivo
				buffer.write("- Nenhum problema encontrado.");
				buffer.newLine();
				buffer.newLine();

				// Insere no arquivo a quantidade de artigos submetidos, revisoes capacitados e envolvidos
				buffer.write("Artigos submetidos: " + revista.getEdicao().getArtigos().size());
				buffer.newLine();
				buffer.write("Revisores capacitados: " + revista.getEdicao().getTema().getQuantidadeRevisores());
				buffer.newLine();
				buffer.write("Revisores envolvidos: " + revista.getRevisoresEnvolvidos());
				buffer.newLine();
				// Formata os número em padrão americano (1,111.11) para o brasileiro (1.111,11), arredondando para duas casas depois da vírgula
				NumberFormat nf = new DecimalFormat("###0.00", new DecimalFormatSymbols (new Locale("pt","BR")));
				double media = revista.getArtigosRevisados()/revista.getRevisoresEnvolvidos();
				
				// Insere no arquivo de saída a média de artigos por revisões
				buffer.write("Média artigos/revisor: " + nf.format(media));
			}
			
			buffer.close();
		}

	}