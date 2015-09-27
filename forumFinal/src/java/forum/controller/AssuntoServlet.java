package forum.controller;

import forum.model.Assunto;
import forum.model.AssuntoManager;
import forum.model.IAssuntoManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AssuntoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Assunto> assuntos;
        IAssuntoManager manager;
        manager = new AssuntoManager();
        assuntos = manager.getAssunto();
        request.setAttribute("assuntos",assuntos);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/assunto.jsp");
        rd.forward(request, response);   
    }
}