<%--
  Created by IntelliJ IDEA.
  User: srebr
  Date: 2/25/2019
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
    <h1>Excellent. You add a new user</h1>

    <p>Name: <%= request.getParameter("name") %> </p>
    <p>Lastname: <%= request.getParameter("lastname")%></p>
    <p>Login: <%= request.getParameter("login") %></p>
    <p>Number: <%= request.getParameter("number") %></p>

    <a href="/">Add new user</a>
</body>
</html>
