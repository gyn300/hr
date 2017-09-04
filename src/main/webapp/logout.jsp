<%@ page contentType="text/html; charset=utf-8" language="java" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
</head>

<body>
<%
session.invalidate();
response.sendRedirect("index.jsp");
%>
</body>
</html>
