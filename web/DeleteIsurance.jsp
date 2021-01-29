
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= application.getAttribute("nameProject") %></title>
    </head>
    <body>
        <h1>Внимание! Разорвать договор можно только с согласования обеих сторон!</h1>
        <form action="ProcessDeletingAgreement" method="POST">
            <h2>Введите уникальный номер договора(id) </h2>
            <input type ="number" name="idAgreement"/>
            <input type="submit" value="Подтвердить" />
        </form>
        
        
    </body>
</html>
