package model;

import java.util.ArrayList;

public class Pizza {
    int id;
    double valor;
    String tipoMassa;
    ArrayList<Ingrediente> ingredientes; 
    String tamanho;

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipoMassa() {
        return tipoMassa;
    }

    public void setTipoMassa(String tipoMassa) {
        this.tipoMassa = tipoMassa;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
            
    
}
