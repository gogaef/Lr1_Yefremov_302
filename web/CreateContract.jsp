
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="classes.ManagerQuery"%>
<%@page import="java.util.Map"%>
<%@page import="Interfaces.IUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
 Cookie[] cookies =  request.getCookies();
 Cookie permission=null;
 for(Cookie c: cookies)
 {
     if(c.getName().equals("permission"))
     {
         permission=c;
         break;
     }
 }
if(permission.getValue().equals("Agent"))
{
    response.sendRedirect("ErrorPermission.jsp");
}
ManagerQuery q = (ManagerQuery)request.getSession().getAttribute("ManagerQuery");
ResultSet result = q.select("Agent");
%>
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= application.getAttribute("nameProject") %></title>
    </head>
    <body>
        <h1>Выберите необходимые поля</h1><br>
        <form action="ProcessCreatingIsurance" method="POST">
            <h2>Id агента</h2>
            <select name="agentId">
             <% 
                while(result.next())
                {
                    %><option value=' <%=result.getInt(1)%>'><%=result.getString(1)%></option><%
                }
            
             %>
            </select>
        
            <h2>Страховка на: </h2>
            <select name="summa">
                <option value="3000"> Недвижимость </option>
                <option value="2000"> Автомобиль </option>
                <option value="1500"> От получения травм </option>
                <option value="1000"> Мебель </option>
            </select>
            <input type="submit" value="Подтвердить"/>
        </form>
        
    </body>
</html>
