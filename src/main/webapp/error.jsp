<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.07.2022
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h2>Error</h2>
<p><%= request.getAttribute("message")%></p>
</body>
</html>
