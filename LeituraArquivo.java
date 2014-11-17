import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo e quebra em tokens

public class LeituraArquivo {
  public static void main(String[] args) throws FileNotFoundException {

    FileReader arquivo = new FileReader("/home/celso/trab1prog3/" + args[0]);
    Scanner scanner = new Scanner(arquivo);

    while (scanner.hasNextLine()) {
      try {
        // Obtém todas as linhas do arquivo
        String linha = scanner.nextLine();
        StringTokenizer token = new StringTokenizer(linha, ";");
        // Divide cada linha em tokens, de acordo com o delimitador ";"
        while (token.hasMoreTokens()) {
          // Salvo os dados em variáveis
          String a = token.nextToken();
          String b = token.nextToken();
          String c = token.nextToken();

          System.out.println(a);
          System.out.println(b);
          System.out.println(c);
        }
        // Trata a exceção de arquivo mal formado
      } catch(NoSuchElementException e){
        System.out.println("Arquivo com sintaxe diferente da esperada");
        System.exit(1);
      }

    }
    scanner.close();
  }
}
