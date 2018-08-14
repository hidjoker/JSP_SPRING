<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
 + 페이지 이동
	- 화면 전환
	- 리다이렉트(redirect)
		URL을 변경하면서 페이지 이동
		새로운 페이지가 열리면서 이동한다
		새로운request 발생
		request, response 유지하지 않음
		** Servlet에서 리다이렉트 발생시키기
			response.sendRedirect("페이지URL")	;
	- 포워드(foward)
		URL을 유지하면서 문서 내용만 바꿔치기(이동)
		request 객체가 유지됨
		** Servlet에서 포워드하기
			RequestDispatch 클래스를 이용
			request.getRequestDispatcher("페이지URL")
				.forward(request, response);

 + <jsp:foward page="이동할페이지"></jsp:forward>
		페이지 이동(포워딩, fowarding)
		전달 파라미터를 추가하고 싶으면
		<jsp:para value="값 name="이름" />을 자식태그로 추가한다

 + <jsp:include page="삽입할페이지" />
   <jsp:include page="삽입할페이지" >
		<jsp:param value="값" name="이름" />
	</jsp:include>
		JSP페이지 내에 다른 페이지를 추가한다
		파라미터를 전달하며 include하면 파라미터에 대한 
		처리를 하고난 뒤 결과 페이지가 include된다
	** include액션과 include지시자는 비슷한 동작을 한다
		<jsp:include page"" />
		<%@ include page="" %>
		화면의 중복되는 부분을 손쉽게 관리할 수 있다
		(상단, 사이드, 메뉴, 하단 등등)
	** include액션과 include지시자의 차이점
		include 지시자는 JSP가 합쳐진 이후 컴파일된다
		include 액션은 각각의 JSP가 컴파일되고 코드가 
		처리된 후에 합쳐진다
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>액션태그 테스트</h1>
<hr>

<jsp:forward page="/view/viewPage.jsp">
	<jsp:param value="123" name="abc"/>
</jsp:forward>


</body>
</html>