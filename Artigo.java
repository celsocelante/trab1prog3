import java.util.*;
public class Artigo implements Comparable<Artigo> {
  private String titulo;
  private int codigo;
  private Set<Autor> autores;
  private Set<Avaliacao> revisoes;
  private Autor contato;

  public Artigo(int codigo, String titulo) {
    this.codigo = codigo;
    this.titulo = titulo;
    autores = new HashSet<Autor>();
    revisoes = new TreeSet<Avaliacao>();
  }

  public void vinculaAutor(Autor autor) {
    autores.add(autor);
  }

  public void adicionaAvaliacao(Avaliacao avaliacao) {
    revisoes.add(avaliacao);
  }

  public boolean contemAutor(Autor autor) {
    return autores.contains(autor);
  }

  public boolean quantidadeRevisoes() {
    return revisoes.size() == 3;
  }

  // Getters and setters
  public int getCodigo() {
    return codigo;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getContato() {
    return contato.getNome();
  }

<<<<<<< HEAD
  

  public boolean contemAutor(Autor autor) {
    return autores.contains(autor);
  }

  public boolean quantidadeRevisoes() {
    return revisoes.size()==3;
  }

=======
>>>>>>> 0bd4fd0f4912d61a7a0ecc5540ead7a2c1556394
  public int getQuantidadeRevisoes() {
    return revisoes.size();
  }

  public void setContato(Autor autor) {
   contato = autor;  
  }

  // Método para ordenação
  public int compareTo(Artigo a) {
    return revisoes.getMedia().compareTo(a.)
  }  
}