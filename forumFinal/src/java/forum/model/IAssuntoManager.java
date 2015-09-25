package forum.model;

import java.util.ArrayList;

public interface IAssuntoManager {
    
    ArrayList<Topico> getTopicos(int assunto_id);
    
}
