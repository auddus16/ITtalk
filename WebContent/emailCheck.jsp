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
			alert("������ȣ�� �Է��ϼ���")
			return false;
		}
		if(form.authnum.value!=authNum){
			alert("Ʋ�� ������ȣ�Դϴ�. ������ȣ�� �ٽ� �Է����ּ���");
			form.authnum.value="";
			return false;
		}
		if(form.authnum.value==authNum){
			alert("�����Ϸ�")
			opener.document.joinform.emailDuplication.value="emailCheck";
		}
	}
	function blankCheck(p){
		var emailcheck=p.emailcheck.value;
		emailcheck=emailcheck.trim();
		if(emailcheck==""){
			alert("�̸����� �Է����ּ���");
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
		<h3>�̸��� ����</h3>
		<form method="post" name="emailcheck" action="emailsend.main" onsubmit="return blankCheck(this)">
		�̸��� : <input type="text" name="emailcheck" autofocus>
		<input type="submit" value="������ȣ�߼�">
		</form>
	</div>
	<div class="container">
		<form method="post" name="authenform" onsubmit="return check();">
			������ȣ : <input type="text" name="authnum">&nbsp;&nbsp;
			<input type="submit" class="btn btn-info" value="����">
		</form>
	</div>
</body>
</html>