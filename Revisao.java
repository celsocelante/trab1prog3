public class Revisao{

	private Artigo artigo;
	private PilhaArray<Avaliacao> avaliacoes;

	public Revisao(Artigo artigo){
		this.artigo = artigo;
		avaliacoes = new PilhaArray<Avaliacao>(3);
	}

	public void registrarAvaliacao(Avaliacao avaliacao) throws PilhaCheiaException{
		avaliacoes.push(avaliacao);
	}

	public int getEstado(){
		return avaliacoes.tamanho();
	}	
}