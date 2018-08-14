<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
 + Java Bean(=DTO)
	- 자바 클래스
  	- 프로그램에서 사용할 정보를 모아놓은 데이터 저장소
	- 정보은닉을 적용한다 (접근제한자)
		-> 멤버필드를  private
		-> 멤버필드에 대한 getter/setter 작성
 + 자바빈 설계 규약(원칙)
	- 로직 X
	- getter/setter 이외의 메소드는 추가하지 않는다
	- 디폴트 패키지를 사용하지 않는다
	- public 클래스로 지정한다
		멤버필드는 모두 private
		getter/setter는 public
	- 생성자는 파라미터를 가지지 않는다
		디폴트 생성자만 허용한다
	- 멤버변수는 Property(프로퍼티)라고 부른다
	- getter의 반환타입이 boolean이면 get 대신 is를 쓸 수 있다
 + POJO, Plain Old Java Object
	- 개발자가 마음대로 정의할 수 있는 객체
	- 가볍고, 유연하고, 단단한 자바 객체
 + JSP 액션(액션 태그)
	- JSP 페이지를 이루는 요소 중 하나
	- 페이지와 페이지 사이의 제어, 이동 등등
	- JSP 페이지의 특정 동작을 명령하는 태그

 + <jsp:useBean class="클래스명" id="bean변수명></jsp:useBean>
		Java Bean 설정하기
		JSP 페이지에서 사용할 자바빈 객체를 생성하고 지정한 scope 영역에 저장한다
		장점 : 각 scope 영역에서 공유할 데이터를 쉽게 저장한다
 + <jsp:setProperty name="bean이름" property="필드명" />
		프로퍼티 설정하기
 + <jsp:getProperty name="bean이름" property="필드명" />
		프로퍼티 값 가져오기

 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	// 자바코드로 객체 생성하기
	User user = new User();
%>

<%-- 액션태그로 자바빈 객체 생성하기 --%>
<h1>액션태그 테스트</h1>
<hr>
<jsp:useBean id="user2" class="dto.User" scope="page"></jsp:useBean>
<%-- page, request, session, application --%>

<%
	user.setId("Alice");
	user2.setId("Bob");
%>

스크립트릿 ID : <%=user.getId() %><br>
<%-- user2에 id값 set 하기 --%>
<%-- user2.setId("Bob"); --%>
<jsp:setProperty property="id" name="user2" value="Bob"/>

<%-- user2의 id값 get하기 --%>
<%-- user2.getId(); --%>
액션태그 ID : <jsp:getProperty property="id" name="user2"/>


</body>
</html>