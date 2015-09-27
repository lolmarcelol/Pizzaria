<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="forum.model.Assunto"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tópicos</title>
    </head>
    <body>
        <table>
            <tr>
                <th>
                    Assuntos
                </th>
                <th>
                    qntTópicos
                </th>
                <th>
                    qntMensagens
                </th>
                <th>
                    Ultima Mensagem
                </th>
            </tr>
            <c:forEach var="assunto" items="${assuntos}">
            <tr>
                <td><a href="topico?id=${assunto.id}"><p> ${assunto.nome}</p></a></td>
                <td><h4>123123</h4></td>
                <td><h4>1231231</h4></td>
                <td width="200">
                    <p>(dd/mm/YYYY) <a href="#" >link</a></p>
                    <p>Por: usuario</p>
                </td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>