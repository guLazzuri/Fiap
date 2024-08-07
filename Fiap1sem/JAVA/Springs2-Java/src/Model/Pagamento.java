package Model;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pagamento extends Orcamento {
    protected int numeroDoCartao;
    protected String nomeDoTitular;
    protected int cvv;
    protected int validade;
    private double valor;
    private LocalDateTime dataDoPagamento;

    Scanner scanner = new Scanner(System.in);

    // Expressões regulares
    String regexNumeroCartao = "\\d{16}";
    String regexCVV = "\\d{3}";
    String regexValidade = "(0[1-9]|1[0-2])/\\d{2}";

    @Override
    public double getPreco() {
        return super.getPreco();
    }

    @Override
    public void setPreco(double preco) {
        super.setPreco(preco);
    }

    public String getNomeDoTitular() {
        return nomeDoTitular;
    }

    public void setNomeDoTitular(String nomeDoTitular) {
        this.nomeDoTitular = nomeDoTitular;
    }

    public int getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public void setNumeroDoCartao(int numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataDoPagamento() {
        return dataDoPagamento;
    }

    public void setDataDoPagamento(LocalDateTime dataDoPagamento) {
        this.dataDoPagamento = dataDoPagamento;
    }

    // Método para validar número do cartão
    public boolean validarNumeroCartao(String numeroCartao) {
        Pattern pattern = Pattern.compile(regexNumeroCartao);
        Matcher matcher = pattern.matcher(numeroCartao);
        return matcher.matches();
    }

    // Método para validar CVV
    public boolean validarCVV(String cvv) {
        Pattern pattern = Pattern.compile(regexCVV);
        Matcher matcher = pattern.matcher(cvv);
        return matcher.matches();
    }

    // Método para validar data de validade
    public boolean validarValidade(String validade) {
        Pattern pattern = Pattern.compile(regexValidade);
        Matcher matcher = pattern.matcher(validade);
        return matcher.matches();
    }

    public void realizarPagamento(double valorDaCompra) {
        setValor(valorDaCompra); // Definindo o valor do orçamento
        int num = 0;
        System.out.println("""
         1-) Débito 
         2-) Crédito
         3-) Pix
         
         Escolha um dos métodos de pagamento
                """);
        num = scanner.nextInt();
        switch (num) {
            case 1:
                realizarPagamentoPorCartao("Débito");
                break;
            case 2:
                realizarPagamentoPorCartao("Crédito");
                break;
            case 3:
                System.out.println("Pagamento por Pix selecionado.");
                System.out.println("Nossa chave pix é: ForWheels@gmail.com.br");
                System.out.println("Valor do pedido: " + getValor());
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void realizarPagamentoPorCartao(String tipoCartao) {
        System.out.println("Pagamento por " + tipoCartao + " selecionado.");
        System.out.println("Número do cartão: ");
        String numeroCartao = scanner.next();
        if (!validarNumeroCartao(numeroCartao)) {
            System.out.println("Número do cartão inválido!");
            return;
        }

        System.out.println("Nome do titular: ");
        setNomeDoTitular(scanner.next());
        System.out.println("CVV: ");
        String cvv = scanner.next();
        if (!validarCVV(cvv)) {
            System.out.println("CVV inválido!");
            return;
        }

        System.out.println("Validade (MM/AA): ");
        String validade = scanner.next();
        if (!validarValidade(validade)) {
            System.out.println("Data de validade inválida!");
            return;
        }

        this.dataDoPagamento = LocalDateTime.now();
        System.out.println("Data de pagamento: " + dataDoPagamento);
    }

    public boolean verificaPagamento() {
        if (getNumeroDoCartao() == 0 || getCvv() == 0 || getValidade() == 0) {
            System.out.println("Cartão Inválido");
            return false;
        } else {
            System.out.println("Cartão Válido");
            return true;
        }
    }
}