package dao;

import model.Topico;
import java.util.ArrayList;

public interface TopicoDAO {
    public ArrayList<Topico> getTopico(int assunto_id);
    public void incrementaAcesso(int topico_id);
    public void criaTopico(Topico topico);
}
