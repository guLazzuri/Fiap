import Model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuario1 = null;
        List<Veiculos> veiculosUsuario = new ArrayList<>();
        Oficina oficina = new Oficina(); // Instância única da oficina
        Atendente atendente1 = new Atendente();

        boolean running = true;
        while (running) {
            System.out.println("""
                1-) Cadastrar-se
                2-) Logar a uma conta já existente
                3-) Trabalho na For Wheels
                4-) Sair
                Escolha uma opção: """);

            int opcao = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (opcao) {
                case 1:
                    // Cadastro do usuário
                    usuario1 = new Usuario();
                    usuario1.cadastrarCliente();
                    break;
                case 2:
                    // Login do usuário
                    if (usuario1 == null) {
                        System.out.println("Nenhum usuário cadastrado. Por favor, cadastre-se primeiro.");
                    } else if (usuario1.logarCliente()) {
                        System.out.println("Entrando...");

                        boolean loggedIn = true;
                        while (loggedIn) {
                            // Menu do usuário logado
                            System.out.println("""
                                    1-) Cadastrar veículo.
                                    2-) Mostrar veículos cadastrados.
                                    3-) Mostrar veículos na oficina.
                                    4-) Enviar mensagem a nossa Inteligência Artificial.
                                    5-) Enviar mensagem a nossos atendentes.
                                    6-) Sair.
                                    Escolha uma opção: """);

                            int subOpcao = sc.nextInt();
                            sc.nextLine();

                            switch (subOpcao) {
                                case 1:
                                    // Cadastro de veículo
                                    Veiculos veiculo = new Veiculos();
                                    veiculo.cadastrarVeiculo();
                                    veiculosUsuario.add(veiculo);

                                    // Pergunta se deseja adicionar à oficina
                                    System.out.print("Deseja cadastrar esse veículo na oficina? S/N: ");
                                    String resp = sc.nextLine();
                                    if (resp.equalsIgnoreCase("S")) {
                                        oficina.adicionarVeiculoNaOficina(veiculo);
                                    }
                                    break;
                                case 2:
                                    // Mostra os veículos cadastrados pelo usuário
                                    if (veiculosUsuario.isEmpty()) {
                                        System.out.println("Nenhum veículo cadastrado.");
                                    } else {
                                        System.out.println("Veículos cadastrados:");
                                        for (Veiculos veiculos : veiculosUsuario) {
                                            System.out.println(veiculos.toString() + "\n");
                                        }
                                    }
                                    break;
                                case 3:
                                    // Mostra os veículos na oficina
                                    oficina.mostrarVeiculoNaOficina();
                                    break;
                                case 4:
                                    Chat chat = new Chat();
                                    chat.receberMensagem();
                                    break;
                                case 5:
                                    Atendente atendente = new Atendente();
                                    if (atendente.logarAtendente()) {
                                        atendente.receberMensagem();
                                    }
                                    break;
                                case 6:
                                    loggedIn = false;
                                    System.out.println("Saindo...");
                                    break;
                                default:
                                    System.out.println("Opção inválida, tente novamente.");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Email ou senha incorretos.");
                    }
                    break;
                case 3:
                    // Trabalho na For Wheels (Atendente)
                    Atendente atendente = new Atendente();
                    atendente.cadastrarAtendente();
                    if (atendente.logarAtendente()) {
                        boolean atendenteLoggedIn = true;
                        while (atendenteLoggedIn) {
                            System.out.println("""
                                    1-) Gerar orçamento
                                    2-) Gerar relatório
                                    3-) Resolver problemas
                                    4-) Realizar pagamento
                                    5-) Sair
                                    Escolha uma opção: 
                                    """);

                            int atendenteOption = sc.nextInt();
                            sc.nextLine(); // Consume newline

                            switch (atendenteOption) {
                                case 1:
                                    // Gerar orçamento
                                    Orcamento orcamento = new Orcamento();
                                    orcamento.gerarOrcamento();
                                    orcamento.mostrarOrcamento();
                                    break;
                                case 2:
                                    // Gerar relatório
                                    Relatorio relatorio = new Relatorio();
                                    relatorio.realizarRelatorio();
                                    relatorio.mostrarRelatorio();
                                    break;
                                case 3:
                                    // Resolver problemas
                                    System.out.println("Digite a resposta para o problema: ");
                                    String resposta = sc.nextLine();
                                    atendente.resolverProblemas(resposta);
                                    break;
                                case 4:
                                    // Realizar pagamento
                                    Pagamento pagamento = new Pagamento();
                                    System.out.println("Digite o valor do pagamento: ");
                                    double valorPagamento = sc.nextDouble();
                                    pagamento.realizarPagamento(valorPagamento);
                                    break;
                                case 5:
                                    atendenteLoggedIn = false;
                                    System.out.println("Saindo...");
                                    break;
                                default:
                                    System.out.println("Opção inválida, tente novamente.");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Email ou senha incorretos.");
                    }
                    break;
                case 4:
                    // Sair do programa
                    running = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}
