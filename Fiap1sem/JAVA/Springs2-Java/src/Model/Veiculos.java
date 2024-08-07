package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Veiculos {

    private String id;
    private String placa;
    private String modelo;
    private int ano;
    private String marca;
    private List<Veiculos> veiculos;

    public Veiculos() {
        this.veiculos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    private boolean validarPlaca(String placa) {
        String placaRegex = "^[A-Z]{3}-[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$";
        return placa.matches(placaRegex);
    }

    private boolean validarMarca(String marca) {
        String marcaRegex = "^[A-Za-z\\s]+$";
        return marca.matches(marcaRegex);
    }

    private boolean validarModelo(String modelo) {
        String modeloRegex = "^[A-Za-z\\s]+$";
        return modelo.matches(modeloRegex);
    }

    public void cadastrarVeiculo() {
        System.out.println("Cadastrando veículo");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Qual a marca do veículo? ");
            String marcaInput = sc.nextLine().trim();
            if (validarMarca(marcaInput)) {
                setMarca(marcaInput);
                break;
            } else {
                System.out.println("Marca inválida. A marca deve conter apenas letras e espaços.");
            }
        }

        while (true) {
            System.out.print("Qual o modelo do veículo? ");
            String modeloInput = sc.nextLine().trim();
            if (validarModelo(modeloInput)) {
                setModelo(modeloInput);
                break;
            } else {
                System.out.println("Modelo inválido. O modelo deve conter apenas letras e espaços.");
            }
        }

        while (true) {
            System.out.print("Qual o ano do veículo? ");
            int anoInput = 0;
            try {
                anoInput = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ano inválido. Digite apenas números.");
                continue;
            }
            if (anoInput <= 1950 || anoInput > 2024) {
                System.out.println("Ano inválido. Tente novamente.");
            } else {
                setAno(anoInput);
                break;
            }
        }

        while (true) {
            System.out.print("Qual a placa do veículo? ");
            String placaInput = sc.nextLine().trim();
            if (validarPlaca(placaInput)) {
                setPlaca(placaInput);
                break;
            } else {
                System.out.println("Placa inválida. Por favor, digite uma placa válida.");
                System.out.println("A placa deve estar no formato 'ABC-1234' ou 'ABC1D23'.");
            }
        }

        System.out.println("Veículo cadastrado com sucesso.");
    }

    public void adicionarVeiculo(Veiculos veiculo) {
        System.out.println("Veículo adicionado com sucesso.");
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculos veiculo) {
        System.out.println("Veículo removido com sucesso.");
        veiculos.remove(veiculo);
    }

    public List<Veiculos> getVeiculos() {
        return veiculos;
    }

    @Override
    public String toString() {
        return "Modelo: " + getModelo() + ", Ano: " + getAno() + ", Marca: " + getMarca() + ", Placa: " + getPlaca();
    }
}
