<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Invalidate the session
    request.getSession().invalidate();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Logout</title>
</head>
<body>
    <h1>You have been logged out</h1>
    <a href="login.jsp">Login Again</a>
</body>
</html>