package model;

import dao.IDaoManager;
import dao.JdbcDaoManager;
import dao.MensagemDAO;
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

    @Override
    public void criarMensagem(Mensagem mensagem) {
        IDaoManager manager;
       manager = new JdbcDaoManager();
       
       try{
           manager.iniciar();
           MensagemDAO dao = manager.getMensagemDao();
           dao.criarMensagem(mensagem);
           manager.confirmarTransação();
           manager.encerrar();
       }catch(Exception ex){
           manager.abortarTransação();
           throw ex;
       } 
    }

    @Override
    public int incrementaMensagem(int id){
       IDaoManager manager;
       manager = new JdbcDaoManager();
       int retorno;
       try{
           manager.iniciar();
           MensagemDAO dao = manager.getMensagemDao();
           retorno = dao.incrementaMensagem(id);
           manager.confirmarTransação();
           manager.encerrar();
           return retorno;
       }catch(Exception ex){
           manager.abortarTransação();
           throw ex;
       } 
    }

    @Override
    public Mensagem getLastMsgById(int id) {
       IDaoManager manager;
       manager = new JdbcDaoManager();
       Mensagem mensagem;
       try{
           manager.iniciar();
           MensagemDAO dao = manager.getMensagemDao();
           mensagem = dao.getLastMsgById(id);
           manager.confirmarTransação();
           manager.encerrar();
           return mensagem;
       }catch(Exception ex){
           manager.abortarTransação();
           throw ex;
       } 
    }
}
