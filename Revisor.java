public class Revisor extends Colaborador {
  private Set<Instituicao> instituicoes;
  private Set<Tema> temas;

  public Revisor(String nome, String email) {
    super(nome,email);
    instituicoes = HashSet<Instituicao>();
    temas = HashSet<Tema>();
  }
}
