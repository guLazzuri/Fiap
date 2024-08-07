public class Filme {
    String nome;
    String anoDeLancamento;
    int tempoDuracao;
    boolean IncluidoNoPlano;
    double Somaavaliacao;
    int TotalDeAvaliacao;
    int DuracaoEmMin;

    public void exibeFichaTecnica(){
        System.out.println("nome do filme: " + nome);
        System.out.println("Ano de Lancamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        Somaavaliacao += nota;
        TotalDeAvaliacao++;
    }

    double mediaDasAvaliacoes(){
        return Somaavaliacao / TotalDeAvaliacao;
    }



}
