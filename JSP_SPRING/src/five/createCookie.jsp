<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>쿠키 생성 페이지</h1>
<hr>

<%	
	/* 서버가 클라이언트에게 보내는 쿠키 정보 */
	Cookie c1 = new Cookie("ID","Boo");
	response.addCookie(c1);
	
	Cookie c2 = new Cookie("PASS", "7878");
	response.addCookie(c2);
	
	Cookie c3 = new Cookie("Name", "Bob");
	response.addCookie(c3);	
%>
<h1><a href="viewCookie.jsp">쿠키 확인</a></h1>

</body>
</html>