import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo
public class CadastroPessoas{
  private String entrada;
  private Revista revista;

  public CadastroPessoas(String entrada, Revista revista){
    this.entrada = entrada;
    this.revista = revista;
  }

  public void cadastraPessoas() {
    File arquivo = new File(entrada);
    Scanner scanner = new Scanner(arquivo);

    while (scanner.hasNextLine()) {
        // Obtém todas as linhas do arquivo
        String linha = scanner.nextLine();
        StringTokenizer token = new StringTokenizer(linha, ";");


        // Divide cada linha em tokens, de acordo com o delimitador ";"
        while (token.hasMoreTokens()) {
          // Salva os dados em variáveis
          String codigo = token.nextToken();
          String nome = token.nextToken();
          String email = token.nextToken();
          //String senha = token.nextToken(); Não há senhas nos arquivos de entrada
          String instituicao = token.nextToken();
          String endereco = token.nextToken();
          String tipo = token.nextToken();

          //Converte o codigo para um valor inteiro
          int cdg = Integer.parseInt(codigo);
          // Cadastra os colaboradores na revista
          if(tipo.equals("A")) {
            Autor autor = new Autor(nome,email,endereco,cdg);
            autor.vinculaInstituicao(instituicao);
            revista.adicionaColaborador(autor);
          }

          if(tipo.equals("R")) {
            Autor autor = new Autor(nome,email,endereco,cdg);
            autor.vinculaInstituicao(instituicao);
            revista.adicionaColaborador(autor);
        }

        // Trata a exceção de arquivo mal formado
      }

    }
    scanner.close();
  }



}
