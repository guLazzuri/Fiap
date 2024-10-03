import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        // Cadastro usando refelction com o displayname pra ele ser dinamico
        var cliente = new Cliente();
        // Pega todos os campos da classe cliente
        // usar reflection deste jeito é um recurso chamado de introspecção, ou metaprogramação,
        // que é a capacidade de um programa de examinar a si mesmo e de agir de acordo com suas informações.
        var campos = cliente.getClass().getDeclaredFields();
        // pra cada campo da classe cliente
        for(var campo : campos){
            // seta o campo como acessivel, é obrigatorio, senão da erro
            campo.setAccessible(true);
            // pega a anotação DisplayName do campo
            var anotacao = campo.getAnnotation(DisplayName.class);
            // se a anotação não for nula
            if(anotacao != null){
                // imprime a mensagem da anotação
                System.out.println("Digite o valor para " + anotacao.value() + ": ");
                // se o campo for string ou int
                if(campo.getType().equals(String.class)){
                    try{
                        campo.set(cliente, scanner.nextLine());
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(campo.getType().equals(int.class)){
                    try{
                        campo.set(cliente, scanner.nextInt());
                        scanner.nextLine();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println(cliente);
    }
}