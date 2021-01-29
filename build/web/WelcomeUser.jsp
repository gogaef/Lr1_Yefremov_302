
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
        <h1>Добро пожаловать  <%= user.getValues().get("name") %>!</h1>
        <h2>Выберите действие</h2>
        <a style = "background:blueviolet; color:white; text-decoration:none; padding: 1rem 1.5rem;" href="CreateIsurance.jsp"> Застраховаться </a><br><br><br>
        <a style = "background:blueviolet; color:white; text-decoration:none; padding: 1rem 1.5rem;" href="ChangeDocument.jsp"> Сменить агента </a><br><br><br>
        <a style = "background:blueviolet; color:white; text-decoration:none; padding: 1rem 1.5rem;" href="DeleteIsurance.jsp"> Аннулировать страхование </a><br><br><br>
        <a style = "background:blueviolet; color:white; text-decoration:none; padding: 1rem 1.5rem;" href="SearchAgent.jsp"> Поиск агента </a>
    </body>
</html>
