package forum.model;

import forum.dao.IDaoManager;
import forum.dao.JdbcDaoManager;
import forum.dao.TopicoDAO;
import java.util.ArrayList;

public class TopicoManager implements ITopicoManager {

    @Override
    public ArrayList<Topico> getTopico(int assunto_id) {
       IDaoManager manager;
       manager = new JdbcDaoManager();
       
       try{
           manager.iniciar();
           TopicoDAO dao = manager.getTopicoDao();
           ArrayList<Topico> alist;
           alist = dao.getTopico(assunto_id);
           manager.confirmarTransação();
           manager.encerrar();
           return alist;
       }catch(Exception ex){
           manager.abortarTransação();
           throw ex;
       } 
    }
    
}
