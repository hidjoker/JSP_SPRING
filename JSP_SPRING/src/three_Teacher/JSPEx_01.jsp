<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 태그 예제!</title>
</head>
<body>

<!-- JSP == Servlet -->
<% //MemberDao dao = new MembDaoImpl(); %>

HELLO!

<% //변수 선언
	String scriptlet = "HI!!!";
	System.out.println(scriptlet);

	// _jspService() 메소드 내부에 코드가 들어가므로
	// 메소드 작성은 안된다
// 	public void testMethod() {
// 	}
%>

<% 	// 제어문
	for(int i=0; i<5; i++) {
%>
	<h3>HELLO JSP</h3>		
<%	} %>

</body>
</html>















