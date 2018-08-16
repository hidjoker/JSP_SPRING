<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
<h1>c:forEach</h1>
<hr>

<c:forEach var="i" begin="1" end="10" step="2">
	${i }<br>
</c:forEach>
<hr>

<c:set var="sum" value="0" />

<%-- forEach문을 이용한 1~100의 합계 및 출력 --%>

<c:forEach var="i" begin="1" end="100" step="1">
	<c:set var="sum" value="${sum+i }"></c:set>
</c:forEach>
<h3>RESULT : ${sum }</h3>
<hr>

<%-- 구구단 작성 --%>
<%-- 2~9단 --%>

<div id="result">
<c:forEach var="i" begin="2" end="9">
	<c:forEach var="j" begin="1" end="9">
		<div id="result${i }${j}">
			<c:out value="${i }*${j }=${i*j }" />
		</div>
	</c:forEach>
</c:forEach>
</div>

<div id="secondRes">
<c:forEach var="i" begin="1" end="9">
	<c:forEach var="j" begin="2" end="9">
		<div id="secondRes${j }${i}">
			<c:out value="${j }*${i }=${i*j }" />
		</div>
	</c:forEach>
</c:forEach>
</div>
<hr>

<%
	Map<Integer, String> map = new HashMap<>();
	map.put(1,"Apple");
	map.put(2,"Banana");
	map.put(3,"Cherry");
%>
<c:forEach var="iter" items="<%=map %>">
	${iter.key } : ${iter.value }<br>
</c:forEach>
<hr>
<%
	List<String> list = new ArrayList<>();
	list.add("Apple");
	list.add("Banana");
	list.add("Cherry");
	list.add("Durian");
	list.add("E");
%>

<c:forEach var="i" items="<%=list %>" step="2"
	varStatus="stat"> <%-- begin="1" end="4" --%> 
	
	i : ${i }<br>
	루프 중 현재 인덱스 : ${stat.index }<br>
	루프 실행 횟수 : ${stat.count }<br>
	begin : ${stat.first }<br>
	end : ${stat.last }<br>
	step : ${stat.step }<br>
	------------------------<br>
	
</c:forEach>

</body>
</html>