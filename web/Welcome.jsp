<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> <%= application.getAttribute("nameProject") %> </title>
</head>
<body>
<h2 align = "center">Авторизация</h2>
<form action = "/WebApplication1/Autentification" method = "POST">
    <table width="100%" cellspacing="0" cellpadding="4">
        <tr>
            <td align="center" width="100"><select name="user">
                <option value="Agent">Агент</option>
                <option value="Client">Клиент</option>
            </select> </td>
        </tr>
        <tr>
            <td align="center" width="100"><label for = "pas"> Введите пароль </label></td>
        </tr>
        <tr>
            <td align="center" width="100"><input type = "text" name ="password" id = "pas" /></td>
        </tr>
        <tr>
            <td align="center" width="100"><input type = "Submit" value ="Отправить" /></td>
        </tr>
    </table>
</form>
</body>
</html>