import java.util.*;
import java.io.*;

// Exemplo de leitura de arquivo
public class CadastroEdicao {
  private String entrada;
  private Revista revista;

  public CadastroEdicao(String entrada, Revista revista) throws FileNotFoundException {
    this.entrada = entrada;
    this.revista = revista;

    File arquivo = new File(entrada);
    Scanner scanner = new Scanner(arquivo);

    while (scanner.hasNext()) {
      // A leitura da edição funciona de forma diferente. Precisa ser implementado
      // Obtém todas as linhas do arquivo
      String tema = scanner.nextLine().trim();
      String editor = scanner.nextLine().trim();
      int volume = Integer.parseInt(scanner.nextLine().trim());
      int numero = Integer.parseInt(scanner.nextLine().trim());
      String data = scanner.nextLine().trim();

      Tema t = revista.buscaTema(tema);
      Colaborador c = revista.buscaColaborador(editor);

      if(t==null){
        // Trata inconsistencia #1: tema da edição não cadastrado
        Inconsistencia i = new Inconsistencia("O tema " + tema + " não foi encontrado no cadastro.", 1);
        revista.adicionaInconsistencia(i);
      }else if(c==null){
        // Trata inconsistencia #2: editor-chefe não encontrado no cadastro
        Inconsistencia i = new Inconsistencia("O editor-chefe " + editor + " não foi encontrado no cadastro.", 2);
        revista.adicionaInconsistencia(i);
            } else 
                revista.setEdicao(new Edicao(volume,numero,data,t,c));

      // Trata a exceção de arquivo mal formado
    }
    scanner.close();
  }

}
