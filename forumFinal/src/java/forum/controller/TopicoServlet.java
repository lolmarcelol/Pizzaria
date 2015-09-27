
package forum.controller;

import forum.model.IMensagemManager;
import forum.model.ITopicoManager;
import forum.model.Mensagem;
import forum.model.MensagemManager;
import forum.model.Topico;
import forum.model.TopicoManager;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TopicoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id;
        Mensagem mensagem;
        String idParam;
        idParam = request.getParameter("id");
        id = Integer.parseInt(idParam);
        
        ArrayList<Topico> topicos;
        ITopicoManager manager;
        manager = new TopicoManager();
        topicos = manager.getTopico(id);
        IMensagemManager Mmanager;
        Mmanager = new MensagemManager();
        mensagem = Mmanager.getLastMsgById(id);
        request.setAttribute("topicos",topicos);
        request.setAttribute("mensagem", mensagem);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/topico.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    

}
