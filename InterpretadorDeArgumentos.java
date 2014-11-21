public class InterpretadorDeArgumentos {
	private String[] entradas;

	public InterpretadorDeArgumentos(String[] args){
		entradas = new String[5];

	    if(args.length != 10){
	      // Imprime mensagem de erro se a quantidade ideal de parâmetros não estiver sendo respeitada
	      System.out.println("Erro de I/O");
	      System.exit(1);
	    }

	    // Inicializa todas as posições do vetor com 'null' para verificação posterior
	    for(String e: entradas)
	    	e = null;

	    // Verifica cada elemento do vetor à procura de flags + argumentos
	    for(int i = 0; i < args.length; i++){
	      if(args[i].equals("-e"))
	        entradas[0] = args[i+1];
	      if(args[i].equals("-t"))
	        entradas[1] = args[i+1];
	      if(args[i].equals("-p"))
	        entradas[2] = args[i+1];
	      if(args[i].equals("-a"))
	        entradas[3] = args[i+1];
	      if(args[i].equals("-r"))
	        entradas[4] = args[i+1];
	    }
	    // Verifica se algum dos parametros não foi preenchido
	    if(entradas[0] == null|| entradas[1] == null || entradas[2] == null || entradas[3] == null || entradas[4] == null){
	      System.out.println("Erro de I/O");
	      System.exit(1);
	    }
	}
	// Método para retornar o que foi processado pelo classe
	public String[] retornaEntradas(){
		return entradas;
	}
}