package forum.dao;

import forum.model.Mensagem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JdbcMensagemDAO implements MensagemDAO {

    private Connection conexão;

    public JdbcMensagemDAO(Connection conexão){
        this.conexão = conexão;
    }
    
    @Override
    public ArrayList<Mensagem> getMensagem(int id_topico) {
        try{
            ArrayList<Mensagem> mensagens = new ArrayList(1);
            String query = "SELECT texto,data,usuario FROM mensagens where topicos_id=" + id_topico;
            Statement st = conexão.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
            Mensagem mensagemdb = new Mensagem(); 
            mensagemdb.setUsuario(rs.getString("usuario"));
            mensagemdb.setText(rs.getString("texto"));
            java.util.Date newDate = rs.getTimestamp("data");
            mensagemdb.setData(newDate);
            mensagens.add(mensagemdb);
            }

            return mensagens;
        } catch(Exception ex){
            throw new DaoException("Erro ao inserir cliente no banco de dados");
            
        }
    }
    
    
}
