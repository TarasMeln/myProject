<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 15.02.2021
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update exhibition</title>
    <link rel="stylesheet" href="/resources/css/exhibition-style.css">
    <link rel="stylesheet" href="/resources/css/add-exhibition-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Update Exhibition</h2>
    </div>
</div>
<div id="container">
    <h3>Update Exhibition</h3>
    <form action="exhibition" method="get">
        <input type="hidden" name="command" value="UPDATE"/>
        <input type="hidden" name="exhibitionId" value="${THE_EXHIBITION.getId()}"/>

        <table>
            <tbody>
            <tr>
                <td><label>Theme:</label></td>
                <td><input type="text" name="theme"
                           value="${THE_EXHIBITION.getTheme()}"/></td>
            </tr>
            <tr>
                <td><label>Hall:</label></td>
                <td><input type="text" name="hall"
                           value="${THE_EXHIBITION.getHall()}"/></td>
            </tr>
            <tr>
                <td><label>Date:</label></td>
                <td><input type="text" name="date"
                           value="${THE_EXHIBITION.getDate()}"/></td>
            </tr>
            <tr>
                <td><label>Ticket price:</label></td>
                <td><input type="text" name="ticketPrice"
                           value="${THE_EXHIBITION.getTicketPrice()}"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
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
