import java.util.*;
public class Artigo {
  private String titulo;
  private PilhaArray<Colaborador> colaboradores;
  private Set<Autor> autores;
  private Autor contato;

  public Artigo(String titulo) {
    this.titulo = titulo;
    colaboradores = new PilhaArray<Colaborador>(3);
    autores = new HashSet<Autor>();
  }

  public void vinculaColaborador(Colaborador colab) throws PilhaCheiaException{
    colaboradores.push(colab);
  }

  // public void vinculaAutor(Autor
}
