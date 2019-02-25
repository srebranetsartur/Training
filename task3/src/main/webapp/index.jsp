<%--
  Created by IntelliJ IDEA.
  User: srebr
  Date: 2/24/2019
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>UserForm</title>
</head>
<body>
    <form action="userform" method="POST">
        <p>
            <label for="name">Name: </label>
            <input type="text" name="name" id="name">
        </p>

        <p>
            <label for="lastname">Lastname: </label>
            <input type="text" name="lastname" id="lastname">
        </p>

        <p>
            <label for="login">Login: </label>
            <input type="text" name="login" id="login">
        </p>

        <p>
            <label for="number">Number: </label>
            <input type="text" name="number" id="number">
        </p>

        <input type="submit" value="Submit">
    </form>
</body>
</html>