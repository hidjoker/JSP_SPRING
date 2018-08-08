<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<!-- + JSP 지시자 -->
<%-- 	- <%@ 지시자 attr="값" ... %> --%>
<!--  + 지시자의 종류 -->
<!-- 	- page : JSP 페이지의 전반적인 환경설정 -->
<!-- 	- include : 다른 파일의 내용을 삽입 -->
<!-- 	- taglib : 태그 라이브러리 기능 사용 설정(활성화) -->
<!--  + page 지시자 속성 -->
<!-- 	- language 속성  -->
<!-- 		JSP페이지에서 사용할 스크립트 언어 지정 -->
<!-- 		기본값 : java -->
<!-- 		사용가능 값 : java -->
<!-- 	- contentType 속성 -->
<!-- 		JSP페이지의 MIME타입을 결정 -->
<!-- 		** MIME타입(Multipurpose Internet Mail Extensions) -->
<!-- 		 : 전송된 문서의 다양성을 알려주기 위한 방법 -->
<!-- 		   (이메일에서 사용하던 것) -->
<!-- 		   웹 문서의 올바른 형식(해석방법)을 브라우저에게 알려주기 위해 -->
<!-- 		   Content-Type 으로 설정해서 전송한다 -->
<!-- 		   브라우저가 리소스(문자, 자원)를 전송받은 이후 해야할 기본 -->
<!-- 		   동작을 알려줄 수 있다 -->
<!-- 			"text/html; charset=UTF-8" -->
<!-- 				text기반의 html문서이며 한글인코딩은 UTF-8 -->
<!-- 			"text/plain" -->
<!-- 				순수한 텍스트 -->
<!-- 			"image/jpeg" -->
<!-- 				jpeg 타입으로 생성된 이미지 -->
<!-- 			"video/mp4" -->
<!-- 				mp4 코덱을 사용한 비디오 -->
<!-- 	- pageEncoding 속성 -->
<!-- 		JSP 파일의 작성된 코드의 인코딩 방식 -->
<!-- 		JSP 파일 자체의 인코딩 방식을 알린다 -->
<%-- 	** <%@ page contentType="text/html;charset=euc-kr" --%>
<%-- 				pageEncoding="UTF-8 %> --%>
<!-- 		이렇게 설정하면 JSP 파일의 내용은 UTF-8로 인식되고 -->
<!-- 		브라우저는 euc-kr로 전송받는다 -->
<!-- 	- import 속성 -->
<!-- 		import할 클래스 지정하기 -->
<%-- 		<%@ page import="java.util.Calendar" %> --%>
<!-- 	- extends 속성 -->
<!-- 		JSP페이지의 상위 클래스를 지정 -->
<!-- 		서블릿 컨테이너가 알아서 넣음 -->
<!-- 		개발자가 건들면 안됨 -->
<%-- 		<%@ page extends="javax.servlet.jsp.HttpJspBase" %> --%>
<!-- 		<JSP에 적용하는 HttpServlet 클래스> -->
<!-- 	- session 속성 -->
<!-- 		JSP 페이지에서 HttpSession 객체 사용 여부 설정 -->
<!-- 		true/false 지정 (기본값 : true ) -->
<!-- 		** 세션 : 웹 서버가 클라이언트를 구분하기 위한 식별방식 -->
<!-- 		** HttpSession : 자바의 세션정보 관련 클래스 -->
<!-- 	- buffer 속성 -->
<!-- 		출력 버퍼 크기 -->
<!-- 		클라이언트와 연결된 출력 스트림의 버퍼 크기 -->
<!-- 		기본 8KB -->
<!-- 		none 설정 시 버퍼 사용하지 않음 -->
<%-- 		<%@ page buffer="8kb" %> --%>
<!-- 	- autoFlush 속성 -->
<!-- 		버퍼 자동 비우기 설정 -->
<!-- 		자동으로 out 객체의 flush()를 호출한다 -->
<!-- 		true / false로 지정( 기본 : true) -->
<!-- 		false로 지정했는데 버퍼가 가득차면 에러 발생 -->
<!-- 		** autoFlush를 false로 지정하면 buffer 속성을 none으로 설정하지 못함 -->
<!-- 	- isThreadSafe 속성 -->
<!-- 		각 페이지가 Thread-Safe 하게 동작하도록 설정 -->
<!-- 		true/false로 지정 ( 기본 : false ) -->

<!--  + include 지시자 -->
<!-- 	- JSP 페이지에 다른 HTML문서 또는 JSP페이지를 삽입할 때 주로 사용 -->
<!-- 	- file 속성이 유일 -->
<%-- 		<%@ include file="파일명" %> --%>

<!--  + taglib 지시자 -->
<!-- 	- JSP페이지에서 지정된 태그 라이브러리 활성화 -->
<!-- 	** 태그 라이브러리 -->
<!-- 		사용자 정의 태그를 모아 일종의 규칙을 부여한 것 -->
<!-- 	** JSTL ( JSP Standard Tag Library ) -->
<!-- 		JSP 기능 확장 -->
<!-- 		편의성 제공 -->
<!-- 		커스텀 태그 중 많이 사용되는 것을 모아서 규약을 정한 것 -->
<!-- 		반복문, 논리판단, DB처리 등을 쉽게 할 수 있음 -->


<%@ include file="JSPEx_05_Header.jsp" %>

<div>
<h3>여기는 본문 내용!!(CONTENTS 영역)</h3>
</div>

<%@ include file="JSPEx_05_Footer.jsp" %>