import java.io.*;

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

    } catch(FileNotFoundException ex) { // Caso algum dos arquivos não exista
      System.out.println("Erro de I/O");
      System.exit(1); // Encerra a execução do programa
    }


  }
}
