package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Membership;
import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;

public class CheckmemAction implements Action {
	//비밀번호 변경 액션 & 회원탈퇴시 비밀번호 확인 액션
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MyPageDAO mypageDAO= new MyPageDAO();
		
		HttpSession session= req.getSession();
		session.getAttribute("mb_no");//세션에 로그인되어있는 회원번호로 구현수정해야함..
		
		Mb myInfo= mypageDAO.Info(1);// 수정 후 바꿔야함..
		
		String paramPw =req.getParameter("pw");
		System.out.println(paramPw);
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(paramPw.equals(myInfo.getMb_pw())) {
			//본인인증 성공
			System.out.println(myInfo.getMb_pw());
			System.out.println(req.getParameter("c"));
			
			if(req.getParameter("c")!=null) {//회원탈퇴 액션일 때
				
				if(req.getParameter("c").equals("withdraw")) {
					mypageDAO.deleteMember(1);
					out.println("<script>alert('회원탈퇴 되었습니다.');</script>");
				}
			}
			
			else {//비밀번호변경 액션일때
				
				out.println("<script>location.href='newpw2.jsp';</script>");
			}
		}
		else {
			//본인인증 실패
			System.out.println(myInfo.getMb_pw());
			out.println("<script>alert('비밀번호가 일치하지 않습니다.');history.go(-1);</script>");
		}
		return null;
	}

}
