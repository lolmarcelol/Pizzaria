
package forum.controller;

import forum.model.IMensagemManager;
import forum.model.Mensagem;
import forum.model.MensagemManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MensagemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id;
        String idParam;
        idParam = request.getParameter("id");
        id = Integer.parseInt(idParam);
        
        ArrayList<Mensagem> mensagens;
        IMensagemManager manager;
        manager = new MensagemManager();
        mensagens = manager.getMensagem(id);
        request.setAttribute("mensagens",mensagens);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/mensagem.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
