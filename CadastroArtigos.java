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
    String cabecalho = scanner.nextLine();
    
    while (scanner.hasNextLine()) {
      // Obtém todas as linhas do arquivo
      String linha = scanner.nextLine();
      NoncollapsingStringTokenizer token = new NoncollapsingStringTokenizer(linha, ";");
      // Divide cada linha em tokens, de acordo com o delimitador ";"
      while (token.hasMoreTokens()) {
        // Salvo os dados em variáveis
        int codigo = Integer.parseInt(token.nextToken().trim());
        String titulo = token.nextToken().trim();
        Artigo artigo = new Artigo(codigo, titulo);          

        String autores = token.nextToken().trim();

        // Separa os autores e vincula todos a um artigo
        NoncollapsingStringTokenizer token2 = new NoncollapsingStringTokenizer(autores, ",");
        while(token2.hasMoreTokens()){
          int cdg = Integer.parseInt(token2.nextToken().trim());
          Autor a = (Autor) revista.buscaColaborador(cdg);
          // Trata a inconsistencia #6: autor não corresponde a um autor no cadastro de pessoas
          if(a==null){
            Inconsistencia i = new Inconsistencia("O código " + cdg + " associado ao artigo " + titulo + " não corresponde a um autor cadastrado.",6);
            revista.adicionaInconsistencia(i);
          }else
            artigo.vinculaAutor(a);
        }
        if(token.hasMoreTokens()){
          int contato = Integer.parseInt(token.nextToken().trim());
          Autor a = (Autor) revista.buscaColaborador(contato);
          // Trata a inconsistencia #7: Contato especificado não é um autor do artigo em questão
          if(artigo.contemAutor(a))
            artigo.setContato(a);       
          else{
            Inconsistencia i = new Inconsistencia("O código " + contato + " associado ao artigo " + titulo + " não corresponde a um autor cadastrado.",6);
            revista.adicionaInconsistencia(i);                 
          }
        }

        (revista.getEdicao()).submeterArtigo(artigo);

      }

      // Trata a exceção de arquivo mal formado
      }
      scanner.close();

      (revista.getEdicao()).imprimeArtigos();
    }
}
