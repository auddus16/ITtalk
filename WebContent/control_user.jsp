<!-- 간단한 작업 .jsp로 처리 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="memDAO" class="itTalkDAO.Membership"/><!-- 마이페이지에서 쓰일 DAO클래스 -->
<jsp:useBean id="mem" class="itTalkDO.Mb"/>
<jsp:setProperty property="*" name="mem"/>
<%
	String action= request.getParameter("action");
	//System.out.println(request.getParameter("nick"));
	
	//닉네임 중복 확인->안됨..
	if(action.equals("checknick")){
		//alert로 
		if(!memDAO.idCheck(request.getParameter("nick"))){
			//중복되지 않음
			out.println("<script>alert('사용가능한 닉네임입니다.');history.go(-1);</script>");
			//중복확인후 상태를 저장할,,,,
		}
		else{
			
			out.println("<script>alert('중복되는 닉네임이 존재합니다.\n다른 닉네임을 입력하세요.');history.go(-1);</script>");
		}
	}
	//본인인증->새비밀번호 설정
	else if(action.equals("modifypw")){
		//if(memDAO.)
		//만약 session 비번 == 입력한 비번 -> newpw2.jsp로
		response.sendRedirect("newpw2.jsp");
	}
		

%>