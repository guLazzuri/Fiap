package Model;

import java.util.Scanner;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha.trim();
    }

    // Método para validar nome usando regex
    private boolean validarNome(String nome) {
        String nomeRegex = "^[A-Z][a-z]+(?: [A-Z][a-z]+)*$";
        return nome.matches(nomeRegex);
    }

    // Método para validar email usando regex
    private boolean validarEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailRegex);
    }

    // Método para validar senha usando regex
    private boolean validarSenha(String senha) {
        // Pelo menos 8 caracteres, pelo menos 1 letra maiúscula, 1 letra minúscula, 1 número e 1 caractere especial
        String senhaRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return senha.matches(senhaRegex);
    }

    // Método para realizar o cadastro do cliente
    public void cadastrarCliente() {
        Scanner sc = new Scanner(System.in);

        // Solicitar e validar o nome
        do {
            System.out.print("Digite seu nome completo: ");
            setNome(sc.nextLine());
            if (!validarNome(getNome())) {
                System.out.println("Nome inválido. O nome deve começar com uma letra maiúscula e conter apenas letras.");
            }
        } while (!validarNome(getNome()));

        // Solicitar e validar o email
        do {
            System.out.print("Digite seu email: ");
            setEmail(sc.nextLine());
            if (!validarEmail(getEmail())) {
                System.out.println("Email inválido. Por favor, digite um email válido.");
            }
        } while (!validarEmail(getEmail()));

        // Solicitar e validar a senha
        do {
            System.out.print("Digite sua senha: ");
            setSenha(sc.nextLine());
            if (!validarSenha(getSenha())) {
                System.out.println("Senha inválida. A senha deve ter pelo menos 8 caracteres, uma letra maiúscula, uma letra minúscula, um número e um caractere especial.");
            }
        } while (!validarSenha(getSenha()));

        // Confirmação de cadastro
        System.out.println("Cadastro realizado com sucesso!");
    }

    public boolean logarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("LOGIN INICIALIZADO!");
        System.out.print("Email: ");
        String emailLogin = sc.nextLine().trim();
        System.out.print("Senha: ");
        String senhaLogin = sc.nextLine().trim();

        if (getEmail().equals(emailLogin) && getSenha().equals(senhaLogin)) {
            System.out.println("Bem-vindo, " + getNome() + "!");
            return true;
        } else {
            return false;
        }
    }
}
