<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="forum.model.Mensagem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
.center{
    margin: auto;
    width: 60%;
    padding: 10px;
}
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tópicos</title>
    </head>
    <body>
    <c:forEach var="mensagem" items="${mensagens}">
        <div>
            <div style="background-color:#33ffff;" class="center">
                <h4>
                ${mensagem.usuario}
                </h4>
                <p>
                ${mensagem.data}
                </p>
                <textarea>${mensagem.text}</textarea>
            </div>
        </div>
    </c:forEach>
        <div style="background-color:#ccffff;" class="center">
            <p> Deseja responder? digite a baixo sua mensagem </p>
            <textarea type="text" name='text'></textarea>
            <button> responder </button>
            <p> Digite um username </p>
            <input type='text' name='usuario'/>
        </div>
    </body>
</html>
