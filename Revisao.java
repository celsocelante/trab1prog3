import java.util.ArrayList;
public class Revisao{

	private Artigo artigo;
	private ArrayList<Avaliacao> avaliacoes;

	public Revisao(Artigo artigo){
		this.artigo = artigo;
		avaliacoes = new ArrayList<Avaliacao>(3);
	}

	public void registrarAvaliacao(Avaliacao avaliacao) throws IndexOutOfBoundsException{
		avaliacoes.add(avaliacao);
	}
}