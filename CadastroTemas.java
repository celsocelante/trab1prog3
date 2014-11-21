import java.util.*;
import java.io.*;

public class CadastroTemas {
  private String entrada;
  private Revista revista;
  Tema tema;

  public CadastroTemas(String entrada, Revista revista) throws FileNotFoundException {
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
          String nome = token.nextToken().trim();
          String revisores = token.nextToken().trim(); 

          // Cria um novo tema e salva a referência para esse objeto
          tema = new Tema(nome,codigo);

          // Adiciona o tema à revista
          revista.adicionaTema(tema);

          // Quebra o string de vários revisores separados por vírgula para vinculá-los ao tema
          NoncollapsingStringTokenizer revisor = new NoncollapsingStringTokenizer(revisores,",");
          while (revisor.hasMoreTokens()) {
            // Procura o colaborador no conjunto de colaboradores da revista
            int cdg = Integer.parseInt(revisor.nextToken().trim());
            Colaborador c = revista.buscaColaborador(cdg);
            // Trata a inconsistencia #3: não há revisor correspondente no cadastro de pessoas
            if (c == null || c instanceof Autor) {
              Inconsistencia i = new Inconsistencia("O código " + cdg + " associado ao tema " + "\"" + nome + "\"" + " nao corresponde a um revisor cadastrado.",3);
              revista.adicionaInconsistencia(i);
            }
            else { 
              Revisor r = (Revisor) c;
              tema.vinculaRevisor(r);
            }
          }
          if (tema.getQuantidadeRevisores() < 3) {
            // Trata a inconsistencia #4: tema com menos de 3 revisores
            Inconsistencia i = new Inconsistencia("O tema " + "\"" + nome + "\"" + " possui apenas " + tema.getQuantidadeRevisores() + ". São necessários no minimo 3.", 4);
            revista.adicionaInconsistencia(i);
          }

        }
      } 
      scanner.close();
    }
}