package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
          response.setContentType("text/html");  
        RequestDispatcher rd;
        
        Cliente cliente = new Cliente();
        cliente.setLogin(request.getParameter("login"));
        cliente.setSenha(request.getParameter("senha"));
        ClienteManager manager;
        manager = new ClienteManager();
        cliente = manager.logar(cliente);
        String aux = Integer.toString(cliente.getId());
        if(cliente.getId() == 0){
            rd = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            rd.forward(request, response);
        }else{
            request.setAttribute("clienteId", cliente.getId());
            Cookie id = new Cookie("ClienteId",aux);
            id.setMaxAge(60*60*24); 
            response.addCookie(id);
            rd = request.getRequestDispatcher("/WEB-INF/jsp/pizza.jsp");
            rd.forward(request, response);
          
        }
    }

    

}
