<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
 + 지시자(Directive), <%@ %>
	- Servlet/JSP컨테이너에게 메시지를 보내기위한 태그
	- JSP가 실행될 때 지시자의 내용을 읽어서 페이지 설정에
	  사용할 수 있도록 추가하는 태그
	- 페이지의 특수 정보나 설정들을 처리한다
	- JSP->Servlet 변환할 때 필요한 정보를 기술한다
	- 브라우저에서 확인되지 않음   
 --%>    
<%@page import="java.util.Calendar"%>
    
<% 
	Calendar cal= Calendar.getInstance(); 
	System.out.println(cal);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>