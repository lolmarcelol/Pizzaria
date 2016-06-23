package dao;

import model.Assunto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JdbcAssuntoDAO implements AssuntoDAO {
    private Connection conexão;
    
    public JdbcAssuntoDAO(Connection conexão){
        this.conexão = conexão;
    }
    
    @Override
    public ArrayList<Assunto> getAssunto() {
        try{
            ArrayList<Assunto> assuntos = new ArrayList(1);
            String query = "SELECT nome,id FROM assuntos";
            Statement st = conexão.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
            Assunto assuntodb = new Assunto(); 
            assuntodb.setId(rs.getInt("id"));
            assuntodb.setNome(rs.getString("nome"));
            assuntos.add(assuntodb);
            }

            return assuntos;
        } catch(Exception ex){
            throw new DaoException("Erro ao inserir cliente no banco de dados");
            
        }
    }

    @Override
    public Map<String, Integer> getQntTopicos(int assunto_id) {
        try{
            String query = "SELECT COUNT(id),id FROM topicos where assuntos_id ="+assunto_id;
            Statement st = conexão.createStatement();
            ResultSet rs = st.executeQuery(query);
            Map<String, Integer> map = new HashMap<String, Integer>();
            while (rs.next())
            {
                map.put("qnt", rs.getInt("count(id)"));
                map.put("id", rs.getInt("id"));
            }
            return map;
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
    }
    
}
