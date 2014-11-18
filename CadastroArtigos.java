import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo
public class CadastroArtigos {
  private String entrada;

  public CadastroArtigos(String entrada) throws FileNotFoundException {
    this.entrada = entrada;
  }

  File arquivo = new File(entrada);
  Scanner scanner = new Scanner(arquivo);

  while (scanner.hasNextLine()) {
    try {
      // Obtém todas as linhas do arquivo
      String linha = scanner.nextLine();
      StringTokenizer token = new StringTokenizer(linha, ";");
      // Divide cada linha em tokens, de acordo com o delimitador ";"
      while (token.hasMoreTokens()) {
        // Salvo os dados em variáveis
        String codigo = token.nextToken();
        String titulo = token.nextToken();
        String revisores = token.nextToken(); // ainda precisa quebrar os strings (separados por virgula) e jogar num Set
        String autor = token.nextToken();

        // Verificar o que fazer com essas informações lidas
      }
      // Trata a exceção de arquivo mal formado
    } catch(NoSuchElementException e){
      System.out.println("Arquivo com sintaxe diferente da esperada");
      System.exit(1);
    }

  }
  scanner.close();
}