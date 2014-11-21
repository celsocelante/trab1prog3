public class Inconsistencia implements Comparable<Inconsistencia> {

	private String mensagem;
	private int tipo;
	public Inconsistencia(String mensagem, int tipo){
		this.mensagem = mensagem;
		this.tipo = tipo;
	}

	public int getTipo(){
		return tipo;
	}
	
	public int compareTo(Inconsistencia i) { 
		return tipo - i.getTipo(); 
	}

	public String toString(){
		return "Erro " + tipo + ": " + mensagem;
	}


}