package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat {
    private int id;
    private List<String> mensagens;

    public Chat() {
        this.mensagens = new ArrayList<>();
    }

    public void enviarMensagem(String mensagem) {
        mensagens.add(mensagem);
    }

    public List<String> getMensagens() {
        return mensagens;
    }

    public void receberMensagem() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("o que voce gostaria de enviar a nossa IA?");
        String mensagem = sc.nextLine();
        System.out.printf("Nossa Inteligencia Artificial ainda nao esta integrada no sistema, Lamentamaos pelo ocorrrido, logo sera implementada \n");

    }
}
