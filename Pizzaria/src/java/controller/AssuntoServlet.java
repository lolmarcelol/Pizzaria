package controller;

import model.Assunto;
import model.AssuntoManager;
import model.IAssuntoManager;
import model.IMensagemManager;
import model.MensagemManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
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
        ArrayList<Map<String, Integer>> id = new ArrayList(1);
        IAssuntoManager manager;
        manager = new AssuntoManager();
        assuntos = manager.getAssunto();
        for(Assunto assunto : assuntos){
            id.add(manager.getQntTopicos(assunto.getId()));
        }
        request.setAttribute("qntTopicos",id);
        request.setAttribute("assuntos",assuntos);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/assunto.jsp");
        rd.forward(request, response);   
    }
}