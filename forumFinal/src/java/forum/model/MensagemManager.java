package forum.model;

import forum.dao.IDaoManager;
import forum.dao.JdbcDaoManager;
import forum.dao.MensagemDAO;
import java.util.ArrayList;

public class MensagemManager implements IMensagemManager {

    @Override
    public ArrayList<Mensagem> getMensagem(int topico_id) {
       IDaoManager manager;
       manager = new JdbcDaoManager();
       
       try{
           manager.iniciar();
           MensagemDAO dao = manager.getMensagemDao();
           ArrayList<Mensagem> alist;
           alist = dao.getMensagem(topico_id);
           manager.confirmarTransação();
           manager.encerrar();
           return alist;
       }catch(Exception ex){
           manager.abortarTransação();
           throw ex;
       } 
    
    }
}
