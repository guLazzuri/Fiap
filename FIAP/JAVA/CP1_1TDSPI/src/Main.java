import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Frota> frotas = new ArrayList<>();
    private static List<Veiculo> veiculos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Sistema Iniciando!");

        Menu();
        
        System.out.println("Sistema Finalizado!");
    }

    public static void cadastroBasico(Veiculo veiculo){
        System.out.println("Digite a marca do veiculo: ");
        veiculo.setMarca(scanner.nextLine()); // set é semelhante ao =, mas é um método
        System.out.println("Digite o modelo do veiculo: ");
        veiculo.setModelo(scanner.nextLine());
        System.out.println("Digite o ano do veiculo: ");
        veiculo.setAno(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite o consumo do veiculo: ");
        veiculo.setConsumoPorKm(scanner.nextDouble());
        scanner.nextLine();
    }

    public static Carro cadastrarCarro(){
        var carro = new Carro();
        cadastroBasico(carro);
        return carro;
    }

    public static Caminhao cadastrarCaminhao(){
        var caminhao = new Caminhao();
        cadastroBasico(caminhao);
        System.out.println("Digite a quantidade de eixos do caminhão: ");
        caminhao.setEixos(scanner.nextInt());
        scanner.nextLine();
        return caminhao;
    }

    public static Moto cadastrarMoto(){
        var moto = new Moto();
        cadastroBasico(moto);
        System.out.println("Digite a quantidade de cilindradas da moto: ");
        moto.setCilindradas(scanner.nextInt());
        scanner.nextLine();
        return moto;
    }

    public static void Menu(){
        System.out.println("Bem vindo ao sistema de controle de frotas!");

        while (true) {
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Cadastrar frota");
            System.out.println("2 - Cadastrar veiculo");
            System.out.println("3 - Abastecer veiculo");
            System.out.println("4 - Dirigir veiculo");
            System.out.println("5 - Previsão de autonomia");
            System.out.println("6 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> CadastrarFrota();
                case 2 -> CadastrarVeiculo();
                case 3 -> AbastecerVeiculo();
            }
        }
    }

    public static void CadastrarFrota(){
        System.out.println("Digite o nome da frota: ");
        var nome  = scanner.nextLine();
        frotas.add(new Frota(nome, new ArrayList<>()));
        System.out.println("\u001B[32m"+"Frota " + nome + " cadastrada com sucesso!"+" \u001B[0m");
    }

    public static void CadastrarVeiculo(){
        // Verificar se existem frotas cadastradas
        if(frotas.isEmpty()){
            System.out.println("\u001B[33m" +"Não existem frotas para cadastrar veículos"+ "\u001B[0m");
            return;
        }
        // Listar as frotas no terminal para o usuário escolher
        System.out.println("Digite o número da frota que deseja adicionar o veículo: ");
        for( int i = 0; i < frotas.size(); i++){
            System.out.println(i + " - " + frotas.get(i).getNome());
        }
        int opcao = scanner.nextInt();
        scanner.nextLine();
        // Pego a frota escolhida pelo usuário
        var frota = frotas.get(opcao);
        // Perguntar o tipo de veículo que o usuário deseja adicionar
        System.out.println("Digite o tipo de veículo que deseja adicionar: \r\n" +
                "1 - Carro \r\n" +
                "2 - Caminhão \r\n" +
                "3 - Moto");
        opcao = scanner.nextInt();
        scanner.nextLine();
        // Cadastrar o veículo
        switch (opcao) {
            case 1 -> {
                var carro = cadastrarCarro();
                frota.adicionarVeiculo(carro);
                veiculos.add(carro);
            }
            case 2 -> {
                var caminhao = cadastrarCaminhao();
                frota.adicionarVeiculo(caminhao);
                veiculos.add(caminhao);
            }
            case 3 -> {
                var moto = cadastrarMoto();
                frota.adicionarVeiculo(moto);
                veiculos.add(moto);
            }
            default -> System.out.println("Opção inválida!");
        }
        System.out.println("\u001B[32m"+"Veiculo cadastrada com sucesso!"+" \u001B[0m");
    }

    public static void AbastecerVeiculo(){
        System.out.println("Digite o  número do veículo que deseja abastecer: ");
        for(int i = 0; i < veiculos.size(); i++)
            System.out.println(i + " - " + veiculos.get(i).getModelo() + " " + veiculos.get(i).getMarca());
        int opcao = scanner.nextInt();
        scanner.nextLine();
        var veiculo = veiculos.get(opcao);
        System.out.printf("Digite a quantidade de litros que deseja abastecer no veículo %s %s: \r\n",
                veiculo.getModelo(), veiculo.getMarca());
        double litros = scanner.nextDouble();
        scanner.nextLine();
        veiculo.abastecer(litros);
        System.out.println("\u001B[32m"+"Veiculo abastecido com sucesso!"+" \u001B[0m");
    }
}