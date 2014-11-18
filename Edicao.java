import java.util.*;
public class Edicao{

	private String volume, numero;
	private String data;
	private Tema tema;
	private Set<Artigo> submetidos;
	private Set<Artigo> selecionados;
	private Colaborador editorChefe;

	public Edicao(String volume, String numero, Date data, String tema, Colaborador editorChefe){
		this.volume=volume;
		this.numero=numero;
		this.data=data;
		this.tema= new Tema(tema);
		this.editorChefe = editorChefe;
		submetidos = new HashSet<Artigo>();
		selecionados = new HashSet<Artigo>();
	}

	public void submeterArtigo(Artigo artigo){
		submetidos.add(artigo);
	}

	public void selecionarArtigo(Artigo artigo){
		selecionados.add(artigo);
	}

}