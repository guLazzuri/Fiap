package Model;

import java.util.Scanner;

public class Orcamento extends Relatorio {
    private String descricao;
    private double preco;
    private static final Scanner sc = new Scanner(System.in);

    public Orcamento() {
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao != null && !descricao.trim().isEmpty()) {
            this.descricao = descricao;
        } else {
            throw new IllegalArgumentException("A descrição não pode estar vazia.");
        }
    }

    @Override
    public String toString() {
        return "Orcamento{" +
                "descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

    public void gerarOrcamento() {
        System.out.println("GERANDO ORÇAMENTO");

        // Validar nome do cliente
        System.out.println("Digite o nome do Cliente: ");
        String nomeCliente = sc.nextLine().trim();
        if (nomeCliente.isEmpty() || nomeCliente.matches("\\d+")) {
            throw new IllegalArgumentException("O nome do cliente não pode ser vazio ou numérico.");
        }
        setNomeCliente(nomeCliente);

        // Validar tipo de concerto
        System.out.println("Digite o tipo de concerto: ");
        String tipoDeConcerto = sc.nextLine().trim();
        if (tipoDeConcerto.isEmpty()) {
            throw new IllegalArgumentException("O tipo de concerto não pode estar vazio.");
        }
        setTipoDeConcerto(tipoDeConcerto);

        // Validar data
        System.out.println("Digite a data do Cliente (no formato dd/mm/aaaa): ");
        setData(sc.nextLine().trim());

        // Validar descrição
        System.out.println("Digite a descrição do orçamento: ");
        String descricao = sc.nextLine().trim();
        if (descricao.isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode estar vazia.");
        }
        setDescricao(descricao);

        // Validar preço
        System.out.println("Digite o preço do orçamento: ");
        setPreco(getDoubleInput());
    }

    public void mostrarOrcamento() {
        System.out.println("MOSTRANDO ORÇAMENTO");
        System.out.println("Nome do Cliente: " + getNomeCliente());
        System.out.println("Tipo de concerto: " + getTipoDeConcerto());
        System.out.println("Data: " + getData());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Preço: " + getPreco());
    }

    private static double getDoubleInput() {
        while (true) {
            System.out.println("Por favor, insira um número decimal:");
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                System.out.println("Entrada inválida. Tente novamente.");
                sc.next(); // Limpa o buffer do scanner
            }
        }
    }
}
