package dao;

import java.util.ArrayList;
import model.Pizza;

public interface PizzaDao {
    public void criarPizza(Pizza pizza);
    public void setPedido(Pizza pizza,Double valor);
    
}
