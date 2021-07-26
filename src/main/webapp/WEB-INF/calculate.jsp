<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h3>Расчет накоплений</h3>
<form method="post">
    <label>Количество лет</label><br>
    <input type="number" required placeholder="years" name="years"><br>

    <label>Доход</label><br>
    <input type="number" required placeholder="income" name="income"><br>

    <label>Расход</label><br>
    <input type="number" required placeholder="cost" name="cost"><br>

    <input type="submit" value="Рассчитать"/>
</form>
</body>
</html>
