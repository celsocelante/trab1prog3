import java.util.*;
public class Autor extends Colaborador {
  private Set<Instituicao> instituicoes;

    public Autor(String nome, String email, String endereco, int codigo) {
      super(nome,email,endereco,codigo);
      instituicoes = new HashSet<Instituicao>();
    }

    public void vinculaInstituicao(Instituicao inst) {
      instituicoes.add(inst);
    }
}
 