import java.io.*;

public class Main {
  public static void main(String[] args) throws ArgumentosInsuficientesException {
    String e = "NULL";
    String t = "NULL";
    String p = "NULL";
    String a = "NULL";
    String r = "NULL";

    if(args.length != 10){
      // Lança exceção se a quantidade ideal de parâmetros não estiver sendo respeitada
      throw new ArgumentosInsuficientesException();
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
  }
}
