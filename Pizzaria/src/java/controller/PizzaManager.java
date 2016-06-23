package controller;

import dao.IDaoManager;
import dao.JdbcDaoManager;
import dao.PizzaDao;
import java.util.ArrayList;
import model.Pizza;

/**
 *
 * @author marce
 */
public class PizzaManager implements IPizzaManager {

    @Override
    public void criarPizza(Pizza pizza) {
       IDaoManager manager;
       manager = new JdbcDaoManager();
       
       try{
           manager.iniciar();
           PizzaDao dao = manager.getPizzaDao();
           dao.criarPizza(pizza);
           manager.confirmarTransação();
           manager.encerrar();
       }catch(Exception ex){
           manager.abortarTransação();
           throw ex;
       }     }

  
    
}
