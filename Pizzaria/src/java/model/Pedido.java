package model;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    int id;
    ArrayList<Pizza> pizzas;
    String tipoPedido; // Oferta,contra-Oferta,aceito,n aceito

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pizzaria getPizzaria() {
        return pizzaria;
    }

    public void setPizzaria(Pizzaria pizzaria) {
        this.pizzaria = pizzaria;
    }

    public Date getHoraCriacao() {
        return horaCriacao;
    }

    public void setHoraCriacao(Date horaCriacao) {
        this.horaCriacao = horaCriacao;
    }
    Cliente cliente;
    Pizzaria pizzaria; // pode ser null, se null estado n aceito
    Date horaCriacao;

}
