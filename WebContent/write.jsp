<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지2-내가 쓴 게시글/댓글</title>
<style type="text/css">
table{
	border-collapse:collapse;
}

table tr th td{
	text-align:center;
	border:2px soild mint;
	padding:5px;
}

</style>
</head>
<body>
<div id="mypost">
	<p>[내 게시글]</p>
	<table>
		<!-- forEach로 내가 쓴 게시글 출력하기 -->
		<tr>
			<td>게시글 제목입니당</td>
			<td>게시글 등록일자</td>
		</tr>
	</table>
</div>
<br>
<div id="mypost">
	<p>[내 댓글]</p>
	<table>
		
		<!-- forEach로 내가 쓴 댓글 출력하기 -->
		<tr>
			<td>게시글 제목입니당</td>
			<td>댓글 내용</td>
			<td>댓글 등록일자</td>
		</tr>
	</table>
</div>
</body>
</html>