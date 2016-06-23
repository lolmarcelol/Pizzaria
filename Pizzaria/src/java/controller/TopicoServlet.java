
package controller;

import model.IMensagemManager;
import model.ITopicoManager;
import model.Mensagem;
import model.MensagemManager;
import model.Topico;
import model.TopicoManager;
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
        ArrayList<Mensagem> mensagens = new ArrayList(1);
        String idParam;
        idParam = request.getParameter("id");
        id = Integer.parseInt(idParam);
        
        ArrayList<Topico> topicos;
        ITopicoManager manager;
        manager = new TopicoManager();
        topicos = manager.getTopico(id);
        IMensagemManager Mmanager;
        Mmanager = new MensagemManager();
        for(Topico topico : topicos){
            mensagens.add(Mmanager.getLastMsgById(topico.getId())); 
        }
        request.setAttribute("topicos",topicos);
        request.setAttribute("mensagens", mensagens);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/topico.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       Topico topico = new Topico();
       String idaux;
       idaux = request.getParameter("id");
       int id_topico =Integer.parseInt(idaux);
       topico.setAssunto_id(id_topico);
       topico.setNome(request.getParameter("nome"));
       topico.setCriado_por(request.getParameter("criado_por"));
       TopicoManager manager = new TopicoManager();
       manager = new TopicoManager();
       manager.criaTopico(topico);
      response.setContentType("text/html");
      String site = new String("http://localhost:8080/forumFinal/topico?id="+id_topico);
      response.setStatus(response.SC_MOVED_TEMPORARILY);
      response.setHeader("Location", site); 
        
    }

    

}
