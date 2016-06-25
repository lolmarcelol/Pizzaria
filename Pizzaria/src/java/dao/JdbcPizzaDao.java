package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Pizza;

/**
 *
 * @author marce
 */
public class JdbcPizzaDao implements PizzaDao{

    
    private Connection conexão;

    public JdbcPizzaDao(Connection conexão){
        this.conexão = conexão;
    }
    
    @Override
    public void criarPizza(Pizza pizza) {

 String query = "INSERT INTO pizzas ("
                + "tipoMassa,"
                + "tamanho)"
                + " VALUES (?,?)";
             PreparedStatement ps;
        try{
            ps = conexão.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pizza.getTipoMassa());
            ps.setString(2, pizza.getTamanho());            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            pizza.setId(rs.getInt(1));
            setPizza(pizza);
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }
    }
    
    public void setPizza(Pizza pizza){
        String query = "INSERT INTO pizzas_has_ingredientes ("
                + "pizzas_id,"
                + "ingredientes_id,"
                + "data)"
                + " VALUES (?,?,NOW())";
             PreparedStatement ps;
        try{
            ps = conexão.prepareStatement(query);
            
            for(int i=0;i<pizza.getIngredientes().size();i++){
                ps.setInt(1, pizza.getId());
                ps.setInt(2,pizza.getIngredientes().get(i).getId());
                ps.executeUpdate();
            }            
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
           
        }        
    }

    @Override
    public void setPedido(Pizza pizza, Double valor) {
                String query = "INSERT INTO pedidos ("
                + "idPizza,"
                + "valor,"
                +"tipoPedido)"
                + " VALUES ("+pizza.getId() +",?,\"pendente\")";
             PreparedStatement ps;
        try{
            ps = conexão.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, valor);
            ps.executeUpdate();
        } catch(Exception ex){
            throw new DaoException(ex.getMessage());
            
        }    }
  
}
