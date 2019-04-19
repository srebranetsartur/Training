<%--
  Created by IntelliJ IDEA.
  User: srebr
  Date: 4/3/2019
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Restaurant!</title>
</head>
<body>
    <h1 id="greeting">Welcome to our restaurant</h1>

    <div id="visitorInfo">
        <h2>Enter your info and start order</h2>

        <form method="post" action="helloServlet">
            <label for="firstName">Name</label>
            <input type="text" id="firstName" name="firstName"/><br/>

            <label for="lastName">Lastname</label>
            <input type="text" id="lastName" name="lastName"/><br/>

            <label for="birthday">Birthday</label>
            <input type="date" id="birthday" name="birthday" /><br/>

            <label for="number">Number</label>
            <input type="text" id="number" name="number"/><br/>

            <input type="submit" />
        </form>
    </div>
</body>
</html>