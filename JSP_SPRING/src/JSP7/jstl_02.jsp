<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>c:set</h1>
<hr>

<c:set var="pageData" value="Page Scope Test"
	scope="page" />

${pageScope.pageData }<br>

<%=pageContext.getAttribute("pageData") %>
<hr>

<c:set var="sessionData" value="SESSIONSESSION"
		scope="session" />
<h1><a href="jstl_02_session.jsp">세션값 확인</a></h1>
<hr>

<%
	Map map = new HashMap<>();
%>

<c:set target="<%=map %>" property="A" value="Alice" />
<c:set target="<%=map %>" property="B" value="Bob" />

<%-- map 출력하기(get 이용) --%>
<c:out value='<%=map.get("A") %>'/><br>
<c:out value='<%=map.get("B")%>'/>

<%-- map을 attribute에 저장하기 --%>
<c:set var="m" value="<%=map %>" scope="session" />


</body>
</html>