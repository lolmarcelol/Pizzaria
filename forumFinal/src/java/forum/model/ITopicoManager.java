package forum.model;

import java.util.ArrayList;

public interface ITopicoManager {
    
    ArrayList<Mensagem> getMensagens(int topico_id);
}
