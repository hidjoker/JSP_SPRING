<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- /el_03.jsp?id=Alice&pw=1234 로 테스트! --%>

<h1>표현언어</h1>
<hr>
전달받은 아이디 : ${param.id }<br>
전달받은 패스워드 : ${param.pw }

<h1>표현식</h1>
<hr>
전달받은 아이디 : <%=request.getParameter("id") %><br>
전달받은 패스워드 : <%=request.getParameter("pw") %><br>

</body>
</html>