<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>닉네임 중복확인 결과</title>
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
		<h3>닉네임 중복확인 결과</h3>
		<%
			String nickcheck=request.getParameter("nickcheck").trim();
			boolean check= (boolean)request.getAttribute("check");
			out.println("입력 ID : <strong>"+nickcheck+"</strong");
			if(check==false){
				out.println("<br><p>사용 가능한 닉네임입니다.</p>");
				out.println("<a href='javascript:apply(\""+nickcheck+"\")'>[적용]</a>");
			}
			else{
				out.println("<br><p style='color:red'>해당 닉네임은 사용할 수 없습니다.</p>");
			}
		%>
		<hr>
		<a href="javascript:history.back()">[다시검색]</a>
		&nbsp;&nbsp;
		<a href="javascript:window.close()">[창닫기]</a>
	</div>
</body>
</html>