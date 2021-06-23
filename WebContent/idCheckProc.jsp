<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>아이디 중복확인 결과</title>
<script type="text/javascript">
	function apply(mb_id){
		opener.document.regform.mb_id.value=mb_id;
		window.close();
	}
</script>
</head>
<body>
	<div style="text-align : center;">
		<h3>아이디 중복확인 결과</h3>
		<%
			String mb_id=request.getParameter("mb_id").trim();
			boolean check= (boolean)request.getAttribute("check");
			out.println("입력 ID : <strong>"+mb_id+"</strong");
			if(check==false){
				out.println("<br><p>사용 가능한 아이디입니다.</p>");
				out.println("<a href='javascript:apply(\""+mb_id+"\")'>[적용]</a>");
			}
			else{
				out.println("<br><p style='color:red'>해당 아이디는 사용할 수 없습니다.</p>");
			}
		%>
		<hr>
		<a href="javascript:history.back()">[다시검색]</a>
		&nbsp;&nbsp;
		<a href="javascript:window.close()">[창닫기]</a>
	</div>
</body>
</html>