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


  public void cadastraArtigos(){
    while (scanner.hasNextLine()) {
      try {
        // Obtém todas as linhas do arquivo
        String linha = scanner.nextLine();
        StringTokenizer token = new StringTokenizer(linha, ";");
        // Divide cada linha em tokens, de acordo com o delimitador ";"
        while (token.hasMoreTokens()) {
          // Salvo os dados em variáveis
          int codigo = Integer.parseInteger(token.nextToken());
          String titulo = token.nextToken();

			 Artigo artigo = new Artigo(codigo, titulo);          
          
          String autores = token.nextToken();
          
          // Separa os autores e vincula todos a um artigo
          StringTokenizer token2 = new StringTokenizer(autores, "\\s*,\\s*");
          while(token2.hasMoreTokens()){
          	artigo.vinculaAutor(revista.buscaColaborador(Integer.parseInt(token2.nextToken())));
          }
          
          int contato = Integer.parseInt(token.nextToken());
			 artigo.setContato(revista.buscaColaborador(contato));
			 
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
