import java.io.*;
public class RelatorioRevisores{

	private Revista revista;
	public RelatorioRevisores(Revista revista){
		this.revista = revista;
	}

	public void escreveRelatorio() throws IOException {

		FileWriter relatorio = new FileWriter("relat-revisores.csv");
		BufferedWriter buffer = new BufferedWriter(relatorio);

		for(Artigo artigo : revista.getEdicao().getArtigos()){
			buffer.write(artigo.getTitulo() + ";" + artigo.getContato() + ";" + artigo.getMedia() + ";");
			for(Avaliacao avaliacao : artigo.getRevisao())
				buffer.write(avaliacao.getRevisor().getNome() + ";" );	
			
		}

		
		buffer.close();
	}
}