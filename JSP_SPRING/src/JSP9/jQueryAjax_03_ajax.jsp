<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

function send(){	
	var n1 = $("#num1").val();
	var n2 = $("#num2").val();
	var oper = $("#oper").val();
	
	// $.ajax를 이용한 Ajax 요청-응답 처리
	$.ajax({
		type: "post"
		, url: "/jQueryAjax/jQueryAjax_ok_02.jsp"
		, data: {"num1":n1, "num2":n2, "oper":oper}
// 		, dataType : "text"  
// 		, dataType : "json"
		, success : function(data){
			console.log("--- success ---");
			console.log(data);
			$("#resultLayout").html(data.result);
			
			
			//dataType : "text"
// 			var json = JSON.parse(data);
// 			console.log(json.abc);
		}
		, error : function(e){
			console.log("--- error ---");
			console.log(e.responseText);
		}
		, complete : function(){
			//입력 창 초기화
			$("#num1").val("");
			$("#num2").val("");
			$("#oper").val("add");						
		}
	});

	
	//입력 창 초기화
	$("#num1").val("");
	$("#num2").val("");
	$("#oper").val("add");
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