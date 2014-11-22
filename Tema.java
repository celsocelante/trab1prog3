  import java.util.*;
  public class Tema {
    private String titulo;
    private int codigo;
    private Set<Revisor> revisores;
    
    public Tema(String titulo, int codigo){
      this.titulo = titulo;
      this.codigo = codigo;
      revisores = new HashSet<Revisor>();
    }
    // Getter
    public String getTitulo(){
  		return titulo;  
    }
    // Vincula um revisor a um tema
    public void vinculaRevisor(Revisor revisor){
    	revisores.add(revisor);
    }
    // Obtém a quantidade de revisores associados a um tema
    public int getQuantidadeRevisores(){
    	return revisores.size();
    }
    // Verifica se o revisor está apto a revisar um tema
    public boolean contemRevisor(Revisor revisor){
    	return revisores.contains(revisor);
    }
  }