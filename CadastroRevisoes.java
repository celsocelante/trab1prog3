import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo
public class CadastroRevisoes {
  private String entrada;
  private Revista revista;

  public CadastroRevisoes(String entrada, Revista revista) throws FileNotFoundException {
    this.entrada = entrada;
    this.revista = revista;

    File arquivo = new File(entrada);
    Scanner scanner = new Scanner(arquivo);

    while (scanner.hasNextLine()) {
        // Obtém todas as linhas do arquivo
        String linha = scanner.nextLine().trim();
        StringTokenizer token = new StringTokenizer(linha, ";");
        // Divide cada linha em tokens, de acordo com o delimitador ";"
        while (token.hasMoreTokens()) {
          // Salvo os dados em variáveis
          int codigo = Integer.parseInt(token.nextToken().trim());

          int revisor = Integer.parseInt(token.nextToken().trim());
          Avaliacao avaliacao = new Avaliacao((Revisor) revista.buscaColaborador(revisor));
         
          double originalidade = Double.parseDouble(token.nextToken().replace(',', '.').trim());
          double conteudo = Double.parseDouble(token.nextToken().replace(',', '.').trim());
          double apresentacao = Double.parseDouble(token.nextToken().replace(',', '.').trim());
          
          avaliacao.atribuirNota(originalidade,conteudo,apresentacao);
          Artigo artigo = (revista.getEdicao()).buscaArtigo(codigo);
          artigo.adicionaAvaliacao(avaliacao);

        }
        // Trata a exceção de arquivo mal formado
      } 
      scanner.close();
    }
/*
  public static void main(String[] args){

  }

  public void cadastraRevisoes() {
    
  }*/
}
