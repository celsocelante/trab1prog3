import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo
public class CadastroPessoas{
  private String entrada;
  private Revista revista;

  public CadastroPessoas(String entrada, Revista revista) throws FileNotFoundException {
    this.entrada = entrada;
    this.revista = revista;
  }

  public void cadastraPessoas(){
    File arquivo = new File(entrada);
    Scanner scanner = new Scanner(arquivo);

    while (scanner.hasNextLine()) {
      try {
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
          if(tipo.equals("A") {
            revista.adicionaColaborador(new Autor(nome,email,endereco,codigo).vinculaInstituicao(instituicao)); // precisa criar o objeto Instituição
          }

          if(tipo.equals("R") {
            revista.adicionaColaborador(new Revisor(nome,email,endereco,codigo).vinculaInstituicao(instituicao));
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
