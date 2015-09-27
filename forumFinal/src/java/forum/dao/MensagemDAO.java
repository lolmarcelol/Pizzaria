package forum.dao;

import forum.model.Mensagem;
import java.util.ArrayList;

public interface MensagemDAO {
    public ArrayList<Mensagem> getMensagem(int topico_id);
}
