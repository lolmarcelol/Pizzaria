package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ingrediente;
import model.Pizza;

/**
 *
 * @author marce
 */
public class PizzaServlet extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        ArrayList<Ingrediente> ingredientes;
        Cookie[] cookies = request.getCookies();
        if(!cookies[0].getName().equals("ClienteId")){
            rd = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            rd.forward(request, response);
        }
        IIngredienteManager manager;
        manager = new IngredienteManager();
        ingredientes = manager.listarIngrediente();
        request.setAttribute("ingredientes", ingredientes);
        rd = request.getRequestDispatcher("/WEB-INF/jsp/pizza.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Ingrediente> ingredientes = new ArrayList(1);
        Pizza pizza = new Pizza();
        pizza.setTamanho(request.getParameter("tamanho"));
        pizza.setTipoMassa(request.getParameter("massa"));
        PizzaManager manager;
        manager = new PizzaManager();
        for(int i=0;i<4;i++){
            ingredientes.add(new Ingrediente());
            ingredientes.get(i).setId(Integer.parseInt(request.getParameter("ingrediente"+i)));
        }
        pizza.setIngredientes(ingredientes);
        manager.criarPizza(pizza);
        manager.setPedido(pizza,Double.parseDouble(request.getParameter("preco")));
        
    }

}
