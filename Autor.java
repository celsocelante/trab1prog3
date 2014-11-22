import java.util.*;
public class Autor extends Colaborador {
  private Set<String> instituicoes;

    public Autor(String nome, String email, String endereco, String senha, int codigo) {
      super(nome,email,endereco,senha,codigo);
      instituicoes = new HashSet<String>();
    }

	// Adiciona uma instituição ao conjunto de instituições de um autor
    public void vinculaInstituicao(String inst) {
      instituicoes.add(inst);
    }
}