package forum.model;

import java.util.Date;

public class Mensagem {
    private int id;
    private int topico_id;
    private Date data;
    private String text;
    private String usuario;
    
    public Mensagem(){
        
    }
  public int getTopico_id() {
        return topico_id;
    }

    public void setTopico_id(int topico_id) {
        this.topico_id = topico_id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
