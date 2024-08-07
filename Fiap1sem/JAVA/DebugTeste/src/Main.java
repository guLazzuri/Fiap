import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String ANSI_YELLOW = "\u001B[33m";

    static List<Produto> catalogo = new ArrayList<>();
    public static void main(String[] args) {
        while(true)
            IniciarMenu();
    }

    public static void IniciarMenu(){
        var scanner = new Scanner(System.in);
        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Remover produto");
        System.out.println("4 - Sair");
        System.out.println("Opção: ");

        var opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> AdicionarProduto();
            case 2 -> ListarProdutos();
            case 3 -> RemoverProduto();
            case 4 -> System.exit(0);
            default -> System.out.println("Opção inválida");
        }
    }

    public static void AdicionarProduto(){
        var scanner = new Scanner(System.in);
        System.out.println("Nome do produto: ");
        var nome  = scanner.nextLine();

        var preco = 0.0;
        var precoValido = false;
        while (!precoValido) {
            System.out.println("Preço do produto, ex: 10.50");
            var precoTexto = scanner.nextLine();
            try{
                preco = Double.parseDouble(precoTexto);
                precoValido = true;
            }
            catch(Exception e){
                System.out.println(ANSI_YELLOW +
                        "Preço inválido, digite novamente o preço, que precisa ser um número sem caracteres especiais." +
                        ANSI_RESET);
            }
        }

        catalogo.add(new Produto(nome, preco));
    }

    public static void ListarProdutos(){
        catalogo.forEach(System.out::println);
    }

    public static void RemoverProduto(){
        //TODO: Implementar a remoção de produtos
        throw new UnsupportedOperationException("Método não implementado");
    }
}