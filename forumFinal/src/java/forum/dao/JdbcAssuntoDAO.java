package forum.dao;

import forum.model.Assunto;
import forum.model.Topico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
    
}
