public class Colaborador implements Comparable<Colaborador>{
	protected String nome;
	protected String email;
	protected String endereco;
	protected String senha;
	protected int codigo;
	public Colaborador (String nome, String email, String endereco, String senha, int codigo) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.codigo = codigo;
		this.senha = senha;
	}

	public int compareTo(Colaborador c){
		return this.nome.compareTo(c.getNome());
	}

	public int getCodigo(){
		return codigo;
	}
	
	public String getNome(){
		return nome;	
	}
}