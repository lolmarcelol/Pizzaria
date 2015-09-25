package forum.dao;

import forum.model.Topico;
import java.util.ArrayList;

public interface AssuntoDAO {
    
        ArrayList<Topico> getTopicos(int assunto_id);

    
}
