
<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= application.getAttribute("nameProject") %></title>
    </head>
    <body>
        <form action="ProcessSearchAgent1" method ="POST">
            <h3>Выберите возраст</h3>
            <p>От <input type="number" name="ageFrom"/> До <input type="number" name="ageTo"/> </p>
            
            <h3>Выберите опыт работы </h3>
            <p>От <input type="number" name="exFrom"/> До <input type="number" name="exTo"/> </p>
            
            <h3>Выберите процентную ставку </h3>
            <p>От <input type="number" step ="0.01" name="procFrom"/> До <input step ="0.01" type="number" name="procTo"/> </p>
            
            <input type="submit" value="Поиск"/>
        </form>
        
        
    </body>
</html>
