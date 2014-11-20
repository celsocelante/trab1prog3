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
  
  public String getTitulo(){
		return titulo;  
  }

  public void vinculaRevisor(Revisor revisor){
  	revisores.add(revisor);
  }

  public int getQuantidadeRevisores(){
  	return revisores.size();
  }

  public boolean contemRevisor(Revisor revisor){
  	return revisores.contains(revisor);
  }
}
