import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo
public class CadastroRevisoes {
  private String entrada;

  public CadastroRevisoes(String entrada) throws FileNotFoundException {
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
        String artigo = token.nextToken();
        String revisor = token.nextToken();
        String originalidade = token.nextToken();
        String conteudo = token.nextToken();
        String apresentacao = token.nextToken();

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
