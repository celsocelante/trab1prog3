public class Avaliacao{
	 private double nota;
	 private Revisor revisor;

	 public Avaliacao(Revisor revisor){
	 	this.revisor = revisor;
	 }

	 public void atribuirNota(double nota){
	 	this.nota = nota;
	 }
}