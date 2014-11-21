import java.util.*;
import java.io.*;

public class CadastroRevisoes {
  private String entrada;
  private Revista revista;

  public CadastroRevisoes(String entrada, Revista revista) throws FileNotFoundException {
    this.entrada = entrada;
    this.revista = revista;

    File arquivo = new File(entrada);
    Scanner scanner = new Scanner(arquivo);
    String cabecalho = scanner.nextLine();
    
    while (scanner.hasNextLine()) {
        // Obtém todas as linhas do arquivo
        String linha = scanner.nextLine().trim();
        NoncollapsingStringTokenizer token = new NoncollapsingStringTokenizer(linha, ";");
        // Divide cada linha em tokens, de acordo com o delimitador ";"
        while (token.hasMoreTokens()) {
          // Salvo os dados em variáveis
          int codigo = Integer.parseInt(token.nextToken().trim());

          int revisor = Integer.parseInt(token.nextToken().trim());
          
          double originalidade = Double.parseDouble(token.nextToken().replace(',', '.').trim());
          double conteudo = Double.parseDouble(token.nextToken().replace(',', '.').trim());
          double apresentacao = Double.parseDouble(token.nextToken().replace(',', '.').trim());
          
          Colaborador c = revista.buscaColaborador(revisor);
          // Trata inconsistencia #8: revisor em revisoes.csv não está cadastrado
          if(c == null || !(c instanceof Revisor)) {
            Inconsistencia i = new Inconsistencia("O código " + revisor + " encontrado no cadastro de revisões não corresponde a um revisor cadastrado.", 8);
            revista.adicionaInconsistencia(i);
          }
          else {
            Revisor r = (Revisor)c;
            Avaliacao avaliacao = new Avaliacao(r);
            avaliacao.atribuirNota(originalidade,conteudo,apresentacao);

            Artigo artigo = (revista.getEdicao()).buscaArtigo(codigo);
            // Adiciona artigo à lista de artigos revisados por este revisor

            if (artigo == null) {
              // Trata insconsistencia #9: código do artigo não está cadastrado em artigos submetidos à edição
              Inconsistencia i = new Inconsistencia("O código " + codigo + " encontrado no cadastro de revisões não corresponde a um artigo cadastrado.", 9);
              revista.adicionaInconsistencia(i);
            } else {
              artigo.adicionaAvaliacao(avaliacao);
              r.vinculaRevisao(artigo);

              // Trata inconsistencia #10: revisor não habilitado a revisar artigo sob tema da edição
              if(revista.getEdicao().getTema() != null)
                if(!(revista.getEdicao().getTema().contemRevisor(r))){
                  Inconsistencia i = new Inconsistencia("O revisor " + r.getNome() + " avaliou o artigo " + artigo.getTitulo() + ", porém ele não consta como apto a avaliar o tema." + revista.getEdicao().getTema() + ", desta edição.",10);
                  revista.adicionaInconsistencia(i);
                }
            }
          }

        }
      } 
      scanner.close();

      // Trata inconsistencia #11: artigos revisados com menos ou mais de 3 avaliações
      for(Artigo a : revista.getEdicao().getArtigos()){
        if(!(a.quantidadeRevisoes())){
          Inconsistencia i = new Inconsistencia("O artigo " + "\"" + a.getTitulo() + "\"" + " possui " + a.getQuantidadeRevisoes() + " revisões. Cada artigo deve conter exatamente 3 revisões.", 11);
          revista.adicionaInconsistencia(i);
        }
      }
    }

}