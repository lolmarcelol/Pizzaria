package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author marce
 */
public class ClienteServlet extends HttpServlet {

   
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        rd.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        Cliente cliente = new Cliente();
        cliente.setLogin(request.getParameter("login"));
        cliente.setSenha(request.getParameter("senha"));
        ClienteManager manager;
        manager = new ClienteManager();
        manager.logar(cliente);
        if(cliente.getId() == 0){
            rd = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            rd.forward(request, response);
        }else{
            request.setAttribute("clienteId", cliente.getId());
            rd = request.getRequestDispatcher("/WEB-INF/jsp/pizza.jsp");
            rd.forward(request, response);
        }
    }

    

}
