import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo
public class CadastroRevisoes {
  private String entrada;
  private Revista revista;

  public CadastroRevisoes(String entrada, Revista revista) throws FileNotFoundException {
    this.entrada = entrada;
    this.revista = revista;
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
        int artigo = Integer.parseInt(token.nextToken());
        int revisor = Integer.parseInt(token.nextToken());
        double originalidade = Double.parseDouble(token.nextToken());
        double conteudo = Double.parseDouble(token.nextToken());
        double apresentacao = Double.parseDouble(token.nextToken());
        
        Revisao revisao = 

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
