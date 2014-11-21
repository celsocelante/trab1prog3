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
        System.out.println("asdsadas"+autores);

        // Separa os autores e vincula todos a um artigo
        NoncollapsingStringTokenizer token2 = new NoncollapsingStringTokenizer(autores, ",");
        while (token2.hasMoreTokens()){


          int cdg = Integer.parseInt(token2.nextToken().trim());

          Colaborador c = revista.buscaColaborador(cdg);

          System.out.println(c.getNome());
          // Trata a inconsistencia #6: autor não corresponde a um autor no cadastro de pessoas
          if(c==null || !(c instanceof Autor)){
            Inconsistencia i = new Inconsistencia("O código " + cdg + " associado ao artigo " + titulo + " não corresponde a um autor cadastrado.",6);
            revista.adicionaInconsistencia(i);
          }else{
            Autor autor = (Autor)c;
            artigo.vinculaAutor(autor);
           }
        }

        if (token.hasMoreTokens()) {
          int contato = Integer.parseInt(token.nextToken().trim());
          
          Colaborador c = revista.buscaColaborador(contato);
          if(c==null || !(c instanceof Autor)){
            Inconsistencia i = new Inconsistencia("O código " + codigo + " associado ao artigo " + titulo + " não corresponde a um autor cadastrado.",6);
            revista.adicionaInconsistencia(i);
          } else {
            Autor autor = (Autor) c;
            if (artigo.contemAutor(autor))
              artigo.setContato(autor);
            else {
            Inconsistencia i = new Inconsistencia("O código " + contato + " associado ao artigo " + titulo + " não corresponde a um autor cadastrado.",6);
            revista.adicionaInconsistencia(i);
            }
          }
        }
        System.out.println(revista.getEdicao().getTema().getTitulo());

        (revista.getEdicao()).submeterArtigo(artigo);

      }

      // Trata a exceção de arquivo mal formado
      }
      scanner.close();

      (revista.getEdicao()).imprimeArtigos();
    }
}