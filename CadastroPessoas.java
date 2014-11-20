import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo
public class CadastroPessoas{
  private String entrada;
  private Revista revista;

  public CadastroPessoas(String entrada, Revista revista) throws FileNotFoundException {
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
          // Salva os dados em variáveis
          String codigo = token.nextToken().trim();
          String nome = token.nextToken().trim();
          String email = token.nextToken().trim();
          //String senha = token.nextToken(); Não há senhas nos arquivos de entrada
          String instituicao = token.nextToken().trim();
          String endereco = token.nextToken().trim();
          System.out.println(endereco);
          String tipo = token.nextToken().trim();

          //Converte o codigo para um valor inteiro
          int cdg = Integer.parseInt(codigo);
          // Cadastra os colaboradores na revista
          if(tipo.equals("A")) {
            Autor autor = new Autor(nome,email,endereco,cdg);
            autor.vinculaInstituicao(instituicao);
            revista.adicionaColaborador(autor);
          }
          else if(tipo.equals("R")) {
            Revisor revisor = new Revisor(nome,email,endereco,cdg);
            revisor.vinculaInstituicao(instituicao);
            revista.adicionaColaborador(revisor);
          } else{
              //Trata a inconsistencia #5 
              Colaborador colaborador = new Colaborador(nome,email,endereco,cdg);
              revista.adicionaColaborador(colaborador);
              Inconsistencia i = new Inconsistencia("O tipo de" + colaborador.getNome() + "não é um tipo válido:" + tipo,5);
              revista.adicionaInconsistencia(i);
            }
      }

    }
    scanner.close();
    revista.imprimeColaboradores();
  }

}
