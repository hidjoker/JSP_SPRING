<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>쿠키 수정</h1>
<hr>
<%
	Cookie c4 = new Cookie("ID","Ali");
	response.addCookie(c4);
	
	Cookie c5 = new Cookie("PASS","1212");
	response.addCookie(c5);
	
	// createCookie.jsp 에서는 "Name"을 사용하고 있음
	Cookie c6 = new Cookie("Name", "Alice");
	response.addCookie(c6);
%>

<h1><a href="viewCookie.jsp">쿠키 확인</a></h1>

</body>
</html>