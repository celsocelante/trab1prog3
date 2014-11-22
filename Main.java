  import java.io.*;
  import java.text.*;

  public class Main {
    public static void main(String[] args) {

      Revista revista = new Revista("EngeSoft");

      InterpretadorDeArgumentos leitura = new InterpretadorDeArgumentos(args);

      // Retorna, depois de interpretado, os nomes dos arquivos de entrada setados por parâmetros
      String[] entradas = leitura.retornaEntradas();
      
      try {
        // Instancia os objetos que fazem a leitura
        CadastroPessoas pessoas = new CadastroPessoas(entradas[2], revista);
        CadastroTemas temas = new CadastroTemas(entradas[1], revista);
        CadastroEdicao edicao = new CadastroEdicao(entradas[0], revista);
        CadastroArtigos artigos = new CadastroArtigos(entradas[3], revista);
        CadastroRevisoes revisoes = new CadastroRevisoes(entradas[4], revista);

      // Caso algum dos arquivos de entrada não exista, retorna "Erro de I/O" e encerra o programa
      } catch(FileNotFoundException e1) {
        System.out.println("Erro de I/O");
        System.exit(1);
        // Caso haja algum problema parsing (converter string que não é número para número)
        } catch(NumberFormatException e2) {
        System.out.println("Erro de formatação");
        System.exit(2);
        }

      try {
        Resumo resumo = new Resumo(revista);
        resumo.escreveResumo();
        // Se não houver inconsistência, registra os relatórios de revisões e revisores
        if(revista.getInconsistencias().isEmpty()){
          RelatorioRevisoes relatRevisoes = new RelatorioRevisoes(revista);
          relatRevisoes.escreveRelatorio();
          
          RelatorioRevisores relatRevisores = new RelatorioRevisores(revista);
          relatRevisores.escreveRelatorio();
        }
      }catch(IOException e3){
        System.out.println("Erro de I/O");
      }


     

    }
  }