import java.util.*;
public class Revisor extends Colaborador {
  private Set<String> instituicoes;
  private Set<Artigo> revisoes;

  public Revisor(String nome, String email, String endereco, String senha, int codigo) {
    super(nome,email,endereco,senha,codigo);
    instituicoes = new HashSet<String>();
    revisoes = new TreeSet<Artigo>();
  }

  public void vinculaInstituicao(String inst) {
     instituicoes.add(inst);
  }

  public void vinculaRevisao(Artigo artigo){
  	revisoes.add(artigo);
  }

  public Set<Artigo> getRevisoes(){
  	return revisoes;
  }

  public int getQuantidadeArtigos(){
  	return revisoes.size();
  }

}