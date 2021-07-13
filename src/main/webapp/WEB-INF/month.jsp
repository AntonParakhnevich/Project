<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<body>
<h1>Доходы</h1>
<table>
    <tr>
        <th>Категория</th>
        <th>Сумма</th>
    </tr>
    <c:forEach items="${requestScope.categoriesIncome}" var="category">
    <tr>
        <th>${category.name}</th>
        <th>${category.value}</th>
        <td>
            <form method="post" action='<c:url value="/deleteIncome?idMonth=${requestScope.idMonth}&year=${requestScope.year}" />'
                  style="display:inline;">
                <input type="hidden" name="id" value="${category.id}">
                <input type="submit" value="Удалить">
            </form>
        </td>
        </c:forEach>
    </tr>
    <form method="post" action='<c:url value="/createIncome?idMonth=${requestScope.idMonth}&year=${requestScope.year}" />' style="display:inline;">
        <input type="submit" value="Добавить">
    </form>
</table>
<h1>Расходы</h1>
<table>
    <tr>
        <th>Категория</th>
        <th>Сумма</th>
        <th>Обязательность</th>
    </tr>
    <c:forEach items="${requestScope.categoriesCost}" var="category">
    <tr>
        <th>${category.name}</th>
        <th>${category.price}</th>
        <th>${category.binding}</th>
        <td>
            <form method="post" action='<c:url value="/deleteCost?idMonth=${requestScope.idMonth}&year=${requestScope.year}" />'
                  style="display:inline;">
                <input type="hidden" name="id" value="${category.id}">
                <input type="submit" value="Удалить">
            </form>
        </td>
        </c:forEach>
    </tr>

    <form method="post" action='<c:url value="/createCost?idMonth=${requestScope.idMonth}&year=${requestScope.year}" />' style="display:inline;">
        <input type="submit" value="Добавить">
    </form>

</table>
</body>
<%--<a href="year?year=${requestScope.year} ">Назад</a>--%>
<form method="post" action='<c:url value="/year?year=${requestScope.year}"/>' style="display:inline;">
    <input type="submit" value="Назад">
</form>
</html>
