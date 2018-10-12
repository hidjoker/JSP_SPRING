<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
 + 선언(Declaration), <%! %>
	- JSP 페이지에서 사용할 변수, 메소드를 정의한다
	- JSP가 변환된 서블릿클래스의 클래스 영역에 정의된다
	- 멤버필드, 멤버메소드가 된다
	- 변수 선언코드와, 메소드 정의코드만 작성한다
	( 수행코드(메소드호출)은 하지 않는다 )

 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 선언, Declaration --%>
<%! String name = "Alice"; //변수 선언%>

<%!
	public void method() {
		System.out.println("Hello"+ this.name);
	}

%>

<%-- 스크립트릿 --%>
<% method(); // 메소드 호출 %>

</body>
</html>