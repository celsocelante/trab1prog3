import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo
public class CadastroEdicao {
  private String entrada;
  private Edicao edicao;

  public CadastroEdicao(String entrada) throws FileNotFoundException {
    this.entrada = entrada;
  }

  File arquivo = new File(entrada);
  Scanner scanner = new Scanner(arquivo);

  while (scanner.hasNext()) {
    try {
      // A leitura da edição funciona de forma diferente. Precisa ser implementado
      // Obtém todas as linhas do arquivo
      String tema = scanner.next();
      String editor = scanner.next();
      String volume = scanner.next();
      String numero = scanner.next();              
      String data = scanner.next();


      //Chamar construtor de edição : Ver como tratar 
      
      // Trata a exceção de arquivo mal formado
    } catch(NoSuchElementException e){
      System.out.println("Arquivo com sintaxe diferente da esperada");
      System.exit(1);
    }

  }
  scanner.close();
}
