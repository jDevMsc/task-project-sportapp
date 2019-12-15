<%@ page import="com.testproj.sportapp.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Meal list</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <p><a href="index.html">Home</a></p>
    <p>К списку пользователей : <a href="users">пользователь</a></p>
    <hr/>
    <h2>Meals</h2>
    <a href="meals?action=create">Добавить еду</a>
    <table>
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${mealList}" var="meal">
            <jsp:useBean id="meal" scope="page" type="com.testproj.sportapp.to.UserMealWithExceed"/>
            <tr class="${meal.excess ? 'excess' : 'normal'}">
                <td>
                            <%--different date output options--%>
<%--                    <fmt:parseDate value="${meal.dateTime}" pattern="y-M-dd'T'H:m" var="parseDate"/>--%>
<%--                    <fmt:formatDate value="${parseDate}" pattern="yyyy.MM.dd HH:mm"/>--%>
<%--                        ${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                        <%=TimeUtil.toString(meal.getDateTime())%>
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals?action=update&id=${meal.id}">Редактировать</a></td>
                <td><a href="meals?action=delete&id=${meal.id}">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
