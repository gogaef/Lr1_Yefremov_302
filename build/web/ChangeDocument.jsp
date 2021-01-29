<%@page import="java.sql.ResultSet"%>
<%@page import="classes.ManagerQuery"%>
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
        <h1>Выберите необходимые поля</h1>
        <form action ="ProcessChangingAgent" method="POST">
            <h2>Введите номер договора(id)</h2>
            <input type="number" name="id" /><br>
            
            <h2>Введите id нового агента</h2>
            <select name="agentId">
             <% 
                while(result.next())
                {
                    %><option value=' <%=result.getInt(1)%>'><%=result.getString(1)%></option><%
                }
            
             %>
            </select>
            <input type="submit" value="Сменить"/>
        </form>
        
        
    </body>
</html>
