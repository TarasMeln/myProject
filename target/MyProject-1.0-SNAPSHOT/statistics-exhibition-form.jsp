<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 18.02.2021
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistics exhibition</title>
    <link rel="stylesheet" href="/resources/css/exhibition-style.css">
    <link rel="stylesheet" href="/resources/css/add-exhibition-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Statistics Exhibition</h2>
    </div>
</div>
<div id="container">
    <h3>Statistics Exhibition</h3>
    <form action="exhibition" method="get">
        <input type="hidden" name="exhibitionId" value="${THE_EXHIBITION.getId()}"/>

        <table>
            <tbody>
            <tr>
                <td><label>Theme:</label></td>
                <td><h3>${THE_EXHIBITION.getTheme()}</h3>
            </tr>
            <tr>
                <td><label>Hall:</label></td>
                <td><h3>${THE_EXHIBITION.getHall()}</h3></td>
            </tr>
            <tr>
                <td><label>Date:</label></td>
                <td><h3>${THE_EXHIBITION.getDate()}</h3></td>
            </tr>
            <tr>
                <td><label>Ticket price:</label></td>
                <td><h3>${THE_EXHIBITION.getTicketPrice()}</h3></td>
            </tr>
            <tr>
                <td><label>Tickets were sold:</label></td>
                <td><h3>${PURCHASED_TICKETS}</h3></td>
            </tr>
            </tbody>
        </table>
    </form>
    <div style="clear: both;"></div>
    <p>
        <a href="exhibition">Back to list</a>
    </p>
</div>
</body>
</html>

