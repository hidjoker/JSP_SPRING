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
<h1>c:set 세션 확인</h1>

pageScope Data : ${pageData }<br>
sessionScope Data : ${sessionData}<br>
<hr>
pageScope Data : <c:out value="${pageData }"
					default="pageData 없음"/>
<hr>
맵 데이터<br>
<c:out value='${sessionScope.m.get("A") }' /><br>
<c:out value='${m.get("B") }' />					

</body>
</html>