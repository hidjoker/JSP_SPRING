<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 표현식, Expression --%>
<%="<h1>Hello Expression</h1>" %>
<h1><%="Hello Expression" %></h1>

<%-- 표현언어, EL --%>
${"<h1>Hello EL</h1>" }
<h1>${"Hello EL" }</h1>

<%-- 스크립트릿, Scriptlet --%>
<% out.println("<h1>Hello Scriptlet</h1>"); %>
<h1><% out.println("Hello Scriptlet"); %></h1>

<%-- HTML --%>
<h1>Hello HTML</h1>

</body>
</html>