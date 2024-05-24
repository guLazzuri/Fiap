public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var filme1 = new Filme();
        filme1.nome = "Ultimato";
        filme1.anoDeLancamento = "2023";

        filme1.exibeFichaTecnica();
        filme1.avalia(8);
        filme1.avalia(5);
        filme1.avalia(10);
        System.out.println(filme1.Somaavaliacao);
        System.out.println(filme1.TotalDeAvaliacao);
        System.out.println(filme1.mediaDasAvaliacoes());



    }
}