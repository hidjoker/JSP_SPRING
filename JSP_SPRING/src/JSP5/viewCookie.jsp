<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>쿠키 확인</h1>
<hr>

<% 
	Cookie[] cookies = request.getCookies();
	

	// 쿠키 정보 출력하기
	// cookies.length
	// cookie.getName() - 변수명
	// cookie.getValue() - 변수값
	for(int i=0 ; i < cookies.length ; i++){
		
%>

<%-- 브라우저에 전송될 HTML 내용 --%>		
<%=cookies[i].getName()+"="+cookies[i].getValue()+ "<br>"%>

<% 	} %>

<h1><a href="createCookie.jsp">쿠키 생성</a></h1>
<h1><a href="updateCookie.jsp">쿠키 수정</a></h1>
<h1><a href="deleteCookie.jsp">쿠키 삭제</a></h1>

</body>
</html>