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
<h1>c:if</h1>
<hr>

<c:if test="true">
	<h3>TRUE : 무조건 실행</h3>
</c:if>		

<c:if test="false">
	<h3>FALSE : 무조건 실행하지 않는다</h3>
</c:if>		

<c:if test="단순문자열">
	<h3>항상 실행하지 않음</h3>
</c:if>		
<%-- test속성값은 문자열 타입 데이터를 인식한다 --%>
<%-- 하지만 그 문자열이 true 또는 false이어야만 한다 --%>
<hr>

<% boolean bFlag = true; %>
<c:if test="<%=bFlag %>">
	<h3>표현식으로 변수 사용하기</h3>
</c:if>

<% int num = 123; %>
<c:if test="<%=num==123 %>">
	<h3>스크립트릿 연산 결과 이용하기</h3>
</c:if>
<hr>

<c:set var="testVal" value="123"/>
<c:if test="${testVal eq 123 }">
	<h3>EL을 이용한 조건문</h3>
</c:if>
<hr>

<%-- Controller에서 로그인정보를 session Attribute에 --%>
<%-- 저장했다고 가정 --%>
<c:set var="login" value="false" scope="session" />

<c:if test="${sessionScope.login }">
	<h3>로그인 상태</h3>
	<h3>닉네임, 마이페이지링크, 로그아웃버튼 보이기</h3>
</c:if>

<c:if test="${not sessionScope.login }">
	<h3>비 로그인 상태</h3>
	<h3>로그인 폼, 회원가입버튼 보이기</h3>
</c:if>

</body>
</html>