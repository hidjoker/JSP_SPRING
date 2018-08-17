<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

//XMLHttpRequst 객체를 생성
function createXMLHttpRequest() {

    var xmlReq = null;

    if (window.XMLHttpRequest) { // IE 7.0 이상, Non-Microsoft browsers
        xmlReq = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        try {
            // XMLHttpRequest in later versions of Internet Explorer
            xmlReq = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e1) {
            try {
                // Try version supported by older versions of Internet Explorer
                xmlReq = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e2) {
                // Unable to create an XMLHttpRequest with ActiveX
            }
        }
    }

    return xmlReq;
}

// AJAX 객체 변수
var xmlHttp = null;

function send() {
//  console.log("send() Test");

	// 입력된 데이터 꺼내기
	var num1 = document.getElementById("num1").value;
	var num2 = document.getElementById("num2").value;
	var oper = document.getElementById("oper").value;
	
	// 요청 URL 만들기
	var query = "num1=" + num1 + "&num2=" + num2 + "&oper="+oper;
	var url = "/ajax/ajax_02_ok.jsp?" +query;
	
	// XMLHttpRequest 객체 생성(XHR 객체 생성)
	xmlHttp = createXMLHttpRequest();

//	console.log("--- XHR TEST ---");
//	console.log(xmlHttp);

	// --- 요청 전 설정 ---
	// 서버 응답(Response)를 처리할 callback 함수 지정
	xmlHttp.onreadystatechange = callback;
	
	// 통신 방식 설정(서버와 연결 설정하기)
	// open(method, url [, async])
	xmlHttp.open("GET",url,true);
	// ----------------
	
//	요청(request) 보내기
	xmlHttp.send(null);
	
}

// XHR의 요청에 대한 응답 처리 함수
function callback(){
	
// 	console.log(" XHR 응답 완료");

	// 응답이 완료되었다면 4번 readyState를 가짐
	if(xmlHttp.readyState==4){ //readyState Done.
		if( xmlHttp.status == 200){ //서버OK. 응답
			printData(); // 정상응답 시 처리 함수
			
		}else if(xmlHttp.status == 404){ //Not Found.
			console.log("XHR응답 : 페이지없음");
		}else { // 200,404를 제외한 나머지 상태코드
			console.log(xmlHttp.statusText);
		}
		// 응답(Request) 상태코드에 따른 처리를 추가한다
	}

}

function printData(){
//	console.log("200코드 정상응답 처리함수");
	// 결과가 반영될 <div>
	var layout = document.getElementById("resultLayout");
	// 응답받은 데이터
	var result = xmlHttp.responseText;
	// 결과 반영하기
	layout.innerHTML = result;	
}

</script>

</head>
<body>

<input type="text" id="num1" />
	<select id="oper">
		<option value="add">더하기</option>
		<option value="sub">빼기</option>
		<option value="mul">곱하기</option>
		<option value="div">나누기</option>
	</select>
<input type="text" id="num2" />
<button onclick="send();">=</button>

<hr>
<div id="resultLayout"></div>

</body>
</html>