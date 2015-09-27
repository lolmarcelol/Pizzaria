package forum.model;

import java.util.ArrayList;

public interface IMensagemManager {
    
    public ArrayList<Mensagem> getMensagem(int topico_id);
    
}
