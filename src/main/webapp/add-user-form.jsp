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


<%--<!DOCTYPE html>--%>
<html >
<head>
    <meta charset="UTF-8">
    <title>Sign In/Up Form Transitions</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<body>
<form action="user" method="get">
    <input type="hidden" name="command" value="ADD"/>

    <input checked="" id="signin" name="action" type="radio" value="signin">
    <label for="signin">Sign in</label>

    <input id="signup" name="action" type="radio" value="signup">
    <label for="signup">Sign up</label>

    <input id="reset" name="action" type="radio" value="reset">
    <label for="reset">Reset</label>
    <div id="wrapper">
        <div id="arrow"></div>
        <input id="email" placeholder="Email" type="text">
        <input id="pass" placeholder="Password" type="password">
        <input id="repass" placeholder="Repeat password" type="password">
    </div>
    <button type="submit">
    <span>
      Reset password
      <br>
      Sign in
      <br>
      Sign up
    </span>
    </button>
</form>
<div id="hint">Click on the tabs</div>

<script type="text/javascript">

</script>

</body>


</body>
</html>

