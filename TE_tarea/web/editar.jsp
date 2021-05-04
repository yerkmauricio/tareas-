<%@page import="com.emergentes.modelo.Libro" %>
<%
    Libro libro = (Libro) request.getAttribute("libro");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo Libro</h1>
        <form action="MainController" method="POST">
            <table border="1" cellspacing="1">
                <input type="hidden" name="id" value="${libro.id}" />
                <tr>
                    <td>TAREA</td>
                    <td><input type="text" name="tarea" value="${libro.tarea}" /></td>
                </tr>
                <tr>
                    <td>PRIORIDAD</td>
                    <td><input type="number" name="prioridad" value="${libro.prioridad}" /></td>
                </tr>
                <tr>
                    <td>COMPLETADO</td>
                    <td><input type="number" name="completado" value="${libro.completado}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
