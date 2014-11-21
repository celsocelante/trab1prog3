import java.util.*;
import java.text.*;

public class Edicao {

	private int volume, numero;
	private Date data;
	private String mesAno;
	private Tema tema;
	private Set<Artigo> submetidos;
	private Colaborador editorChefe;

	public Edicao (int volume, int numero, String data, Tema tema, Colaborador editorChefe) {
		this.volume = volume;
		this.numero = numero;

		try {
		// Obtém a data no string de acordo com o formato espeficado
		DateFormat formato = new SimpleDateFormat("dd/MM/yy");
		// Converte para o formato padrão de datas
		this.data = formato.parse(data);

		Calendar calendario = new GregorianCalendar();
		calendario.setTime(this.data);
		// Retorna somente o inteiro referente ao mês
		int mes = calendario.get(Calendar.MONTH);
		// Retorna somente o inteiro referente ao ano
		int ano = calendario.get(Calendar.YEAR);
		
		String m="";
		// De acordo com o inteiro do mês, escolhe-se o nome do mês
		switch(mes) {
			case 0: m = "Janeiro"; break;
			case 1: m = "Feveira"; break;
			case 2: m = "Março"; break;
			case 3: m = "Abril"; break;
			case 4: m = "Maio"; break;
			case 5: m = "Junho"; break;
			case 6: m = "Julho"; break;
			case 7: m = "Agosto"; break;
			case 8: m = "Setembro"; break;
			case 9: m = "Outubro"; break;
			case 10: m = "Novembro"; break;
			case 11: m = "Dezembro"; break;
		}
		// Contrói string que exibe a data de forma amigável
		mesAno = m + " de " + ano;

		} catch(ParseException e) {
			e.printStackTrace();
		}


		this.tema = tema;
		this.editorChefe = editorChefe;
		submetidos = new HashSet<Artigo>();
	}
	// Adiciona um artigo lido ao conjunto de artigos submetidos
	public void submeterArtigo(Artigo artigo) {
		submetidos.add(artigo);
	}
	// Busca, pelo código, um artigo no conjunto de artigos submetidos
	public Artigo buscaArtigo(int codigo) {
		for(Artigo a : submetidos){
			if(a.getCodigo() == codigo)
				return a;
		}
		return null;
	}
	// --------------------------------------------
	public void imprimeArtigos() { // REMOVER 
		for (Artigo a : submetidos){
			System.out.println(submetidos.size());
			System.out.println(a.getCodigo());
		}
	}
	// --------------------------------------------

	// Getters e setters
	public Tema getTema() {
		return tema;
	}

	public int getNumero() {
		return numero;
	}

	public int getVolume() {
		return volume;
	}

	public String getData() {
		return mesAno;
	}

	public Colaborador getEditorChefe() {
		return editorChefe;
	}

	public Set<Artigo> getArtigos() {
		return submetidos;
	}

}