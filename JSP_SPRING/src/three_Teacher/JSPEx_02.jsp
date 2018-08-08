<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 태그 예제!</title>
</head>
<body>

<%-- 선언, Declaration --%>
<%! String name = "Alice"; //변수 선언 %>

<%!
	public void method() { //메소드 정의
		System.out.println("Hello" + name);
	}

%>

<%-- 스크립트릿 --%>
<%	method(); // 메소드 호출 %>

</body>
</html>













