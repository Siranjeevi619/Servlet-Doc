<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*, javax.servlet.*, javax.servlet.http.*" %>

<html>
<head>
    <title>User Dashboard</title>
</head>
<body>
<%
    String name = null;
    HttpSession sess = request.getSession(false);
    if (sess != null && sess.getAttribute("username") != null) {
        name = sess.getAttribute("username").toString();
    } else {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<h2>Welcome, <%= name %>
</h2>
<form action="logout" method="get">
    <input type="submit" value="Logout"/>
</form>
</body>
</html>
