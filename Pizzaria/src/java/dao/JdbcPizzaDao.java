package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            ps = conexão.prepareStatement(query);
            ps.setString(1, pizza.getTipoMassa());
            ps.setString(2, pizza.getTamanho());            
            ps.executeUpdate();
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

  
}
