<%-- 
    Document   : erro
    Created on : 25/09/2019, 22:51:39
    Author     : 18114290048
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Deu Ruim!</h1>
        <p>Mensagem do erro: <%=exception.getMessage()%></p>
    </body>
</html>
