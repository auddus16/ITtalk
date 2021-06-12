<!-- 간단한 작업 .jsp로 처리 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="myDAO" class="??"/><!-- 마이페이지에서 쓰일 DAO클래스 -->
<jsp:useBean id="mem" class="itTalk.Mb"/>
<jsp:setProperty property="*" name="mem"/>
<%
	String action= request.getParameter("action");
	
	//중복된 닉네임 확인
	if(action.equals("checknick")){
	}
	//본인인증->새비밀번호 설정
	else if(action.equals("modifypw")){}
		

%>