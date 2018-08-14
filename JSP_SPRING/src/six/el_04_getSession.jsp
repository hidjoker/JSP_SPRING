<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("SESSION_TEST", "Hello Session");
	session.setAttribute("login", true);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href='/el/el_04_setSession.jsp'>이동!</a>

</body>
</html>