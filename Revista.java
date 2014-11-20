import java.util.*;
public class Revista{

	private String nome;
	private Edicao edicao;
	private Set<Tema> temas;
	private Set<Colaborador> colaboradores;
	private Set<Inconsistencia> inconsistencias;

	//Revista tem conjuntos de colaboradores, temas, e uma edição.
	//A cada leitura de um objeto adiciona-se esse objeto primeiramente a lista
	//correspondente na Revista
	public Revista(String nome){
		this.nome = nome;
		temas = new HashSet<Tema>();
		colaboradores = new HashSet<Colaborador>();
		inconsistencias = new HashSet<Inconsistencia>();
	}

	public void adicionaTema(Tema tema){
		temas.add(tema);
	}

	public void adicionaColaborador(Colaborador colaborador){
		colaboradores.add(colaborador);
	}

	public void adicionaInconsistencia(Inconsistencia inconsistencia){
		inconsistencias.add(inconsistencia);
	}

	public void imprimeColaboradores(){
		for (Colaborador c : colaboradores)
			System.out.println(c.getCodigo());
	}

	public Colaborador buscaColaborador(int codigo){
		for(Colaborador c: colaboradores){
			// Tratar caso o colaborador com certo código não esteja no Set
			if(codigo == c.getCodigo())
				return c;
		}
		return null;
	}
	
	public Colaborador buscaColaborador(String nome){
		for(Colaborador c: colaboradores){
			// Tratar caso o colaborador com certo código não esteja no Set
			if(nome.equals(c.getNome()))
				return c;
		}
		return null;
	}
	
	public Tema buscaTema(String titulo){
		for(Tema t: temas){
			// Tratar caso o colaborador com certo código não esteja no Set
			if(titulo.equals(t.getTitulo()))
				return t;
		}
		return null;
	}
	
	public void setEdicao(Edicao edicao){
		this.edicao = edicao;
	}
	
	public Edicao getEdicao(){
		return edicao;
	}
}