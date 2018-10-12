<%@ page 
	language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
 + 표현식(Expression), <%= %>
	- HTML 문서에 포함될 내용을 간단히 작성하기 위한 코드
	- 자바코드로 <HTML>영역에 쓰여질 내용을 작성할 수 있다
	- 서블릿 컨테이너에 의해 out.print() 코드로 변환된다
	- ; 을 추가하지 않는다
--%>
<%-- 
 + 주석(Comment),
	- HTML 주석, <!-- HTML 주석 -->
		웹 브라우저가 HTML 주석내용을 해석하지 않도록 한다
	- JS주석, /* JS 주석 */ 또는 // JS 주석
		<script> 태그 내에서 사용
		브라우저의 JS엔진이 주석내용을 해석하지 않도록 한다
	- CSS주석, /* CSS 주석 */
		<style> 태그 내에서 사용
		브라우저의 CSS엔진이 주석내용을 해석하지 않도록 한다
	- JSP 주석, JSP주석
		서블릿 코드가 생성되지 않도록 막는다
		서블릿 컨테이너가 JSP주석 내용을 해석하지 못하게 막는다
		웹 브라우저에 전송되지 않음
	- JAVA 주석, /* 자바주석 */ 또는 // 자바 주석
		스크립트릿(<% %>) 태그 내에서 사용한다
		서블릿 컨테이너가 코드를 수행하지 못하게 막는다
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 표현식, Expression --%>
<h3>안녕!</h3>
<%
	int num = 123;
	out.println(num); //브라우저로 전송
	System.out.println(num); //서버 콘솔
%>

<%-- 표현식 --%>
<%=num %>
<%-- 여기는 JSP 주석 --%>
<% 
// num 변수값 출력
out.println(num); 
%>

<!-- HTML 주석 -->

<%-- 
<%=num %>
--%> 


</body>
</html>