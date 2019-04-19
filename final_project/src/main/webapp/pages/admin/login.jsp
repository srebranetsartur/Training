<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: srebr
  Date: 4/15/2019
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
    <script src="../../bootstrap/css/bootstrap.min.js"></script>
</head>
<body>
    <form>
        <label for="login">Login</label>
        <input type="text" id="login" name="login" />

        <label for="password">Password</label>
        <input type="password" id="password" name="password" />

        <input type="submit" />
    </form>
</body>
</html>
