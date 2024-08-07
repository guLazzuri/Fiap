package Model;

import java.util.Scanner;

public class Relatorio {
    private String descricao;
    private double preco;
    private String tecnicoResponsavel;
    private String tipoDeConcerto;
    private String data;
    private String nomeCliente;
    private String oficinaNome;
    Scanner sc = new Scanner(System.in);

    public Relatorio() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("O preço não pode ser negativo.");
            // Pode lançar uma exceção aqui se preferir
        }
    }

    public String getTecnicoResponsavel() {
        return tecnicoResponsavel;
    }

    public void setTecnicoResponsavel(String tecnicoResponsavel) {
        this.tecnicoResponsavel = tecnicoResponsavel;
    }

    public String getTipoDeConcerto() {
        return tipoDeConcerto;
    }

    public void setTipoDeConcerto(String tipoDeConcerto) {
        this.tipoDeConcerto = tipoDeConcerto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        // Adicionando uma verificação simples para o formato da data
        if (isValidDate(data)) {
            this.data = data;
        } else {
            System.out.println("Formato de data inválido. Use o formato dd/mm/aaaa.");
            // Pode lançar uma exceção aqui se preferir
        }
    }

    private boolean isValidDate(String data) {
        // Verifica se a data está no formato dd/mm/aaaa
        return data.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getOficinaNome() {
        return oficinaNome;
    }

    public void setOficinaNome(String oficinaNome) {
        this.oficinaNome = oficinaNome;
    }

    public void mostrarRelatorio() {
        System.out.println("GERANDO RELATÓRIO...");
        System.out.println("OFICINA RESPONSÁVEL: " + getOficinaNome());
        System.out.println("Técnico Responsável: " + getTecnicoResponsavel());
        System.out.println("Tipo de Concerto: " + getTipoDeConcerto());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Preço: " + getPreco());
        System.out.println("Data: " + getData());
        System.out.println("Nome do Cliente: " + getNomeCliente());
    }

    public void realizarRelatorio() {
        System.out.println("RELATÓRIO ESTÁ SENDO REALIZADO");
        System.out.print("Descrição do concerto do veículo: ");
        setDescricao(sc.nextLine());

        // Verificação do preço para garantir que seja um número válido
        while (true) {
            System.out.print("Preço do concerto do veículo: ");
            try {
                double preco = Double.parseDouble(sc.nextLine());
                setPreco(preco);
                break; // Saia do loop se o preço for válido
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido para o preço.");
            }
        }

        System.out.print("Tipo de concerto do veículo: ");
        setTipoDeConcerto(sc.nextLine());

        // Loop para garantir uma data válida
        while (true) {
            System.out.print("Data do concerto do veículo (dd/mm/aaaa): ");
            String data = sc.nextLine();
            if (isValidDate(data)) {
                setData(data);
                break; // Saia do loop se a data for válida
            } else {
                System.out.println("Formato de data inválido. Use o formato dd/mm/aaaa.");
            }
        }

        System.out.print("Nome do Cliente: ");
        setNomeCliente(sc.nextLine());
        System.out.print("Nome da oficina que fez o relatório: ");
        setOficinaNome(sc.nextLine());
        System.out.print("Nome do responsável que fez o relatório: ");
        setTecnicoResponsavel(sc.nextLine());
    }
}
