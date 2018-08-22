<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/board/write.do" method="post">

	<label>작성자 : ${sessionScope.writer }</label><br>
	<label>제목 : <input type="text" size="70" name="title"/></label>
	<hr>
	<label>내용 : <textarea rows="20" cols="70" name="content"></textarea></label>
	<hr>
	&nbsp;&nbsp;&nbsp;<input type="submit" value="전송"/>
	<a href="/board/pagingList.do"><button>취소</button></a>
</form>

</body>
</html>