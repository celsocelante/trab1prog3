	import java.util.*;

	public class Revista {

		private String nome;
		private Edicao edicao;
		private Set<Tema> temas;
		private Set<Colaborador> colaboradores;
		private Set<Inconsistencia> inconsistencias;

		// Revista tem conjuntos de colaboradores, temas, e uma edição.
		public Revista(String nome) {
			this.nome = nome;
			temas = new HashSet<Tema>();
			colaboradores = new TreeSet<Colaborador>();
			inconsistencias = new TreeSet<Inconsistencia>();
		}
		// Adiciona tema ao conjunto de temas
		public void adicionaTema(Tema tema) {
			temas.add(tema);
		}
		// Adiciona colaborador ao conjunto de colaboradores
		public void adicionaColaborador(Colaborador colaborador) {
			colaboradores.add(colaborador);
		}
		// Adiciona uma inconsistência ao conjunto de inconsistências detectadas
		public void adicionaInconsistencia(Inconsistencia inconsistencia) {
			inconsistencias.add(inconsistencia);
		}
		// Busca por um colaborador no conjunto de colaboradores (chave: código)
		public Colaborador buscaColaborador(int codigo) {
			for(Colaborador c: colaboradores){
				if(codigo == c.getCodigo())
					return c;
			}
			return null;
		}
		// Busca por um colaborador no conjunto de colaboradores (chave: nome)
		public Colaborador buscaColaborador(String nome) {
			for(Colaborador c: colaboradores){
				if(nome.equals(c.getNome()))
					return c;
			}
			return null;
		}
		// Busca tema em conjunto de temas
		public Tema buscaTema(String titulo) {
			for(Tema t: temas){
				if(titulo.equals(t.getTitulo()))
					return t;
			}
			return null;
		}
		// Setter and getters
		public void setEdicao(Edicao edicao) {
			this.edicao = edicao;
		}

		public Edicao getEdicao() {
			return edicao;
		}

		public Set<Colaborador> getColaboradores(){
			return colaboradores;
		}

		public Set<Inconsistencia> getInconsistencias() {
			return inconsistencias;
		}
		// Retorna quantidade de revisores envolvidos
		public int getRevisoresEnvolvidos() {
			int qnt=0;
			for(Colaborador c : colaboradores)
				if (c instanceof Revisor){
					Revisor r = (Revisor)c;
					if(!r.getRevisoes().isEmpty())
						qnt+=1;
				}
			return qnt;
		}
		// Retorna quantidade de artigos revisados
		public double getArtigosRevisados() {

			int totalArtigosRevisados=0;
			for(Colaborador c : colaboradores)
				if(c instanceof Revisor){
					Revisor r = (Revisor)c;
					if(!r.getRevisoes().isEmpty())
						totalArtigosRevisados+=r.getQuantidadeArtigos();

				}
			return totalArtigosRevisados;
		}
	}