<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>쿠키 삭제</h1>
<hr>
<%
	Cookie[] cookies = request.getCookies();

	for(int i=0; i<cookies.length ; i++){
		// 쿠키 유지시간 설정 : 초 단위
		cookies[i].setMaxAge(5); //5초뒤 삭제
//      cookies[i].setMaxAge(0); //즉시 삭제
//      cookies[i].setMaxAge(365*24*60*60); //1년뒤 삭제
		response.addCookie(cookies[i]);
	}
%>

<h1><a href="viewCookie.jsp">쿠키 확인</a></h1>

</body>
</html>