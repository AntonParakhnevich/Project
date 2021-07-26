<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h3>Расчет накоплений</h3>
<table>
    <tr>
        <th>Количество лет</th>
        <th>Доходы</th>
        <th>Расходы</th>
        <th>Накопления</th>
    </tr>
    <tr>
        <th>${requestScope.years}</th>
        <th>${requestScope.income}</th>
        <th>${requestScope.cost}</th>
        <th>${requestScope.accumulation}</th>
    </tr>
</table>
<form method="post" action='<c:url value="/hello-servlet"/>' style="display:inline;">
    <input type="submit" value="Назад">
</form>
</body>
</html>

