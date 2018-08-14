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

${sessionScope.SESSION_TEST }<br>
${SESSION_TEST }<br>

<%=session.getAttribute("SESSION_TEST") %>
<% if((boolean) session.getAttribute("login")){ %>
	로그아웃버튼
<% } %>

</body>
</html>