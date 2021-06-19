package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;

public class ModifypwAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MyPageDAO mypageDAO= new MyPageDAO();
		
		HttpSession session= req.getSession();
		session.getAttribute("mb_no");//세션에 로그인되어있는 회원번호로 구현수정해야함..
		
		Mb myInfo= mypageDAO.Info(1);// 수정 후 바꿔야함..
		
		String paramPw =req.getParameter("pw");
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(paramPw.equals(req.getParameter("checkpw"))) {
			//비밀번호확인됨.
			//db메소드로 비밀번호 변경해야함.
			out.println("<script>alert('비밀번호 변경했습니다.');window.close();</script>");
		}
		else {
			//비밀번호 확인 실패
			out.println("<script>alert('비밀번호를 확인해주세요.');history.go(-1);</script>");
		}
		return null;
	}

}
