import java.util.*;
public class Edicao{

	private int volume, numero;
	private Date data;
	private Tema tema;
	private Set<Artigo> submetidos;
	private Set<Artigo> selecionados;
	private Colaborador editorChefe;

	public Edicao(int volume, int numero, Date data, Tema tema, Colaborador editorChefe){
		this.volume=volume;
		this.numero=numero;
		this.data=data;
		this.tema=tema;
		this.editorChefe=editorChefe;
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