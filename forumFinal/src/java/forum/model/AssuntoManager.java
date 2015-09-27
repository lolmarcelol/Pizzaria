package forum.model;

import forum.dao.AssuntoDAO;
import forum.dao.IDaoManager;
import forum.dao.JdbcDaoManager;
import java.util.ArrayList;

public class AssuntoManager implements IAssuntoManager {

    @Override
    public ArrayList<Assunto> getAssunto() {
       IDaoManager manager;
       manager = new JdbcDaoManager();
       
       try{
           manager.iniciar();
           AssuntoDAO dao = manager.getAssuntoDao();
           ArrayList<Assunto> alist;
           alist = dao.getAssunto();
           manager.confirmarTransação();
           manager.encerrar();
           return alist;
       }catch(Exception ex){
           manager.abortarTransação();
           throw ex;
       } 
    }
    
}
