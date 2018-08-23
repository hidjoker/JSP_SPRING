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
	$("#btnWrite").click(function() {
		location.href="/board/write.do";
	});
	
	$("table").on("click", "tr", function() {
		var boardno = $(this).children("td").eq(0).text();
		
		$(location).attr("href","/board/view.do?boardno="+boardno);
	});
});
</script>

</head>
<body>

<div class="container">

<h1>게시판 - LIST</h1>
<hr>
<table class="table table-striped table-hover">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>조회수</th>
	<th>추천수</th>
	<th>작성일</th>
</tr>
<c:forEach items="${boardList }" var="board">
<tr>
	<td>${board.boardno }</td>
	<td>		
		<a href="/board/view.do?boardno=${board.boardno }">${board.title }</a>
	</td>
	<td>${board.writer }</td>
	<td>${board.hit }</td>
	<td>${board.recommend }</td>
	<td>${board.writtendate }</td>
</tr>
</tbody>

</c:forEach>

</table>

</div>

	<button id="btnWrite">글쓰기</button>

<jsp:include page="/util/paging.jsp" />

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>













