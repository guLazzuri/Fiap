public class carroTeste {
    public static void main(String[] args) {

    Carro c1 = new Carro();

    c1.nome =  "uno";
    c1.marca = "fiat";
    c1.ano = 2020;
    c1.velocidade = 60;

    c1.acelerar( 80);
    System.out.println(c1.velocidade);

    c1.freiar(120);
    System.out.println(c1.velocidade);

    c1.buzinar();

    }
}
