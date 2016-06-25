package controller;

import java.util.ArrayList;
import model.Pizza;

public interface IPizzaManager {
    public void criarPizza(Pizza pizza);
    public void setPedido(Pizza pizza,Double valor);

}
