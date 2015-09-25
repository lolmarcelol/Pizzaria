
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
                    Assuntos
                </th>
                <th>
                    Tópicos
                </th>
                <th>
                    Mensagens
                </th>
                <th>
                    Ultima Mensagem
                </th>
            </tr>
			<!-- foreach para cada topico -->
            <tr>
                <td><h4>Assunto1</td>
                <td><h4>123123</h4></td>
                <td>
                    <h4>1231231</h4>
                </td>
                <td width="200">
                    <p>(dd/mm/YYYY) <a href="#" >link</a></p>
                    <p>Por: usuario</p>
                </td>
            </tr>
            <!-- fim do foreach -->
        </table>
    </body>
</html>