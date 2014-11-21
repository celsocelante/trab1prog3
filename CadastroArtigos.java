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

        // Submete o artigo à revista
       (revista.getEdicao()).submeterArtigo(artigo);
         
        Autor autorContato = null;

        String autores = token.nextToken().trim();

        // Separa os autores e vincula todos a um artigo
        NoncollapsingStringTokenizer token2 = new NoncollapsingStringTokenizer(autores, ",");
        while (token2.hasMoreTokens()){
          
          int cdg = Integer.parseInt(token2.nextToken().trim());

          Colaborador c = revista.buscaColaborador(cdg);

          // Trata a inconsistencia #6: autor não corresponde a um autor no cadastro de pessoas
          if(c==null || !(c instanceof Autor)){
            Inconsistencia i = new Inconsistencia("O código " + cdg + " associado ao artigo " + "\"" + titulo + "\"" + " não corresponde a um autor cadastrado.",6);
            revista.adicionaInconsistencia(i);
          }else{
            Autor autor = (Autor)c;
            autorContato = autor;
            artigo.vinculaAutor(autor);
            artigo.setContato(autorContato);
           }
        }

        if (token.hasMoreTokens()) {
          int contato = Integer.parseInt(token.nextToken().trim());
          
          Colaborador c = revista.buscaColaborador(contato);
          if(c==null || !(c instanceof Autor)){
            Inconsistencia i = new Inconsistencia("O código " + codigo + " associado ao artigo " + "\"" + titulo  + "\"" + " não corresponde a um autor cadastrado.",6);
            revista.adicionaInconsistencia(i);
          } else {
            Autor autor = (Autor) c;
            if (artigo.contemAutor(autor))
              artigo.setContato(autor);
            else {
            Inconsistencia i = new Inconsistencia("O código " + "\"" + autor.getNome() + "\"" + " informado como autor de contato não corresponde a um dos autores do artigo " +  "\"" + titulo + "\".",7);
            revista.adicionaInconsistencia(i);
            }
          }
        } 

      }

      }
      scanner.close();
    }
}