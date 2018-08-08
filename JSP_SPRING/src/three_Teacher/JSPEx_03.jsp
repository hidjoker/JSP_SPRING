<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 태그 예제!</title>
</head>
<body>

<%-- 표현식, Expression --%>
<h3>안녕!</h3>

<%
	int num = 123;
	out.println(num); //브라우저로 전송
	System.out.println(num); //서버 콘솔
%>

<%-- 표현식 --%>
<%=num %> 

<%-- 여기는 JSP 주석 --%>
<%
	// num 변수값 출력
	out.println(num);
%>

<!-- HTML 주석 -->


<%-- 
<%=num %>
--%>
 
</body>
</html>













