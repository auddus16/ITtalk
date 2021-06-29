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
		var idcheck=p.nickcheck.value;
		idcheck=mb_nick.trim();
		if(idcheck==""){
			alert("닉네임을 입력해주세요");
			return false;
		}
		return true;
	}
	 function pValue(){
         document.nickcheck.nickcheck.value = opener.document.joinform.mb_nick.value;
     }
</script>
</head>
<body onload="pValue()">
	
	<div style="text-align: center;">
		<h3>닉네임 중복확인</h3>
		<form method="post" name="nickcheck" action="checknick.main" onsubmit="return blankCheck(this)">
		닉네임 : <input type="text" name="nickcheck" autofocus>
		<input type="submit" value="중복확인">
		</form>
	</div>
	
</body>
</html>