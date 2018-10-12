<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/file/upload_cos.do" method="post"
	enctype="multipart/form-data">
	
<label>제목 : <input type="text" name="title" /></label><br>
<label>첨부 : <input type="file" name="uploadFile"/></label><br>
<input type="submit" value="업로드"/>	
</form>

</body>
</html>