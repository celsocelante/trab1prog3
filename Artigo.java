import java.util.*;
public class Artigo {
  private String titulo;
  private int codigo;
  private Set<Autor> autores;
  private Autor contato;

  public Artigo(int codigo, String titulo) {
    this.titulo = titulo;
    autores = new HashSet<Autor>();
  }

  public void vinculaAutor(Autor autor) {
    autores.add(autor);
  }
  
  public void setContato(Autor autor) {
	 contato = autor;  
  }

}