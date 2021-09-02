<%--
  Created by IntelliJ IDEA.
  User: seth
  Date: 9/2/21
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="partials/navbar.jsp"%>
<%@ include file="partials/scriptsAndLinks.jsp"%>

<html>
<head>
    <title>Page</title>
</head>
<body>

<h1>Welcome, <%= request.getParameter("name")%></h1>

</body>
</html>
