public class Revista{

	private String nome;
	private Edicao edicao;
	private Set<Tema> temas;
	private Set<Colaborador> colaboradores;


	//Revista tem conjuntos de colaboradores, temas, e uma edição.
	//A cada leitura de um objeto adiciona-se esse objeto primeiramente a lista
	//correspondente na Revista
	public Revista(String nome){
		this.nome = nome;
		temas = new HashSet<Tema>();
		colaboradores = new HashSet<Colaborador>();
	}

	public void adicionaTema(Tema tema){
		temas.add(tema);
	}

	public void adicionaColaborador(Colaborador colaborador){
		colaboradores.add(colaborador);
	}

	public Colaborador buscaColaborador(int codigo){
		for(Colaborador c: colaboradores){
			// Tratar caso o colaborador com certo código não esteja no Set
			if(codigo == c.getCodigo())
				return c;
		}
	}
	
	public Colaborador buscaColaborador(String nome){
		for(Colaborador c: colaboradores){
			// Tratar caso o colaborador com certo código não esteja no Set
			if(nome.equals(c.getNome()))
				return c;
		}
	}
	
	public Tema buscaTema(String titulo){
		for(Tema t: temas){
			// Tratar caso o colaborador com certo código não esteja no Set
			if(titulo.equals(c.getTitulo()))
				return t;
		}
	}
	
	public void setEdicao(Edicao edicao){
		this.edicao = edicao;
	}
	
	public Edicao getEdicao(){
		return edicao;
	}
}
