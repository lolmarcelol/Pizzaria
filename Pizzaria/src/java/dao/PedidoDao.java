package dao;

import model.Pizza;

/**
 *
 * @author marce
 */
public interface PedidoDao {
    public void criarPedido(Pizza pizza);
    public void listarPedidoCliente(int idCliente);
    public void listarPedidoPizzaria(int idPizzaria);
}
