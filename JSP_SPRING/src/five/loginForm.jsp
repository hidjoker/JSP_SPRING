<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>로그인 폼</h1>
<hr>
<% if(session.getAttribute("login") ==null || !(boolean)session.getAttribute("login")){ %>

<%-- 비 로그인 상태일 때 로그인폼 보이기 --%>
<form action="/login/login.do" method="post">
<label>아이디 : <input type="text" name="id" /></label><br>
<label>패스워드 : <input type="password" name="pw" /></label><br>
<button>로그인</button>
</form>

<% }else{ %>
<%-- 로그인 상태일 때 로그아웃폼 보이기 --%>
<%=session.getAttribute("id") %>님, 환영합니다<br>
<a href="/login/logout.do"><button>로그아웃</button></a>
<% } %>
</body>
</html>