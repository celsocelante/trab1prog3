import java.io.*;

public class Main {
  public static void main(String[] args) {

    Revista revista = new Revista("EngeSoft");

    String e = "NULL";
    String t = "NULL";
    String p = "NULL";
    String a = "NULL";
    String r = "NULL";

    if(args.length != 10){
      // Lança exceção se a quantidade ideal de parâmetros não estiver sendo respeitada
      System.out.println("Argumentos insuficientes");
    }
    // Verifica cada elemento do vetor à procura de flags + argumentos
    for(int i = 0; i < args.length; i++){
      if(args[i].equals("-e"))
        e = args[i+1];
      if(args[i].equals("-t"))
        t = args[i+1];
      if(args[i].equals("-p"))
        p = args[i+1];
      if(args[i].equals("-a"))
        a = args[i+1];
      if(args[i].equals("-r"))
        r = args[i+1];
    }

    if(e.equals("NULL") || t.equals("NULL") || p.equals("NULL") || a.equals("NULL") || r.equals("NULL")){
      //tem arugmentos repetidos
      System.out.println("Argumentos incorretos");
    }

    // Instancia os objetos que fazem a leitura
    try {
      CadastroPessoas pessoas = new CadastroPessoas(p, revista);
      CadastroTemas temas = new CadastroTemas(t, revista);
      CadastroEdicao edicao = new CadastroEdicao(e, revista);
      CadastroArtigos artigos = new CadastroArtigos(a, revista);
      CadastroRevisoes revisoes = new CadastroRevisoes(r, revista);
    } catch(FileNotFoundException ex){
      System.out.println("Algum dos arquivos não existe"); // Tratar esta exceção
    }


  }
}
