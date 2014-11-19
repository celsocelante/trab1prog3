import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo
public class CadastroArtigos {
  private String entrada;
  private Revista revista;
  public CadastroArtigos(String entrada, Revista revista) {
    this.entrada = entrada;
    this.revista = revista;
  }

  File arquivo = new File(entrada);
  Scanner scanner = new Scanner(arquivo);


  public void cadastraArtigos() {
    while (scanner.hasNextLine()) {
        // Obtém todas as linhas do arquivo
        String linha = scanner.nextLine();
        StringTokenizer token = new StringTokenizer(linha, ";");
        // Divide cada linha em tokens, de acordo com o delimitador ";"
        while (token.hasMoreTokens()) {
          // Salvo os dados em variáveis
          int codigo = Integer.parseInt(token.nextToken());
          String titulo = token.nextToken();

			 Artigo artigo = new Artigo(codigo, titulo);          
          
          String autores = token.nextToken();
          
          // Separa os autores e vincula todos a um artigo
          StringTokenizer token2 = new StringTokenizer(autores, "\\s*,\\s*");
          while(token2.hasMoreTokens()){
          	artigo.vinculaAutor((Autor) revista.buscaColaborador(Integer.parseInt(token2.nextToken())));
          }
          
          int contato = Integer.parseInt(token.nextToken());
			 artigo.setContato((Autor) revista.buscaColaborador(contato));
			 
        }
        // Trata a exceção de arquivo mal formado
      } 
    }
    scanner.close();
  }
}
