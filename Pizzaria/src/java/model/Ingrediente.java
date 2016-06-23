package model;

public class Ingrediente {
    int id;
    String nome;
    int tipoIngrediente;

    public Ingrediente(){
        
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipoIngrediente() {
        return tipoIngrediente;
    }

    public void setTipoIngrediente(int tipoIngrediente) {
        this.tipoIngrediente = tipoIngrediente;
    }
}
