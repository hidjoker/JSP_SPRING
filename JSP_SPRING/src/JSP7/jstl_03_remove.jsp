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
<h1>c:remove</h1>
<hr>

<%-- 모든 scope의 SessionData 변수 제거하기 --%>
<c:remove var="sessionData" />

<%-- 모든 scope의 SessionData 변수 제거하기 --%>
<c:remove var="sessionData" scope="session" />

<h1><a href="/jstl/jstl_02_session.jsp">세션 확인</a></h1>
				

</body>
</html>