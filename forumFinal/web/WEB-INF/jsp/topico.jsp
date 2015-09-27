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
                <td><h4>1231231</h4></td> <!-- qnt de resposta -->
                <td><h4>${topico.acessos}</h4></td>
                <td width="200">
                    <p>(data) <a href="#" >link</a></p>
                    <p>Por: viadaoaaaaaaaaaaaaaaaaaaaaaaaaaaaa</p>
                </td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>