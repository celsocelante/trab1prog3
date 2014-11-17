import java.io.*;
import java.util.*;


public class LeituraBuffer{
	public static void main(String[] args) throws IOException{
		BufferedReader leitor = new BufferedReader(new FileReader("/home/mapprado/Dropbox/Ufes/CC/PROG III/Java/trab1prog3/arquivo.csv"));
			String line;
			while(leitor.ready()){

				line = leitor.readLine();
				StringTokenizer token = new StringTokenizer(line,";");
				while (token.hasMoreTokens()) {
					String element = token.nextToken();
					System.out.println(element);
				}
				
			}
			leitor.close();
			System.out.println("\n");


			Scanner reader = new Scanner(new FileReader("/home/mapprado/Dropbox/Ufes/CC/PROG III/Java/trab1prog3/arquivo.csv")).useDelimiter(";");

			while(reader.hasNext()){
				String nome = reader.next();
				String cidade = reader.next();
				String lugar = reader.next();

				System.out.println(nome);
				System.out.println(cidade);
				System.out.println(lugar);

			}
			reader.close();
		}


	}