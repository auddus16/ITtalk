<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증번호 확인</title>
<script type="text/javascript">
function blankCheck(p){
	var authNum=p.authNum.value;
	authNum=authNum.trim();
	if(authNum==""){
		alert("인증번호를 입력해주세요");
		return false;
	}
	return true;
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
<body>
		<div class="menu" style="border-bottom-width: 0px;">
			<div id="id" style="margin-left: 10px,">인증번호</div>
			<form method="post" name="AuthNumChk" action="auth.main" onsubmit="return blankCheck(this)">
				<input type="text" name="authNum" size="25">
				<input type="hidden" name="checknum" value="${checkNum}">
				<button type="submit" >인증번호 확인</button>
			</form>
		</div>
</body>
</html>