<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���̵� �ߺ�Ȯ�� ���</title>
<script type="text/javascript">
	function apply(idcheck){
		opener.document.joinform.idDuplication.value = "idCheck";
		opener.document.joinform.mb_id.value = idcheck;
		

		if(opener != null){
			opener.chkForm = null;
			self.close();
		}
	}
</script>

</head>
<body>
	<div style="text-align : center;">
		<h3>���̵� �ߺ�Ȯ�� ���</h3>
		<%
			String idcheck=request.getParameter("idcheck").trim();
			boolean check= (boolean)request.getAttribute("check");
			out.println("�Է� ID : <strong>"+idcheck+"</strong");
			if(check==false){
				out.println("<br><p>��� ������ ���̵��Դϴ�.</p>");
				out.println("<a href='javascript:apply(\""+idcheck+"\")'>[����]</a>");
			}
			else{
				out.println("<br><p style='color:red'>�ش� ���̵�� ����� �� �����ϴ�.</p>");
			}
		%>
		<hr>
		<a href="javascript:history.back()">[�ٽð˻�]</a>
		&nbsp;&nbsp;
		<a href="javascript:window.close()">[â�ݱ�]</a>
	</div>
</body>
</html>