import java.io.*;
import java.text.*;

public class Main {
  public static void main(String[] args) {

    Revista revista = new Revista("EngeSoft");

    Leitura leitura = new Leitura(args);
    String[] entradas = leitura.retornaEntradas();

    
    try {
      // Instancia os objetos que fazem a leitura
      CadastroPessoas pessoas = new CadastroPessoas(entradas[2], revista);
      CadastroTemas temas = new CadastroTemas(entradas[1], revista);
      CadastroEdicao edicao = new CadastroEdicao(entradas[0], revista);
      CadastroArtigos artigos = new CadastroArtigos(entradas[3], revista);
      CadastroRevisoes revisoes = new CadastroRevisoes(entradas[4], revista);

    } catch(FileNotFoundException e1) { // Caso algum dos arquivos não exista
      System.out.println("Erro de I/O");
      System.exit(1); // Encerra a execução do programa
      } catch(NumberFormatException e2){
      System.out.println("Erro de formatação");
      System.exit(2);
        }

    try{
      Resumo resumo = new Resumo(revista);
      resumo.escreveResumo();
    }catch(IOException e3){
      System.out.println("As");
    }


   

  }
}
