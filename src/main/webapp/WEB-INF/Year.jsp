<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Years" %>
</h1>
<table>
    <tr>
        <th>Месяц</th>
        <th>Доходы</th>
        <th>Расходы</th>
        <th>Накопления</th>
    </tr>

    <c:forEach items="${requestScope.months}" var="month">
    <tr>
        <th>
            <a href="${pageContext.request.contextPath}/month?idMonth=${month.id}&year=${requestScope.year}">${month.name}</a>
        </th>
        <th>${month.income.calculationTotalIncome()}</th>
        <th>${month.expenses.calculationTotalExpenses()}</th>
        <th>${month.calculationAccumulationInMonth()}</th>
        </c:forEach>
    </tr>
</table>
<a href="createMonth?year=${requestScope.year}">Добавить</a>




<form method="post" action='<c:url value="/hello-servlet"/>' style="display:inline;">
    <input type="submit" value="Назад">
</form>
</body>
</html>