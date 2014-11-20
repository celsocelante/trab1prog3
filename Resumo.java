import java.io.*;

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
		
		buffer.write("Tema: " + edicao.getTema().getTitulo());
		buffer.newLine();

		buffer.write("Editor-chefe: " + edicao.getEditorChefe().getNome());
		buffer.newLine();

		buffer.write("Consistência dos dados:");
		
		for(Inconsistencia i : revista.getInconsistencias()){
			buffer.write(i.toString());
			buffer.newLine();
		}
		buffer.close();
	}

}