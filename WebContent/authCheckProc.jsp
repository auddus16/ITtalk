<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ����</title>
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
		<h3>�̸��� ���� ���</h3>
		<%
			String checkedemail=(String)session.getAttribute("checkedemail");
			boolean authcheck= (boolean)request.getAttribute("authcheck");
			out.println("�Է� �̸��� : <strong>"+checkedemail+"</strong");
			if(authcheck==true){
				out.println("<br><p>�̸��� ������ �Ϸ�Ǿ����ϴ�.</p>");
				session.removeAttribute("checkedemail");
				out.println("<a href='javascript:apply(\""+checkedemail+"\")'>[����]</a>");
			}
		%>
		<hr>
		<a href="javascript:window.close();">[â�ݱ�]</a>
	</div>
</body>
</html>