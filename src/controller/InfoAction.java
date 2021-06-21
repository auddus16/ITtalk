package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;

public class InfoAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward= new ActionForward();
		
		MyPageDAO mypageDAO= new MyPageDAO();//마이페이지 사용시 필요한 정보를 가져오기
		
		HttpSession session= req.getSession();
		
//		Mb myInfo= mypageDAO.Info(1);
//		myInfo.setMb_id("auddus16");
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(session.getAttribute("mb_no")==null) {
			out.println("<script>alert('로그인하세요!');location.href='hmy_login.jsp';</script>");
			return null;
		}
		
		Mb myInfo= mypageDAO.Info((Integer)session.getAttribute("mb_no"));// 수정 후 바꿔야함..
		
		System.out.println("InfoAction"+myInfo.getMb_id());
		System.out.println(session.getAttribute("mb_no"));
		
		req.setAttribute("myInfo", myInfo);//개인정보
		
		if(req.getParameter("flag") == null || req.getParameter("flag").equals("false")) {
			req.setAttribute("flag", false);//다음단계로 넘어갈수있는지 여부
			
		}
		else {
			
			req.setAttribute("flag", true);
		}
		req.setAttribute("kind", "info");//마이페이지에서 어떤 페이지를 include할지 정보
		forward.setRedirect(false);
		forward.setPath("/hmy_mypage.jsp");
		
		return forward;
	}
}
