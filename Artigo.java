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
      // Adiciona um autor ao conjunto de autores de um artigo
      public void vinculaAutor(Autor autor) {
        autores.add(autor);
      }
      //Adiciona uma avaliação ao conjunto de avaliações de um artigo
      public void adicionaAvaliacao(Avaliacao avaliacao) {
        revisoes.add(avaliacao);
      }
      // Verifica se o autor existe no conjunto de autores do artigo
      public boolean contemAutor(Autor autor) {
        return autores.contains(autor);
      }
      // Verifica se a quantidade de revisões de um artigo é igual a 3
      public boolean quantidadeRevisoes() {
        return revisoes.size()==3;
      }

      // Método para ordenação
      public int compareTo(Artigo artigo) {
        return -1*getMedia().compareTo(artigo.getMedia());
      }

      // Getters and setters
      public int getCodigo() {
        return codigo;
      }

      public String getTitulo() {
        return titulo;
      }

      public String getContato() {
        if(contato==null)
          return "";
        else return contato.getNome();
      }

      public Set<Avaliacao> getRevisao(){
        return revisoes;
      }
      // Calcula a média das avaliações do artigo
      public Double getMedia(){
        Double media=new Double(0);
        for(Avaliacao a : revisoes)
          media+=a.getSomaNotas();
        return media/3;
      }

      public int getQuantidadeRevisoes() {
        return revisoes.size();
      }

      public void setContato(Autor autor) {
       contato = autor;  
      }

      
    }