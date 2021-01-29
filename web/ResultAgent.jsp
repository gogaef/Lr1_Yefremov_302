
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= application.getAttribute("nameProject") %></title>
    </head>
    <body>
        <h3> Агенты: </h3>
        <table border="3">
            <tr><td>Id</td><td>Имя</td><td>Возраст</td><td>Коефициент</td><td>Опыт работы (годы)</td></tr>
            <% 
                 ResultSet result =(ResultSet) request.getAttribute("resultAgent");
                 while(result.next())
                 {
                    %><tr><td><%=result.getString(1)%></td><td><%=result.getString(2)%></td><td><%=result.getString(4)%></td><td><%=result.getString(5)%></td><td><%=result.getString(6)%></td></tr><%
                 }

            %>
        </table>
        <br><br><br>
        <a style = "background:blueviolet; color:white; text-decoration:none; padding: 1rem 1.5rem;" href="WelcomeUser.jsp"> Назад </a>
    </body>
</html>
