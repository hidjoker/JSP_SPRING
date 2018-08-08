<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--  + JSP 문법
	- JSP는 HTML 문서 양식에 Java 코드를 삽입하는 형식
	- Java 코드는 JSP 전용 태그를 이용하여 작성한다

 + JSP 기본 태그
	1. 스크립트릿(Scriptlet) : <% %>
	2. 선언(Declaration) : <%! %>
	3. 표현식(Expression) : <%= %>
	4. 지시자(Directive) : <%@ %>
	5. 주석(Comment) :

 + 스크립트릿(Scriptlet), <% %>
	- 웹 어플리케이션에서 실행되는 자바 코드 작성 영역
	- JSP에서 자바코드를 작성하기 위한 기본이 되는 태그
	- 수행코드를 위주로 작성한다 (제어문 코드, 메소드 호출코드, ...)
	- _jspService() 메소드 내에 변환되어 작성된다
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 태그 예제!</title>
</head>
<body>

<!-- JSP == Servlet -->

HELLO!

<% //변수 선언
	String scriptlet = "HI!!!";
	System.out.println(scriptlet);
	
	// _jspService() 메소드 내부에 코드가 들어가므로
	
	// 메소드 작성은 안된다
// 	public void testMethod(){		
// 	}	
%>

<% // 제어문
	for(int i=0; i<5 ; i++){
%>		
	<h3>HELLO JSP</h3>	
<% 	} %>

</body>
</html>