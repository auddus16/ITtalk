<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>인증 성공</title>
<script type="text/javascript">
	function apply(checkedemail){
		opener.document.joinform.mb_certify.value = 0;
		opener.document.joinform.mb_email.value = checkedemail;
		
		window.close();
	}
</script>
</head>
<body>
	<div style="text-align : center;">
		<h3>이메일 인증 결과</h3>
		<%
			String checkedemail=(String)session.getAttribute("checkedemail");
			boolean authcheck= (boolean)request.getAttribute("authcheck");
			out.println("입력 이메일 : <strong>"+checkedemail+"</strong");
			if(authcheck==true){
				out.println("<br><p>이메일 인증이 완료되었습니다.</p>");
				session.removeAttribute("checkedemail");
				out.println("<a href='javascript:apply(\""+checkedemail+"\")'>[적용]</a>");
			}
		%>
		<hr>
		<a href="javascript:window.close();">[창닫기]</a>
	</div>
</body>
</html>