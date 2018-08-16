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
<h1>c:forTokens</h1>
<hr>

<% String fruits = "Apple,Banana,Cherry,Durian"; %>
<c:forTokens items="<%=fruits %>" delims=","
		var="fruit">
		${fruit }<br>

</c:forTokens>

<hr>

<c:set var="fruits2" value="Apple Banana Cherry Durian"
<c:forTokens items="${fruits2 }" delims=" "
		var="fruit2">
		
		${fruit2 }<br>
		
</c:forTokens>



</body>
</html>