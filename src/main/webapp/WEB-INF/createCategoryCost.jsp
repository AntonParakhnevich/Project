<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h3>Новая категория расходов</h3>
<form method="post">
    <label>Название</label><br>
    <input name="name"/><br>
    <label>Сумма</label><br>
    <input name="price" type="number" min="1"/><br>
    <label>Обязательность</label><br>
    <input name="binding" type="number" min="1" max="5"/><br>
    <input type="submit" value="Добавить"/>
</form>
</body>
</html>

