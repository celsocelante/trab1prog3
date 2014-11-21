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
  
  public void setContato(Autor autor) {
	 contato = autor;  
  }

  public void adicionaAvaliacao(Avaliacao avaliacao) {
    revisoes.add(avaliacao);
  }

  public int getCodigo() {
    return codigo;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getContato() {
    return contato.getNome();
  }

  

  public boolean contemAutor(Autor autor) {
    return autores.contains(autor);
  }

  public boolean quantidadeRevisoes() {
    return revisoes.size()==3;
  }

  public int getQuantidadeRevisoes() {
    return revisoes.size();
  }

  public int compareTo(Artigo a) {
    return revisoes.getMedia().compareTo(a.)
  }  
}