<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Ingrediente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Pizza</title>
    </head>
    <body>
        <h1>Daew lesk, escolha as parada da sua pizza !!!</h1>
        <form method="POST">
            <input type="radio" name="tamanho" value="medio"> Medio<br>
            <input type="radio" name="tamanho" value="grande"> Grande<br>
            <input type="radio" name="tamanho" value="gigante"> Gigante<br>
            
            <select name="ingrediente0">
                <option value="options">Opçoes</option>
                <c:forEach var="ingrediente" items="${ingredientes}">
                    <option value="${ingrediente.id}">${ingrediente.nome}</option>
                </c:forEach>

            </select>
             
            <select name="ingrediente1">
                <option value="options">Ingrediente</option>
                <c:forEach var="ingrediente" items="${ingredientes}">
                    <option value="${ingrediente.id}">${ingrediente.nome}</option>
                </c:forEach>
            </select>
            <select name="ingrediente2">
                <option value="options">Ingrediente</option>
                <c:forEach var="ingrediente" items="${ingredientes}">
                    <option value="${ingrediente.id}">${ingrediente.nome}</option>
                </c:forEach>
            </select>
            <select name="ingrediente3">
                <option value="options">Ingrediente</option>
                <c:forEach var="ingrediente" items="${ingredientes}">
                    <option value="${ingrediente.id}">${ingrediente.nome}</option>
                </c:forEach>
            </select>
                       
            <br>
            Preço
            <br>
            <input type="text" name="preco">
            <br>
            <input type="submit" value="Enviar Proposta"/>
        </form>

    </body>
</html>
