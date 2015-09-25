package forum.dao;

import forum.model.Topico;
import java.sql.Connection;
import java.util.ArrayList;

public class JdbcAssuntoDAO implements AssuntoDAO {
    private Connection conexão;
    
    public JdbcAssuntoDAO(Connection conexão){
        this.conexão = conexão;
    }
    
    @Override
    public ArrayList<Topico> getTopicos(int assunto_id) {
        return null; //implementa a pesquisa no banco de dados.
    }
    
}
