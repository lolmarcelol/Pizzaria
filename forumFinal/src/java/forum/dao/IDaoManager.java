package forum.dao;

import java.util.ArrayList;

public interface IDaoManager 
{
    void iniciar();
    void encerrar();
    void confirmarTransação();
    void abortarTransação();
    AssuntoDAO getAssuntoDao();
    TopicoDAO getTopicoDao();
    MensagemDAO getMensagemDao();
}