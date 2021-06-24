<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 중복확인 결과</title>
<script type="text/javascript">
	function apply(idcheck){
		opener.document.joinform.emailDuplication.value = "emailCheck";
		opener.document.joinform.mb_email.value = idcheck;
		session.removeAttribute("checkedemail");
		
		window.close(0);
	}
</script>
</head>
<body>
	<div style="text-align : center;">
		<h3>이메일 중복 결과</h3>
		<%
			String checkedemail=(String)session.getAttribute("checkedemail");
			out.println("입력 이메일 : <strong>"+checkedemail+"</strong");
			out.println("<br><p style='color:red'>해당 이메일은 중복 사용중입니다.</p>");
		%>
		<hr>
		<a href="javascript:history.back()">[다시검색]</a>
		&nbsp;&nbsp;
		<a href="javascript:window.close()">[창닫기]</a>
	</div>
</body>
</html>