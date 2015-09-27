package forum.dao;

import forum.model.Mensagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
            String query = "SELECT texto,date,usuario,topicos_id FROM mensagens where topicos_id=" + id_topico;
            Statement st = conexão.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
            Mensagem mensagemdb = new Mensagem(); 
            mensagemdb.setUsuario(rs.getString("usuario"));
            mensagemdb.setText(rs.getString("texto"));
            java.util.Date newDate = rs.getTimestamp("date");
            mensagemdb.setData(newDate);
            mensagemdb.setTopico_id(rs.getInt("topicos_id"));
            mensagens.add(mensagemdb);
            }

            return mensagens;
        } catch(Exception ex){
            throw new DaoException("Erro ao inserir cliente no banco de dados");
            
        }
    }

    @Override
    public void criarMensagem(Mensagem mensagem) {
            String query = "INSERT INTO mensagens ("
                + "texto,"
                + "usuario,"
                + "topicos_id,"
                + "date )"
                + " VALUES (?,?,?,NOW())";
             PreparedStatement ps;
        try{
            ps = conexão.prepareStatement(query);
            ps.setString(1, mensagem.getText());
            ps.setString(2, mensagem.getUsuario());
            ps.setInt(3, mensagem.getTopico_id());

            
            ps.executeUpdate();
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
    }

    @Override
    public int incrementaMensagem(int id) {
        String query = "UPDATE topicos SET qntMensagem = qntMensagem + 1  WHERE id =" + id;
        int resultado = 0;
        try{
            Statement st = conexão.createStatement();
            st.executeUpdate(query);
        return resultado;
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
    }

    @Override
    public Mensagem getLastMsgById(int id) {
         try{
            String query = "select usuario,max(date) as date from mensagens where topicos_id = " + id;
            Statement st = conexão.createStatement();
            ResultSet rs = st.executeQuery(query);
            Mensagem mensagemdb = new Mensagem(); 
            while (rs.next())
            {
                mensagemdb.setUsuario(rs.getString("usuario"));
                java.util.Date newDate = rs.getTimestamp("date");
                mensagemdb.setData(newDate);
            }

            return mensagemdb;
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
    
    }
}
