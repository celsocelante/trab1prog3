import java.util.*;
public class Revisor extends Colaborador {
  private Set<String> instituicoes;
  private Set<Tema> temas;

  public Revisor(String nome, String email, String endereco, int codigo) {
    super(nome,email,endereco,codigo);
    instituicoes = new HashSet<String>();
    temas = new HashSet<Tema>();
  }

  public void vinculaInstituicao(String inst) {
     instituicoes.add(inst)
  }

  public void vinculaTema(Tema tema){
  	temas.add(tema);
  }


}
