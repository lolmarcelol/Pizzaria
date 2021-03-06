package forum.dao;

import forum.model.Assunto;
import forum.model.Topico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcTopicoDAO implements TopicoDAO {
    private Connection conexão;

    public JdbcTopicoDAO(Connection conexão){
        this.conexão = conexão;
    }
    
    @Override
    public ArrayList<Topico> getTopico(int assunto_id) {
        try{
            ArrayList<Topico> topicos = new ArrayList(1);
            String query = "SELECT nome,id,acessos,criado_por,qntMensagem FROM topicos where assuntos_id = " + assunto_id;
            Statement st = conexão.createStatement();
            ResultSet rs = st.executeQuery(query);
           
            while (rs.next())
            {
            Topico topicodb = new Topico(); 
            topicodb.setId(rs.getInt("id"));
            topicodb.setNome(rs.getString("nome"));
            topicodb.setAcessos(rs.getInt("acessos"));
            topicodb.setCriado_por(rs.getString("criado_por"));
            topicodb.setQntMensagem(rs.getInt("qntMensagem"));

            topicos.add(topicodb);
            }

            return topicos;
        } catch(Exception ex){
            throw new DaoException("Erro ao inserir cliente no banco de dados");
            
        }
    }

    @Override
    public void incrementaAcesso(int topico_id) {
         try{
            ArrayList<Topico> topicos = new ArrayList(1);
            String query = "UPDATE topicos  SET acessos = acessos + 1  WHERE id =" + topico_id;
            Statement st = conexão.createStatement();
            st.executeUpdate(query);
           
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
        
    }

    
}
