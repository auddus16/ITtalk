<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorpage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러발생</title>
</head>
<body>
	
<h2>처리중에 에러 발생!</h2>
<hr>
<p>상태코드: ${pageContext.errorData.statusCode}</p>
<br>
<p>예외타입: ${pageContext.errorData.throwable}</p>

</body>
</html>