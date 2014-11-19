import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo
public class CadastroTemas {
  private String entrada;
  private Revista revista;
  Tema tema;

  public cadastroTemas(String entrada, Revista revista) throws FileNotFoundException {
    this.entrada = entrada;
    this.revista = revista;
  }
  public void cadastraTemas(){
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
          String nome = token.nextToken();
          String revisores = token.nextToken(); // ainda precisa quebrar os strings (separados por virgula) e jogar num Set

          // Cria um novo tema e salva a referência para esse objeto
          tema = new Tema(nome,codigo);

          // Adiciona o tema à revista
          revista.adicionaTema(tema);

          // Quebra o string de vários revisores separados por vírgula para vinculá-los ao tema
          StringTokenizer revisor = new StringTokenizer(revisores,",");
          while (revisor.hasMoreTokens()) {
            // Procura o colaborador no conjunto de colaboradores da revista
            Colaborador colab = revista.buscaColaborador(revisor.nextToken());
            // Vincula o colaborador encontrado ao tema construído
            colab.vinculaTema(tema);
          }

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
