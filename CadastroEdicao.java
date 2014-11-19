import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo
public class CadastroEdicao {
  private String entrada;
  private Revista revista;

  public CadastroEdicao(String entradam, Revista revista) {
    this.entrada = entrada;
    this.revista = revista;
  }

  public void cadastraEdicao() {
   	File arquivo = new File(entrada);
    Scanner scanner = new Scanner(arquivo);

    while (scanner.hasNext()) {
        // A leitura da edição funciona de forma diferente. Precisa ser implementado
        // Obtém todas as linhas do arquivo
        String tema = scanner.next();
        String editor = scanner.next();
        int volume = Integer.parseInt(scanner.next());
        int numero = Integer.parseInt(scanner.next());              
        String data = scanner.next();
        
        Tema t = revista.buscaTema(tema);
        Colaborador c = revista.buscaColaborador(editor);
        
        revista.setEdicao(new Edicao(volume,numero,data,t,c));
        
        // Trata a exceção de arquivo mal formado
      }
    }
    scanner.close();
  }
  
}
