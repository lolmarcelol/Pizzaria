package forum.model;

public class Topico {
    private int id;
    private int acessos;
    private String nome;
    private int assunto_id;
    private String criado_por;

    public Topico(){
        
    }
    
    public int getAssunto_id() {
        return assunto_id;
    }

    public void setAssunto_id(int assunto_id) {
        this.assunto_id = assunto_id;
    }

    public String getCriado_por() {
        return criado_por;
    }

    public void setCriado_por(String criado_por) {
        this.criado_por = criado_por;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcessos() {
        return acessos;
    }

    public void setAcessos(int acessos) {
        this.acessos = acessos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
