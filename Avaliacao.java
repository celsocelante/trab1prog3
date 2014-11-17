public class Avaliacao{
	 private double originalidade;
	 private double conteudo;
	 private double apresentacao;
	 private Revisor revisor;

	 public Avaliacao(Revisor revisor){
	 	this.revisor = revisor;
	 }

	 public void atribuirNota(double originalidade, double conteudo, double apresentacao){
	 	this.originalidade = originalidade;
	 	this.conteudo = conteudo;
	 	this.apresentacao = apresentacao;
	 }
}