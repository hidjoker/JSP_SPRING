<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/js/httpRequest.js"></script>

<script type="text/javascript">

function send() {
	var name = document.f.name.value;
	var content = document.f.content.value;
	
	var queryString = "name="+name+"&content="+content;
	var url = "ajax_04_ok.jsp";
	
	sendRequest("POST", url, queryString, callback);
}

function callback() {
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			printData();
		}
	}
}

function printData() {
	var layout = document.getElementById("resultLayout");
	layout.innerHTML = httpRequest.responseText;
}

</script>

</head>
<body>

<form name="f">
이름 : <input type="text" name="name" /><br>
내용 : <textarea name="content"></textarea>
</form>
<button onclick="send();">보내기</button>
<hr>
<div id="resultLayout"></div>

<!-- 이름 <input type=text> -->
<!-- 내용 content <textarea> -->
<!-- 두 개의 데이터를 ajax_04_ok.jsp 로 전송하기 -->
<!-- 전송한 데이터를 그대로 응답 받기 -->

<!-- ex) -->
<!-- name : Alice -->
<!-- content : 안녕하세요 여러분! -->

<!-- 응답 데이터 : Alice, 안녕하세요 여러분! -->

<!-- <div>를 하나 생성하고 응답 데이터로 채우기 -->


</body>
</html>















