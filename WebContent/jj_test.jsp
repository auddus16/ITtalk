<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memDAO" class="itTalkDAO.Membership"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<% if(memDAO.idCheck("ss")){
	out.print("확인");
	out.print("확인");
}
%>
</div>


</body>
</html>