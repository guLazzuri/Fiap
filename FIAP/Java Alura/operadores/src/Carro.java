public class Carro {


       // atributos
        String nome;
        String marca;
        int ano;
        int velocidade;


        //metodos
        void acelerar(int aceleracao){
            velocidade += aceleracao;

        }

        void freiar (int reduzir){
            velocidade -= reduzir;

        }
        void buzinar () {
            System.out.println("bibibi");
        }
    }

