<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
+ AJAX, Asynchronous Javascript + XML
	- 비동기식 자바스크립트 + XML
	- 자바스크립트 기반의 XML을 이용한 비동기 통신
	- 자바스크립트로 HTTP 요청을 보내고 XML로 응답을 받는 기술
	- 요청보내기, 응답처리 모두 자바스크립트 코드로 작성해야 한다
	- JavaScript 코드를 이용한다
	- XMLHttpRequest 자바스크립트 내장 객체를 이용한다

 + Ajax 동작 순서
	1. XMLHttpRequest 객체를 이용한 요청(Request)
	2. XML문서(JSON 데이터)를 응답(Response) 받음
		- XMLHttpRequest 객체가 전달 받음
	3. XMLHttpRequest가 받은 데이터를 객체화 시킴
		- XML객체 또는 JSON 객체
	4. 자바스크립트 코드로 응답으로 받은 XML객체(JSON객체)를
	  추가 작업을 통해 데이터를 화면(브라우저)에 반영
	
 + XHR 속성(property)
	- readyState
		XHR 객체는 준비-전송-완료 단계를 거치면서 
		내부 준비코드가 바뀜
		0 : UNSENT  - open() 호출 전
		1 : OPENED - open() 호출, send() 호출 전
		2 : HEADERS_RECEIVED - send() 호출, 응답받기 전
		3 : LOADING - 다운로드 중(response 중간)
		4 : DONE - 동작(요청-응답) 완료
		
		** LOADING 상태 돌입 시 XHR.onprogress 이벤트 발생
		** DONE 상태 시 XHR.onload 이벤트 발생

	- onreadystatechange
		readystate가 변경될 때마다 발생하는 이벤트 처리 코드
	- responseText
		응답 데이터를 String 추출(변환)
	- responseXML
		응답 데이터를 XML 객체로 추출(변환)
	- status
		HTTP 응답 상태 코드
		DONE 이후 응답상태에 따른 처리를 설정할 때 이용한다
	- statusText
		HTTP 응답 상태 코드에 대한 텍스트(메시지)
		ex) 404 - Not Found.

 + XHR 함수(method)
	- void open(String method, String url, [, boolean asynch]);
		요청 초기화
		요청 정보 설정
		method : HTTP 요청 메소드 설정
		url : 접속 URL (혀재 페이지와 같은 도메인만 가능)
		asynch : 동기(false), 비동기(true) 지정
		** asynch를 동기(false)로 설정하면 요청에 대한 응답을 받을 때까지
		대기상태(BLOCK)이 된다
	- void send(null);
		GET 요청 전송
	- void send(params);
		POST 요청 전송
		params에 쿼리스트링 형식의 문자열을 추가한다

-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="ajax_01_ok.jsp" method="post">
	<input type="text" name="num1" />
		<select name="oper">
			<option value="add">더하기</option>
			<option value="sub">빼기</option>
			<option value="mul">곱하기</option>
			<option value="div">나누기</option>
		</select>
	<input type="text" name="num2" />
	<input type="submit" value=" = " />
</form>

</body>
</html>