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
                    <p>(${mensagem.data}) <a href="mensagem?id=${topico.id}">link</a></p> <!-- Problema, pois eles só faz 1x e seta os dois...  -->
                    <p>Por: ${mensagem.usuario}</p>
                </td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>