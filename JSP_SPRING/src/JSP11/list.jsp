<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

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
	<td>${board.title }</td>
	<td>${board.writer }</td>
	<td>${board.hit }</td>
	<td>${board.recommend }</td>
	<td>${board.writtendate }</td>
</tr>
</tbody>

</c:forEach>

</table>

</div>

<a href="/board/write.do">
	<button>글쓰기</button>
</a>

<jsp:include page="/util/paging.jsp" />

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>













