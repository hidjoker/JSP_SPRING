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
<h1>c:choose</h1>
<hr>

<c:choose>
	<c:when test="${param.sel eq 1 }">
		1이 선택되었습니다
	</c:when>
		<c:when test="${param.sel eq 2 }">
		2이 선택되었습니다
	</c:when>
		<c:when test="${param.sel eq 3 }">
		3이 선택되었습니다
	</c:when>
</c:choose> 

<h1><a href="jstl_05_form.jsp">돌아가기</a></h1>

</body>
</html>