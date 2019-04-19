<%--
  Created by IntelliJ IDEA.
  User: srebr
  Date: 4/4/2019
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div id="menuCategory">
        <c:forEach var="category" items="${categories}">
            <p value="${category}"></p>
        </c:forEach>
    </div>

    <div id="menuItems" >

    </div>


</body>
</html>
