package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Ingrediente;

/**
 *
 * @author marce
 */
public class JdbcIngredienteDao implements IngredienteDao {

    private Connection conexão;

    public JdbcIngredienteDao(Connection conexão){
        this.conexão = conexão;
    }
    
    @Override
    public ArrayList<Ingrediente> listarIngrediente() {
        try{
            ArrayList<Ingrediente> ingredientes = new ArrayList(1);
            String query = "SELECT id,nome FROM ingredientes";
            Statement st = conexão.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
            Ingrediente ingredientedb = new Ingrediente(); 
            ingredientedb.setId(rs.getInt("id"));
            ingredientedb.setNome(rs.getString("nome"));
            ingredientes.add(ingredientedb);
            }

            return ingredientes;
        } catch(Exception ex){
            throw new DaoException("Erro ao inserir ingrediente no banco de dados");
            
        }
    
    }
    
}
