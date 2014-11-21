public class Avaliacao implements Comparable<Avaliacao> {
	 private double originalidade;
	 private double conteudo;
	 private double apresentacao;
	 private Double media;
	 private Revisor revisor;

	 public Avaliacao(Revisor revisor) {
	 	this.revisor = revisor;
	 }

	 public void atribuirNota(double originalidade, double conteudo, double apresentacao) {
	 	this.originalidade = originalidade;
	 	this.conteudo = conteudo;
	 	this.apresentacao = apresentacao;
	 	media = (this.apresentacao + this.originalidade + this.conteudo)/3;
	 }

	 public Double getMedia() {
	 	return media;
     }

	 public int compareTo(Avaliacao a) { 
	 	return  -1*this.media.compareTo(a.getMedia());
	 }
}