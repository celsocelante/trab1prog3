import java.util.*;
public class Edicao{

	private int volume, numero;
	private String data;
	private Tema tema;
	private Set<Artigo> submetidos;
	private Set<Artigo> avaliados;
	private Colaborador editorChefe;

	public Edicao(int volume, int numero, String data, Tema tema, Colaborador editorChefe){
		this.volume = volume;
		this.numero = numero;
		this.data = data;
		this.tema = tema;
		this.editorChefe = editorChefe;
		submetidos = new HashSet<Artigo>();
		avaliados = new HashSet<Artigo>();
	}

	public void submeterArtigo(Artigo artigo){
		submetidos.add(artigo);
	}

	public Artigo buscaArtigo(int codigo){
		for(Artigo a : submetidos){
			if(a.getCodigo() == codigo)
				return a;
		}
		return null;
	}

	public void imprimeArtigos(){
		for (Artigo a : submetidos)
			System.out.println(a.getCodigo());
	}

	public Tema getTema(){
		return tema;
	}

}
