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
    <title>Add exhibition</title>
    <link rel="stylesheet" href="/resources/css/exhibition-style.css">
    <link rel="stylesheet" href="/resources/css/add-exhibition-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Add-Exhibitions</h2>
    </div>
</div>
<div id="container">
    <h3>Add Exhibition</h3>
    <form action="exhibition" method="post">
        <input type="hidden" name="command" value="ADD"/>
        <table>
            <tbody>
            <tr>
                <td><label>Theme:</label></td>
                <td><input type="text" name="theme"/></td>
            </tr>
            <tr>
                <td><label>Hall:</label></td>
                <td><input type="number" name="hall"/></td>
            </tr>
            <tr>
                <td><label>Date:</label></td>
                <td><input type="datetime-local" name="date"/></td>
            </tr>
            <tr>
                <td><label>Ticket price:</label></td>
                <td><input type="number" name="ticketPrice"/></td>
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
