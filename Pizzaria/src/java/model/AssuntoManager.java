package model;

import dao.AssuntoDAO;
import dao.IDaoManager;
import dao.JdbcDaoManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    @Override
    public Map<String, Integer> getQntTopicos(int assunto_id) {
       IDaoManager manager;
       manager = new JdbcDaoManager();
       
       try{
           manager.iniciar();
           AssuntoDAO dao = manager.getAssuntoDao();
           Map<String, Integer> map = new HashMap<String, Integer>();
           map = dao.getQntTopicos(assunto_id);
           manager.confirmarTransação();
           manager.encerrar();
           return map;
       }catch(Exception ex){
           manager.abortarTransação();
           throw ex;
       } 
    }
    
}
