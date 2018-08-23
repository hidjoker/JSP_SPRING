<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnCancel").click(function() {
		history.go(-1);
	});
	
	$("#btnUpdate").click(function() {
		$("form").submit();	
	});
});
</script>
<style type="text/css">
#content{
	width : 99%
}

</style>
</head>
<body>

<div class="container">
<h1>게시판 - WRITE</h1>
<hr>
<div>
<form action="/board/update.do" method="post">
	<div class="form-group">
		<label for="writer">작성자</label>
		<input type="text" id="writer" name="writer" 
			value="${board.writer }" readonly="readonly"
			class="form-control"/>
	</div>
	<div class="form-group">
		<label for="title">제목</label>
		<input type="text" id="title" name="title" 
			value="${board.title }" class="form-control" />
	</div>
	<div class="form-group">
		<label for="content">본문</label>
		<textarea rows="10" id="content" name="content"
			class="form-control">${board.content }</textarea>
	</div>

<c:set var="boardno" value="${board.boardno }" scope="request"/>

</form>
<div class="text-center">	
	<button id="btnUpdate" class="btn btn-primary">수정</button>
	<button id="btnCancel" class="btn btn-danger">취소</button>
</div>
</div>
</div>

</body>
</html>