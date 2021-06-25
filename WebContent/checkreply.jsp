<%@page import="itTalkDO.C"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="adDAO" class="itTalkDAO.AdminMenu"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고댓글조회</title>
</head>
<body>
<h4>신고댓글 내용</h4>
<%
	int n= Integer.parseInt(request.getParameter("c_no"));
	C c= adDAO.getReportComment(n);
%>
<div><%= c.getC_write() %></div>
</body> 
</html>