package forum.model;

import java.util.ArrayList;

public interface IMensagemManager {
    
    public ArrayList<Mensagem> getMensagem(int topico_id);
    public void criarMensagem(Mensagem mensagem);
    public int incrementaMensagem(int id);
    public Mensagem getLastMsgById(int id);
}
