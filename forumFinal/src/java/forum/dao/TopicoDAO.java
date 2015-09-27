package forum.dao;

import forum.model.Topico;
import java.util.ArrayList;

public interface TopicoDAO {
    public ArrayList<Topico> getTopico(int assunto_id);
}
