<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
	function blankCheck(p){
		var emailcheck=p.emailcheck.value;
		emailcheck=emailcheck.trim();
		if(emailcheck==""){
			alert("이메일을 입력해주세요");
			return false;
		}
		return true;
	}
	function eValue(){
        document.emailcheck.emailcheck.value = opener.document.joinform.mb_email.value;
    }
</script>
<style>
button {
	color: linen;
	background: lightseagreen;
	border: 2px solid white;
	font-size: 19px;
	border-radius: 6px;
	box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px
		rgba(0, 0, 0, 0.06);
	cursor: pointer;
	transition: 0.5s;
}
</style>
</head>
<body onload="eValue()">
	<div style="text-align: center;">
		<h3>이메일 인증</h3>
		<form method="post" name="emailcheck" action="emailsend.main" onsubmit="return blankCheck(this)">
		이메일 : <input type="text" name="emailcheck" autofocus>
		<button type="submit" value="인증번호발송">인증번호발송</button>
		</form>
	</div>
</body>
</html>