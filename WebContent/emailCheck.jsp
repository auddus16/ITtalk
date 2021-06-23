<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	function check(){
		var form = document.authenform;
		var authNum = ${authNum};
		
		if(!form.authnum.value){
			alert("인증번호를 입력하세요")
			return false;
		}
		if(form.authnum.value!=authNum){
			alert("틀린 인증번호입니다. 인증번호를 다시 입력해주세요");
			form.authnum.value="";
			return false;
		}
		if(form.authnum.value==authNum){
			alert("인증완료")
			opener.document.joinform.emailDuplication.value="emailCheck";
		}
	}
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
	<div class="container">
		<form method="post" name="authenform" onsubmit="return check();">
			인증번호 : <input type="text" name="authnum">&nbsp;&nbsp;
			<input type="submit" class="btn btn-info" value="인증">
		</form>
	</div>
</body>
</html>