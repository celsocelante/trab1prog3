import java.io.*;
import java.util.*;
import java.text.*;

public class RelatorioRevisores{

	private Revista revista;
	public RelatorioRevisores(Revista revista){
		this.revista = revista;
	}

	public Set<Artigo> ordenaArtigosPorMedia(){
		return new TreeSet<Artigo>(revista.getEdicao().getArtigos());
	}

	public void escreveRelatorio() throws IOException {

		FileWriter relatorio = new FileWriter("relat-revisores.csv");
		BufferedWriter buffer = new BufferedWriter(relatorio);

		buffer.write("Artigo;Autor de contato;Média das avaliações;Revisor 1; Revisor 2; Revisor 3");

 		NumberFormat nf = new DecimalFormat("###0.00", new DecimalFormatSymbols (new Locale("pt","BR")));
    
		for(Artigo artigo : ordenaArtigosPorMedia()){
			buffer.newLine();
			buffer.write(artigo.getTitulo() + ";" + artigo.getContato() + ";" + nf.format(artigo.getMedia()) + ";");
			for(Avaliacao avaliacao : artigo.getRevisao())
				buffer.write(avaliacao.getRevisor().getNome() + ";" );	
		}

		
		buffer.close();
	}
}