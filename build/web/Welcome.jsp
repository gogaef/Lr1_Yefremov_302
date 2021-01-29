<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<% application.setAttribute("nameProject", "Страховая компания"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> <%= application.getAttribute("nameProject") %> </title>
</head>
<body>
  <h2>Добро пожаловать!</h2>
  <form action = "/WebApplication1/Autentification" method = "POST">
      <select name="user">
          <option value="Agent">Агент</option>
          <option value="Client">Клиент</option>
      </select>
      <label for = "pas"> Введите пароль </label>
      <input type = "text" name ="password" id = "pas" />
      <input type = "Submit" value ="Отправить" />
  </form>
</body>
</html>