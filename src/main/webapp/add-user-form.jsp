<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 17.02.2021
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
    <link rel="stylesheet" href="/resources/css/exhibition-style.css">
    <link rel="stylesheet" href="/resources/css/add-exhibition-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Add-User</h2>
    </div>
</div>
<div id="container">
    <h3>Add User</h3>
    <form action="user" method="get">
        <input type="hidden" name="command" value="ADD"/>
        <table>
            <tbody>
            <tr>
                <td><label>Name:</label></td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td><label>Surname:</label></td>
                <td><input type="text" name="surname"/></td>
            </tr>
            <tr>
                <td><label>Login:</label></td>
                <td><input type="text" name="login"/></td>
            </tr>
            <tr>
                <td><label>Password:</label></td>
                <td><input type="text" name="password"/></td>
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
        <a href="user">Back to login</a>
    </p>
</div>
</body>
</html>
