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
<h1>c:import</h1>
<hr>
<%-- <c:import url="https://search.naver.com/search.naver" >
	<c:param name="query" value="류현진" />
</c:import> --%>

<h1>c:redirect</h1>
<hr>

<%-- <c:redirect url="https://www.naver.com/" /> --%>
<c:redirect url="https://search.naver.com/search.naver" >
	<c:param name="query" value="류현진" />
</c:redirect>

</body>
</html>