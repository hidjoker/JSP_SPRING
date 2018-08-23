<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	$("#btnList").click(function() {
		$(location).attr("href", "/board/pagingList.do");
	});
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/board/update.do?boardno="+${board.boardno });
	});
	$("#btnDelete").click(function() {
		$(location).attr("href", "/board/delete.do?boardno="+${board.boardno });
	});
});
</script>

</head>
<body>

<div class="container">
<h1>게시판 - VIEW</h1>
<hr>
<div>
<table class="table table-bordered">
<tr>
<td class="info">글번호</td><td>${board.boardno }</td>
<td class="info">제목</td><td colspan="2">${board.title }</td>
</tr>

<tr>
<td class="info">아이디</td><td>${board.writerid }</td>
<td class="info">이름</td><td colspan="2">${board.writer}</td>
</tr>

<tr><td class="info">본문</td><td colspan="4">${board.content }</td></tr>

<tr>
<td class="info">조회수</td><td>${board.hit }</td>
<td class="info">추천수</td><td>${board.recommend }</td>
</tr>

<tr>
<td class="info">작성일</td><td colspan="4">${board.writtendate }</td>
</tr>
</table>
</div>

<div class="text-center">	
	<button id="btnList" class="btn btn-primary">목록</button>
	<button id="btnUpdate" class="btn btn-info">수정</button>
	<button id="btnDelete" class="btn btn-danger">삭제</button>
</div>
</div>

</body>
</html>







