<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 확인</title>
<script type="text/javascript">
	function blankCheck(p){
		var mb_id=p.mb_id.value;
		mb_id=mb_id.trim();
		if(mb_id==""){
			alert("아이디를 입력해주세요");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	
	<div style="text-align: center;">
		<h3>아이디 중복확인</h3>
		<form method="post" action="checkid.main" onsubmit="return blankCheck(this)">
		아이디 : <input type="text" name="mb_id" value="${mb_id}" autofocus>
		<input type="submit" value="중복확인">
		</form>
	</div>
	
</body>
</html>