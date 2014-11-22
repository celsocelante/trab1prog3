	public class Avaliacao implements Comparable <Avaliacao> {
		 private double originalidade;
		 private double conteudo;
		 private double apresentacao;
		 private Double somaNotas;
		 private Revisor revisor;

		 public Avaliacao(Revisor revisor) {
		 	this.revisor = revisor;
		 }

		 public Revisor getRevisor(){
		 	return revisor;
		 }

		 public Double getSomaNotas() {
		 	return somaNotas;
	     }

		 public void atribuirNota(double originalidade, double conteudo, double apresentacao) {
		 	this.originalidade = originalidade;
		 	this.conteudo = conteudo;
		 	this.apresentacao = apresentacao;
		 	somaNotas = (this.apresentacao + this.originalidade + this.conteudo)/3;
		 }

		 // Método de comparação para ordenação do Set
		 public int compareTo(Avaliacao a){
		 	return getRevisor().getNome().compareTo(a.getRevisor().getNome());
		 }
	}