<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h3>Регистрация</h3>
<form method="post">
    <label>Логин</label><br>
    <input type="text" required placeholder="login" name="login"><br>

    <label>Пароль</label><br>
    <input type="text" required placeholder="password" name="password"><br>

    <input type="submit" value="Регистрация"/>
</form>
</body>
</html>
