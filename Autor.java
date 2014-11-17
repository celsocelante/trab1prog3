import java.util.*;
public class Autor extends Colaborador {
  private Set<Instituicao> instituicoes;

    public Autor(String nome, String email) {
      super(nome,email);
      instituicoes = new HashSet<Instituicao>();
    }

    public void vinculaInstituicao(Instituicao inst) {
      instituicoes.add(inst);
    }
}
