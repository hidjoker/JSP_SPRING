<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

// Object Type
var json = {"a":1, "b":2, "c":"cherry","d":true};
console.log(json);

// Object Type -> String : marshalling
var jsonText = JSON.stringify(json);
console.log(jsonText);

// String -> Object Type : unmarshalling
var jsonObject = JSON.parse(jsonText);
console.log(jsonObject)


</script>
</head>
<body>

</body>
</html>