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
		var idcheck=p.idcheck.value;
		idcheck=mb_id.trim();
		if(idcheck==""){
			alert("아이디를 입력해주세요");
			return false;
		}
		return true;
	}
	 function pValue(){
         document.idcheck.idcheck.value = opener.document.joinform.mb_id.value;
     }
</script>
</head>
<body onload="pValue()">
	
	<div style="text-align: center;">
		<h3>아이디 중복확인</h3>
		<form method="post" name="idcheck" action="checkid.main" onsubmit="return blankCheck(this)">
		아이디 : <input type="text" name="idcheck" autofocus>
		<input type="submit" value="중복확인">
		</form>
	</div>
	
</body>
</html>