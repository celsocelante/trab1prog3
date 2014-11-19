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

  public void cadastraRevisoes(){
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
          int codigo = Integer.parseInt(token.nextToken());

          int revisor = Integer.parseInt(token.nextToken());
          Avaliacao avaliacao = new (revista.buscaColaborador(revisor));
         
          double originalidade = Double.parseDouble(token.nextToken());
          double conteudo = Double.parseDouble(token.nextToken());
          double apresentacao = Double.parseDouble(token.nextToken());
          
          avaliacao.atribuirNota(originalidade,conteudo,apresentacao);
          Artigo artigo = revista.getEdicao().buscaArtigo(codigo);
          artigo.adicionaAvaliacao(avaliacao);

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
