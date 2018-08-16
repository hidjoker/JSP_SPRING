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
<h1>c:catch</h1>
<hr>

<c:catch var="e">
	<%=request.getParameter("id") %>
	<%
		request.getParameter("id").equals("test");
	%>
</c:catch>

<c:if test="${not empty e} ">
	예외발생함<br>
	${e }<br>
</c:if>

</body>
</html>