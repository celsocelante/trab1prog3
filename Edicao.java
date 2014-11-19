import java.util.*;
public class Edicao{

	private int volume, numero;
	private String data;
	private Tema tema;
	private Set<Artigo> submetidos;
	private Colaborador editorChefe;

	public Edicao(int volume, int numero, String data, Tema tema, Colaborador editorChefe){
		this.volume = volume;
		this.numero = numero;
		this.data = data;
		this.tema = tema;
		this.editorChefe = editorChefe;
		submetidos = new HashSet<Artigo>();
	}

	public void submeterArtigo(Artigo artigo){
		submetidos.add(artigo);
	}

}
