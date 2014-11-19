public class Revisao{

	private Artigo artigo;
	private PilhaArray<Avaliacao> avaliacoes;
	

	public Revisao(Artigo artigo){
		this.artigo = artigo;
		avaliacoes = new PilhaArray<Avaliacao>(3);
	}

	public void registraAvaliacao(Avaliacao avaliacao) {
		try {
			avaliacoes.push(avaliacao);
		} catch(PilhaCheiaException e){
			System.out.println("Tem mais de 3 revisoes");
		}
	}

	public int getEstado(){
		return avaliacoes.tamanho();
	}	
}