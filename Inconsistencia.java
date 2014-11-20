public class Inconsistencia{

	private String mensagem;
	private int tipo;
	public Inconsistencia(String mensagem, int tipo){
		this.mensagem = mensagem;
		this.tipo = tipo;
	}

	public String toString(){
		return "Erro " + tipo + ": " + mensagem;
	}


}