<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h3>Новая категория доходов</h3>
<form method="post">
    <label>Название</label><br>
    <input name="name" type="text"/><br>
    <label>Сумма</label><br>
    <input name="price" type="number" min="1"/><br>
    <input type="submit" value="Добавить" style="display: inline"/>
</form>
</body>
</html>
