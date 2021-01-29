
<%@page import="Interfaces.IUser"%>
<%@page import="classes.ManagerQuery"%>
<%@page import="classes.Client"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
IUser user = (IUser)request.getSession().getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= application.getAttribute("nameProject") %></title>
    </head>
    <body>
        <h1 align="center">Вы авторизовались как:  <%= user.getValues().get("name") %>!</h1>
        <h2 align="center">Меню</h2>
        <table width="100%" cellspacing="0" cellpadding="4">
            <tr>
                <td align="center" width="100">
                    <a style = "background:lime; color:white; text-decoration:none; padding: 1rem 1.5rem;" href="CreateContract.jsp">Новая страховка</a>
                </td>
            </tr>
            <tr>
                <td align="center" width="100"></td>
            </tr>
            <tr>
                <td align="center" width="100"></td>
            </tr>
            <tr>
                <td align="center" width="100"></td>
            </tr>
            <tr>
                <td align="center" width="100"></td>
            </tr>
            <tr>
                <td align="center" width="100">
                    <a style = "background:lime; color:white; text-decoration:none; padding: 1rem 1.5rem;" href="ChangeDocument.jsp">Выбрать агента</a>
                </td>
            </tr>
            <tr>
                <td align="center" width="100"></td>
            </tr>
            <tr>
                <td align="center" width="100"></td>
            </tr>
            <tr>
                <td align="center" width="100"></td>
            </tr>
            <tr>
                <td align="center" width="100"></td>
            </tr>
            <tr>
                <td align="center" width="100">
                    <a style = "background:lime; color:white; text-decoration:none; padding: 1rem 1.5rem;" href="DeleteIsurance.jsp">Аннулировать страхование</a>
                </td>
            </tr>
            <tr>
                <td align="center" width="100"></td>
            </tr>
            <tr>
                <td align="center" width="100"></td>
            </tr>
            <tr>
                <td align="center" width="100"></td>
            </tr>
            <tr>
                <td align="center" width="100"></td>
            </tr>
            <tr>
                <td align="center" width="100">
                    <a style = "background:lime; color:white; text-decoration:none; padding: 1rem 1.5rem;" href="SearchAgent.jsp"> Найти агента </a>
                </td>
            </tr>
        </table>
    </body>
</html>
