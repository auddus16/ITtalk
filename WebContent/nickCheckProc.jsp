<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�г��� �ߺ�Ȯ�� ���</title>
<script type="text/javascript">
	function apply(nickcheck){
		opener.document.joinform.nickDuplication.value = "nickCheck";
		opener.document.joinform.mb_nick.value = nickcheck;
		

		if(opener != null){
			opener.chkForm = null;
			self.close();
		}
	}
</script>

</head>
<body>
	<div style="text-align : center;">
		<h3>�г��� �ߺ�Ȯ�� ���</h3>
		<%
			String nickcheck=request.getParameter("nickcheck").trim();
			boolean check= (boolean)request.getAttribute("check");
			out.println("�Է� ID : <strong>"+nickcheck+"</strong");
			if(check==false){
				out.println("<br><p>��� ������ �г����Դϴ�.</p>");
				out.println("<a href='javascript:apply(\""+nickcheck+"\")'>[����]</a>");
			}
			else{
				out.println("<br><p style='color:red'>�ش� �г����� ����� �� �����ϴ�.</p>");
			}
		%>
		<hr>
		<a href="javascript:history.back()">[�ٽð˻�]</a>
		&nbsp;&nbsp;
		<a href="javascript:window.close()">[â�ݱ�]</a>
	</div>
</body>
</html>