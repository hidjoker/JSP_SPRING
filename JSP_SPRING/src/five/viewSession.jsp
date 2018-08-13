<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>세션 확인 JSP</h1>
<hr>
<%= "Session ID : " + session.getId() + "<br>" %>
<%= "Creation Time : " + new Date(session.getCreationTime()) + "<br>" %>
<%= "LasAccessed Time : " + new Date(session.getLastAccessedTime()) + "<br>" %>
<%= "MaxInactiveInterval : " + session.getMaxInactiveInterval()+ "<br>" %>
<%= "isNew : " + session.isNew() + "<br>"%>

<%= "test1 : " + session.getAttribute("test1")+ "<br>" %>
<%= "test2 : " + session.getAttribute("test2")+ "<br>" %>
<%= "test3 : " + session.getAttribute("test3")+ "<br>" %>


<h1><a href="createSession.jsp">세션 생성</a></h1>
<h1><a href="deleteSession.jsp">세션 삭제</a></h1>

</body>
</html>