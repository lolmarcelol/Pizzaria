package model;

import java.util.ArrayList;

public interface ITopicoManager {
    
    ArrayList<Topico> getTopico(int id_assunto);
    void incrementaAcesso(int id_topico);
    void criaTopico(Topico topico);
}
