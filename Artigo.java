import java.util.*;
public class Artigo {
  private String titulo;
  private int codigo;
  private Set<Autor> autores;
  private Set<Avaliacao> revisao;
  private Autor contato;


  public Artigo(int codigo, String titulo) {
    this.codigo = codigo;
    this.titulo = titulo;
    autores = new HashSet<Autor>();
    revisao = new HashSet<Avaliacao>();
  }

  public void vinculaAutor(Autor autor) {
    autores.add(autor);
  }
  
  public void setContato(Autor autor) {
	 contato = autor;  
  }

  public void adicionaAvaliacao(Avaliacao avaliacao){
    revisao.add(avaliacao);
  }

  public int getCodigo(){
    return codigo;
  }

}