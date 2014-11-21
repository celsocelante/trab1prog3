import java.io.*;
public class RelatorioRevisores{

	private Revista revista;
	public RelatorioRevisores(Revista revista){
		this.revista = revista;
	}

	public void escreveRelatorio() throws IOException {

		FileWriter relatorio = new FileWriter("relat-revisores.csv");
		BufferedWriter buffer = new BufferedWriter(relatorio);

		for(Artigo a : 
		buffer.write();
		buffer.close();
	}
}