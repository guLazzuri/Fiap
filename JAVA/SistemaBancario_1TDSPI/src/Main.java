public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema bancário iniciando!!");

        //criando uma conta
        var novaConta = new Conta();
        //coloca o numero da conta
        novaConta.numero = "0001";
        System.out.println("Sua conta é o numero " + novaConta.numero);
        //sacar um valor indevido, porque o saldo atual é de 0 reais
        novaConta.sacar(100);

        //depositar um valor
        novaConta.depositar(1500);
        //apresenta o saldo
        System.out.println("O saldo atual é de: "+novaConta.apresentarSaldo());
        // sacar um valor
        novaConta.sacar(300);
        //apresenta o saldo
        System.out.println("O saldo atual é de: "+novaConta.apresentarSaldo());
        //depositar um valor
        novaConta.depositar(1568.90);
        System.out.println();
        System.out.println("Seu saldo final foi de " + novaConta.apresentarSaldo());
        System.out.println();


        var extrato = novaConta.apresentarExtratoBancario();
        System.out.println("Extrato bancário:");
        for (var movimentacao : extrato){
            System.out.println(movimentacao);
        }

        System.out.println("Sistema bancário encerrando!!");
    }
}