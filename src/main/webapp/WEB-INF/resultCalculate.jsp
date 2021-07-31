<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${sessionScope.language}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="translations"/>
<html>
<body>
<h3><fmt:message key="calculationAccumulation"/> </h3>
<table>
    <tr>
        <th><fmt:message key="totalYears"/> </th>
        <th><fmt:message key="incomes"/> </th>
        <th><fmt:message key="costs"/> </th>
        <th><fmt:message key="accumulations"/> </th>
    </tr>
    <tr>
        <th>${requestScope.years}</th>
        <th>${requestScope.income}</th>
        <th>${requestScope.cost}</th>
        <th>${requestScope.accumulation}</th>
    </tr>
</table>
<form method="post" action='<c:url value="/hello-servlet"/>' style="display:inline;">
    <input type="submit" value="<fmt:message key="back"/> ">
</form>
</body>
</html>

