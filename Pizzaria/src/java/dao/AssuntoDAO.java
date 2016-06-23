package dao;

import model.Assunto;
import java.util.ArrayList;
import java.util.Map;

public interface AssuntoDAO {
        public ArrayList<Assunto> getAssunto();
        Map<String, Integer> getQntTopicos(int assunto_id);
}
