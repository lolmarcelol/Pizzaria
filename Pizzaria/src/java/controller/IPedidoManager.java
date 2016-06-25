package controller;

import model.Pizza;

/**
 *
 * @author marce
 */
public interface IPedidoManager {
    public void criarPedido(Pizza pizza);
    public void listarPedidoCliente(int idCliente);
    public void listarPedidoPizzaria(int idPizzaria);
}
