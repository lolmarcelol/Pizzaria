package model;

import java.util.ArrayList;
import java.util.Map;

public interface IAssuntoManager {
    
    ArrayList<Assunto> getAssunto();
    Map<String, Integer> getQntTopicos(int assunto_id);
    
}
