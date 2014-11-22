  import java.util.*;
  public class Revisor extends Colaborador {
    private Set<String> instituicoes;
    private Set<Artigo> revisoes;

    public Revisor(String nome, String email, String endereco, String senha, int codigo) {
      super(nome,email,endereco,senha,codigo);
      instituicoes = new HashSet<String>();
      revisoes = new TreeSet<Artigo>();
    }
    // Adiciona uma instituição ao conjunto de instituições
    public void vinculaInstituicao(String inst) {
       instituicoes.add(inst);
    }
    // Adiciona um artigo ao conjuntos de artigos para revisão
    public void vinculaRevisao(Artigo artigo) {
    	revisoes.add(artigo);
    }
    // Verifica se o revisor participou de alguma revisão
    public boolean participouDaEdicao(){
      return !revisoes.isEmpty();
    }

    // Getters
    public Set<Artigo> getRevisoes() {
    	return revisoes;
    }

    public int getQuantidadeArtigos() {
    	return revisoes.size();
    }
  }