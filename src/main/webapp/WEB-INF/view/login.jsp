<%--
  Created by IntelliJ IDEA.
  User: Taras
  Date: 23.02.2021
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign In/Up Form Transitions</title>
    <link rel="stylesheet" href="/resources/css/login-registration-style.css">
</head>
<body>
<body>
<form action="user" method="post">

    <input checked="" id="signin" name="command" type="radio" value="LOGIN">
    <label for="signin">Sign in</label>

    <input id="signup" name="command" type="radio" value="ADD">
    <label for="signup">Sign up</label>

    <input id="reset" name="command" type="radio" value="RESET">
    <label for="reset">Reset</label>
    <div id="wrapper">
        <div id="arrow"></div>
        <input id="email" name="email" placeholder="Email" type="text" required>
        <input id="pass" name="password" placeholder="Password" type="password" required>
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
<script type="text/javascript">

</script>
</body>
</body>
</html>


<%--<!DOCTYPE html>--%>
<%--<html >--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Sign In/Up Form Transitions</title>--%>
<%--    <link rel="stylesheet" href="/resources/css/login-registration-style.css">--%>


<%--</head>--%>

<%--<body>--%>
<%--<body>--%>
<%--<form action="user" method="post">--%>
<%--    <input checked="" id="signin" name="action" type="radio" value="LOGIN">--%>
<%--    <label for="signin">Sign in</label>--%>
<%--    --%>
<%--    <input id="signup" name="action" type="radio" value="ADD">--%>
<%--    <label for="signup">Sign up</label>--%>
<%--    --%>
<%--    <input id="reset" name="action" type="radio" value="RESET">--%>
<%--    <label for="reset">Reset</label>--%>
<%--    --%>
<%--    <div id="wrapper">--%>
<%--        <div id="arrow"></div>--%>
<%--        --%>
<%--        <input id="email" placeholder="Email" type="text" required>--%>
<%--        <input id="pass" placeholder="Password" type="password" required>--%>
<%--        <input id="repass" placeholder="Repeat password" type="password">--%>
<%--    </div>--%>
<%--    <button type="submit">--%>
<%--    <span>--%>
<%--      Reset password--%>
<%--      <br>--%>
<%--      Sign in--%>
<%--      <br>--%>
<%--      Sign up--%>
<%--    </span>--%>
<%--    </button>--%>
<%--</form>--%>
<%--<div id="hint">Click on the tabs</div>--%>

<%--<script type="text/javascript">--%>

<%--</script>--%>

<%--</body>--%>


<%--</body>--%>
<%--</html>--%>

