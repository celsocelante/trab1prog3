import java.util.*;
public class Revisor extends Colaborador {
  private Set<Instituicao> instituicoes;
  private Set<Tema> temas;

  public Revisor(String nome, String email) {
    super(nome,email);
    instituicoes = new HashSet<Instituicao>();
    temas = new HashSet<Tema>();
  }
} 
