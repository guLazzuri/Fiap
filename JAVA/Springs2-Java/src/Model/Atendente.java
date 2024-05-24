package Model;

import java.util.Scanner;

public class Atendente {
    private String nomeAtendente;
    private String emailAtendente;
    private String senhaAtendente;

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public void setNomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }

    public String getSenhaAtendente() {
        return senhaAtendente;
    }

    public void setSenhaAtendente(String senhaAtendente) {
        this.senhaAtendente = senhaAtendente;
    }

    public String getEmailAtendente() {
        return emailAtendente;
    }

    public void setEmailAtendente(String emailAtendente) {
        this.emailAtendente = emailAtendente;
    }

    public void receberMensagem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a mensagem que gostaria de enviar a um de nossos atendentes: ");
        String mensagem = sc.nextLine();
        System.out.println("Um de nossos atendentes recebeu sua mensagem com sucesso!");
    }

    public void resolverProblemas(String resposta) {
        System.out.println("Problema resolvido: " + resposta);
    }

    private boolean validarNomeAtendente(String nomeAtendente) {
        String nomeAtendenteRegex = "^[A-Z][a-z]+(?: [A-Z][a-z]+)*$";
        return nomeAtendente.matches(nomeAtendenteRegex);
    }

    private boolean validarEmail(String emailAtendente) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return emailAtendente.matches(emailRegex);
    }

    private boolean validarSenha(String senhaAtendente) {
        String senhaRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return senhaAtendente.matches(senhaRegex);
    }

    public void cadastrarAtendente() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Digite seu nome: ");
            setNomeAtendente(sc.nextLine());
            if (!validarNomeAtendente(getNomeAtendente())) {
                System.out.println("Nome inválido. Por favor, digite um nome válido.");
            }
        } while (!validarNomeAtendente(getNomeAtendente()));

        do {
            System.out.print("Digite seu email: ");
            setEmailAtendente(sc.nextLine());
            if (!validarEmail(getEmailAtendente())) {
                System.out.println("Email inválido. Por favor, digite um email válido.");
            }
        } while (!validarEmail(getEmailAtendente()));

        do {
            System.out.print("Digite sua senha: ");
            setSenhaAtendente(sc.nextLine());
            if (!validarSenha(getSenhaAtendente())) {
                System.out.println("Senha inválida. Por favor, digite uma senha válida.");
                System.out.println("A senha deve ter pelo menos 8 caracteres, uma letra maiúscula, uma letra minúscula, um número e um caractere especial.");
            }
        } while (!validarSenha(getSenhaAtendente()));

        System.out.println("Cadastro realizado com sucesso!");
    }

    public boolean logarAtendente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("LOGIN INICIALIZADO!");

        System.out.print("Email: ");
        String emailLoginAtendente = sc.nextLine();

        System.out.print("Senha: ");
        String senhaLoginAtendente = sc.nextLine();

        return getEmailAtendente().equals(emailLoginAtendente) && getSenhaAtendente().equals(senhaLoginAtendente);
    }
}
