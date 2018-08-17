<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt"
	uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<h1><a href="ajax_01.jsp">입력 페이지로 이동</a></h1>
<h1><a href="#" onclick="history.go(-1);">뒤로가기</a></h1>





<%
	int num1=Integer.parseInt(request.getParameter("num1"));
	int num2=Integer.parseInt(request.getParameter("num2"));
	String oper = request.getParameter("oper");
	
	String res = "";
	if( "add".equals(oper) ) {
		res = String.format("%d+%d=%d",num1,num2,num1+num2);
	} else if( "sub".equals(oper) ) {
		res = String.format("%d-%d=%d",num1,num2,num1-num2);
	} else if( "mul".equals(oper) ) {
		res = String.format("%d*%d=%d",num1,num2,num1*num2);
	} else if( "div".equals(oper) ) {
		res = String.format("%d/%d=%.2f",
					num1,num2,num1/(double)num2);
	}
%>
<%=res %>

</body>
</html>











