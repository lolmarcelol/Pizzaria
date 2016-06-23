package model;

import dao.IDaoManager;
import dao.JdbcDaoManager;
import dao.TopicoDAO;
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

    @Override
    public void incrementaAcesso(int id_topico) {
       IDaoManager manager;
       manager = new JdbcDaoManager();
       
       try{
           manager.iniciar();
           TopicoDAO dao = manager.getTopicoDao();
           dao.incrementaAcesso(id_topico);
           manager.confirmarTransação();
           manager.encerrar();
       }catch(Exception ex){
           manager.abortarTransação();
           throw ex;
       } 
    }

    @Override
    public void criaTopico(Topico topico) {
       IDaoManager manager;
       manager = new JdbcDaoManager();
       
       try{
           manager.iniciar();
           TopicoDAO dao = manager.getTopicoDao();
           dao.criaTopico(topico);
           manager.confirmarTransação();
           manager.encerrar();
       }catch(Exception ex){
           manager.abortarTransação();
           throw ex;
       } 
    }
    
}
