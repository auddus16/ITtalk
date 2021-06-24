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
</head>
<body onload="eValue()">
	<div style="text-align: center;">
		<h3>이메일 인증</h3>
		<form method="post" name="emailcheck" action="emailsend.main" onsubmit="return blankCheck(this)">
		이메일 : <input type="text" name="emailcheck" autofocus>
		<input type="submit" value="인증번호발송">
		</form>
	</div>
</body>
</html>