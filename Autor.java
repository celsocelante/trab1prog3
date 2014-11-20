import java.util.*;
public class Autor extends Colaborador {
  private Set<String> instituicoes;

    public Autor(String nome, String email, String endereco, String senha, int codigo) {
      super(nome,email,endereco,senha,codigo);
      instituicoes = new HashSet<String>();
    }

    public void vinculaInstituicao(String inst) {
      instituicoes.add(inst);
    }
}