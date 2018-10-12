<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



정수형 : ${123 }<br>
실수형 : ${123.456 }<br>
단일문자 : ${'A' }<br>
문자열 : ${"Apple"}<br>
논리형 : ${true }&nbsp;&nbsp;&nbsp;${false }<br>
null : ${null }<br>
<hr>

${123 eq 123 }<br>
${100 > 200 }<br>
${7 div 4 }<br>
${empty str }<br>

<%
	int num = 100;
	pageContext.setAttribute("page", 1);
	request.setAttribute("n", num);
	session.setAttribute("session", 3);
	application.setAttribute("app", 4);
%>
page : ${pageScope.page}<br>
num : ${n }<br>
session : ${sessionScope.session }<br>
application : ${applicationScope.app }<br> 

</body>
</html>