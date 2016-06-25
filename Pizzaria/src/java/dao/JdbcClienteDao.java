package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cliente;
import model.Mensagem;

/**
 *
 * @author marce
 */
public class JdbcClienteDao implements ClienteDao{
    private Connection conexão;

    public JdbcClienteDao(Connection conexão){
        this.conexão = conexão;
    }

    @Override
    public Cliente logar(Cliente cliente) {
        try{
            String query = "SELECT id,login,senha FROM clientes where login=\"" + cliente.getLogin() + "\" and senha =\"" + cliente.getSenha() + "\"";
            Statement st = conexão.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                cliente.setId(rs.getInt("id"));
            }
        return cliente;
        } catch(Exception ex){
            throw new DaoException("Erro ao inserir cliente no banco de dados");
            
        }
        
    }
    
}
