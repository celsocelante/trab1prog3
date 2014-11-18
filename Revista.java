public class Revista{

	private String nome;
	private Edicao edicao;
	private Set<Tema> temas;
	private Set<Colaborador> colaboradores;
	private Set<Artigo> artigos;


	//Revista tem conjuntos de colaboradores, temas e artigos, e uma edição.
	//A cada leitura de um objeto adiciona-se esse objeto primeiramente a lista
	//correspondente na Revista
	public Revista(String nome){
		this.nome=nome;
		temas=new HashSet<Tema>();
		colaboradores=new HashSet<Colaborador>();
		artigos=new HashSet<Artigo>();
	}

	public void adicionaTema(Tema tema){
		temas.add(tema);
	}

	public void adicionaColaborador(Colaborador colaborador){
		colaboradores.add(colaborador);
	}

	public void adicionaArtigo(Artigo artigo){
		artigos.add(artigo);
	}
}