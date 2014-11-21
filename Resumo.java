import java.io.*;
import java.text.*;
import java.util.*;
public class Resumo{

	private Revista revista;
	
	public Resumo(Revista revista) {
		this.revista = revista;
	}

	public void escreveResumo() throws IOException {
		
		Edicao edicao = revista.getEdicao();

		FileWriter resumo = new FileWriter("resumo.txt");
		BufferedWriter buffer = new BufferedWriter(resumo);

		buffer.write("EngeSoft, num. " + edicao.getNumero() + ", volume " + edicao.getVolume() + " - " + edicao.getData());
		buffer.newLine();
		
		if(edicao.getTema()!=null){
			buffer.write("Tema: " + edicao.getTema().getTitulo());
			buffer.newLine();
		}

		if(edicao.getEditorChefe()!=null){
			buffer.write("Editor-chefe: " + edicao.getEditorChefe().getNome());
		}
		buffer.newLine();		
		buffer.newLine();

		buffer.write("Consistência dos dados:");
		buffer.newLine();
		if(!revista.getInconsistencias().isEmpty())
			for(Inconsistencia i : revista.getInconsistencias()){
			buffer.write("- "+ i.toString());
			buffer.newLine();
			}
		else{
			buffer.write("- Nenhum problema encontrado.");
			buffer.newLine();
			buffer.newLine();

			buffer.write("Artigos submetidos: " + revista.getEdicao().getArtigos().size());
			buffer.newLine();
			buffer.write("Revisores capacitados: " + revista.getEdicao().getTema().getQuantidadeRevisores());
			buffer.newLine();
			buffer.write("Revisores envolvidos: " + revista.getRevisoresEnvolvidos());
			buffer.newLine();
			NumberFormat nf = new DecimalFormat("###0.00", new DecimalFormatSymbols (new Locale("pt","BR")));
			double media = revista.getArtigosRevisados()/revista.getRevisoresEnvolvidos();
			
			buffer.write("Média artigos/revisor: " + nf.format(media));
		}
		
		buffer.close();
	}

}