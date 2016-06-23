package controller;

import dao.IDaoManager;
import dao.IngredienteDao;
import dao.JdbcDaoManager;
import dao.PizzaDao;
import java.util.ArrayList;
import model.Ingrediente;

/**
 *
 * @author marce
 */
public class IngredienteManager implements IIngredienteManager {

    @Override
    public ArrayList<Ingrediente> listarIngrediente() {
       IDaoManager manager;
       manager = new JdbcDaoManager();
       ArrayList<Ingrediente> ingredientes;
       try{
           manager.iniciar();
           IngredienteDao dao = manager.getIngredienteDao();
           ingredientes = dao.listarIngrediente();
           manager.confirmarTransação();
           manager.encerrar();
       }catch(Exception ex){
           manager.abortarTransação();
           throw ex;
       }
    return ingredientes;
    }
    
}
