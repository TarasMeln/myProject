<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 18.02.2021
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
yghk
<c:forEach var="tempCookie" items="${cookie}">
    <h1>Your role is ${tempCookie}</h1>
</c:forEach>
</body>
</html>
