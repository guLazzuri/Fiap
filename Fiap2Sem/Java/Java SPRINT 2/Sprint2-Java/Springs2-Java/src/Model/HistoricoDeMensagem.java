package Model;

import java.util.List;

public class HistoricoDeMensagem {
    private int id;
    private String titulo;
    List<Chat> chatList;

    public HistoricoDeMensagem() {
    }

    public void adcionarChat(Chat chat) {
        chatList.add(chat);
    }


}
