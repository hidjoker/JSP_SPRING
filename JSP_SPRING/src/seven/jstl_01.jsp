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
<h1>c:out</h1>
<hr>

<c:out value="안녕! JSTL" /><br>
<c:out value="아하하아하아하아아아아 아아아아어아" />
<hr>

<c:out value="${empty elVar }" /><br>
<c:out value="${elVar }"
	default="elVar 변수는 null이다" /><br>
	
<c:out value="<h1>태그 출력</h1>" /><br> <%-- 기본값:true --%>
<c:out value="<h1>태그 출력</h1>"
	escapeXml="false" /><br>
<br>

<% out.print("<h1>태그 출력 - 스크립트릿</h1>"); %>
<% out.print("&lt;h1&gt;태그 출력 - 스크립트릿&lt;/h1&gt;"); %>
<hr>

<% String test="test Value"; %>
<c:out value="${test }"
	default="test가 출력 안됨!" /><br>
<% pageContext.setAttribute("test1", test); %>
<c:out value="${pageScope.test1 }" /><br>
${test1 }
<hr>

<c:out value="<%=123 %>" /><br>
<c:out value="<%=\"Alice\" %>" /><br>
<c:out value='<%="Bob" %>' /><br>
<%-- 스크립트릿으로 작성한 코드는 해석되지 않음 --%>
<c:out value='<%=out.println("Clare") %>' /><br>

</body>
</html>