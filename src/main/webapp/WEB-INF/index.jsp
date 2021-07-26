<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<p>Фамилия: ${requestScope.family.login}</p>
<p>Накопления: ${sessionScope.family.budget.calculationTotalAccumulation()}</p>
<p></p>
<p>Года:</p>
<c:forEach items="${requestScope.allYears}" var="year">
    <tr>
        <th>
            <a href="${pageContext.request.contextPath}/year?year=${year.id}">${year.year}</a>
        </th>
    </tr>
</c:forEach>

<h1><a href="createYear">Добавить</a></h1>
<a href="calculate">Рассчитать накопления</a>
<a href="logout">Выход</a>


</body>
</html>