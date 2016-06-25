package controller;

import dao.ClienteDao;
import dao.IDaoManager;
import dao.JdbcDaoManager;
import dao.PizzaDao;
import model.Cliente;

public class ClienteManager implements IClienteManager{

    @Override
    public Cliente logar(Cliente cliente) {
       IDaoManager manager;
       manager = new JdbcDaoManager();
       try{
           manager.iniciar();
           ClienteDao dao = manager.getClienteDao();
           cliente = dao.logar(cliente);
           manager.confirmarTransação();
           manager.encerrar();
          return cliente;
       }catch(Exception ex){
           manager.abortarTransação();
           throw ex;
       } 
    }
    
}
