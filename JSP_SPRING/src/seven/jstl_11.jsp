<%@page import="java.util.Date"%>
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

<c:set var="now" value="<%=new Date() %>" />

<fmt:formatDate value="${now }" />
<hr>

<h3>type="date"</h3>
<fmt:formatDate value="${now}" type="date" /><br>
default: <fmt:formatDate value="${now}" type="date"
			dateStyle="default" /><br>
short: <fmt:formatDate value="${now}" type="date"
			dateStyle="short" /><br>
medium: <fmt:formatDate value="${now}" type="date"
			dateStyle="medium" /><br>
long: <fmt:formatDate value="${now}" type="date"
			dateStyle="long" /><br>
full: <fmt:formatDate value="${now}" type="date"
			dateStyle="full" /><br>

<hr>
<h3>type="time"</h3>
<fmt:formatDate value="${now}" type="time" /><br>
default: <fmt:formatDate value="${now}" type="time"
			timeStyle="default" /><br>
short: <fmt:formatDate value="${now}" type="time"
			timeStyle="short" /><br>
medium: <fmt:formatDate value="${now}" type="time"
			timeStyle="medium" /><br>
long: <fmt:formatDate value="${now}" type="time"
			timeStyle="long" /><br>
full: <fmt:formatDate value="${now}" type="time"
			timeStyle="full" /><br>

<hr>
<h3>type="both"</h3>
<fmt:formatDate value="${now}" type="both" /><br>
full: <fmt:formatDate value="${now}" type="both"
			dateStyle="full" timeStyle="full" /><br>

<hr>
<h3>pattern 적용</h3>
<p>pattern이 적용되면 type이 무시된다</p>
YYYY/MM/dd : <fmt:formatDate value="${now}"
				pattern="YYYY/MM/dd" /><br>
HH:mm:ss.S : <fmt:formatDate value="${now }" 
				pattern="HH:mm:ss.S"/><br>
hh:mm:ss : <fmt:formatDate value="${now }"
				pattern="hh:mm:ss"/><br>

KK:mm:ss : <fmt:formatDate value="${now }" 
				pattern="KK:mm:ss"/><br>
kk:mm:ss a : <fmt:formatDate value="${now }" 
				pattern="kk:mm:ss a"/><br>

Z : <fmt:formatDate value="${now }" pattern="Z"/><br>
z : <fmt:formatDate value="${now }" pattern="z"/><br>
X : <fmt:formatDate value="${now }" pattern="X"/><br>

<%--
<fmt:timeZone value=""></fmt:timeZone>
<fmt:setTimeZone value=""/>

<fmt:setLocale value=""/>
 --%>



<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>













