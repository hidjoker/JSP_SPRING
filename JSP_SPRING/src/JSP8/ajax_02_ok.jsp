<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% System.out.println("AJAX Request TEST"); %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="n1" value="${param.num1 }" />
<c:set var="n2" value="${param.num2 }" />

<c:choose>
	<c:when test="${param.oper eq 'add' }">
		${n1 }+${n2 }=${n1+n2 }
	</c:when>
	<c:when test="${param.oper eq 'sub' }">
		${n1 }-${n2 }=${n1-n2 }
	</c:when>
	<c:when test="${param.oper eq 'mul' }">
		${n1 }*${n2 }=${n1*n2 }
	</c:when>
	<c:when test="${param.oper eq 'div' }">
		${n1 }/${n2 }=<fmt:formatNumber value="${n1/n2 }" pattern="0.00" />
	</c:when>
</c:choose>

</body>
</html>