<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="forum.model.Topico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tópicos</title>
    </head>
    <body>
        <br><br><br>
        
        <table>
            <tr>
                <th>
                    tópico
                </th>
                <th>
                    Autor
                </th>
                <th>
                    Qnt resposta
                </th>
                <th>
                Numero de acessos
                </th>
                <th>
                Ultima msg
                </th>
            </tr>
            <c:forEach var="topico" items="${topicos}">
            <tr>
                <td><a href="mensagem?id=${topico.id}"><h4> ${topico.nome}</h4></a></td>
                <td><h4>${topico.criado_por}</h4></td>
                <td><h4>${topico.qntMensagem}</h4></td>
                <td><h4>${topico.acessos}</h4></td>
                <td width="200">
                    <p>${mensagem[0].usuario}</p>
                    <c:forEach var="mensagem" items="${mensagens}">
                        <c:if test="${topico.id == mensagem.topico_id}">
                            <p>(${mensagem.data}) <a href="mensagem?id=${topico.id}">link</a></p> 
                            <p>Por: ${mensagem.usuario}</p>
                        </c:if>
                     </c:forEach>
                </td>
            </tr>
            </c:forEach>
        </table>
        <form method="POST">
            <p> Escreva o nome do novo tópico </p>
            <textarea type="text" name='nome'></textarea>
            <p> Digite um username </p>
            <input type='text' name='criado_por'/>
            <input type="hidden" name="topico_id" value="${topicos[0].assunto_id}"/>
            <br><br><input type="submit" value="Criar"/>
        </form>
    </body>
</html>