import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo
public class CadastroArtigos {
  private String entrada;
  private Revista revista;

  public CadastroArtigos(String entrada, Revista revista) throws FileNotFoundException {
    this.entrada = entrada;
    this.revista = revista;

    File arquivo = new File(entrada);
    Scanner scanner = new Scanner(arquivo);

    while (scanner.hasNextLine()) {
      // Obtém todas as linhas do arquivo
      String linha = scanner.nextLine();
      StringTokenizer token = new StringTokenizer(linha, ";");
      // Divide cada linha em tokens, de acordo com o delimitador ";"
      while (token.hasMoreTokens()) {
        // Salvo os dados em variáveis
        int codigo = Integer.parseInt(token.nextToken().trim());
        String titulo = token.nextToken().trim();
        Artigo artigo = new Artigo(codigo, titulo);          

        String autores = token.nextToken().trim();

        // Separa os autores e vincula todos a um artigo
        StringTokenizer token2 = new StringTokenizer(autores, ",");
        while(token2.hasMoreTokens()){
          artigo.vinculaAutor((Autor) revista.buscaColaborador(Integer.parseInt(token2.nextToken().trim())));
        }

        if(token.hasMoreTokens()){
          int contato = Integer.parseInt(token.nextToken().trim());
          artigo.setContato((Autor) revista.buscaColaborador(contato));
        }

        (revista.getEdicao()).submeterArtigo(artigo);

      }

      // Trata a exceção de arquivo mal formado
      }
      scanner.close();

      (revista.getEdicao()).imprimeArtigos();
    }
}
