package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;

public class InfoAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("인포액션 들어옴");
		ActionForward forward= new ActionForward();
		
		MyPageDAO mypageDAO= new MyPageDAO();//마이페이지 사용시 필요한 정보를 가져오기
		
		HttpSession session= req.getSession();
		session.getAttribute("mb_no");//세션에 로그인되어있는 회원번호로 구현수정해야함..
		
//		Mb myInfo= mypageDAO.Info(1);
//		myInfo.setMb_id("auddus16");
		
		Mb myInfo= new Mb();//db mypageDAO.Info() 수정 후 바꿔야함..
		myInfo.setMb_id("auddus16");
		
		req.setAttribute("myInfo", myInfo);//개인정보
		req.setAttribute("kind", "info");//마이페이지에서 어떤 페이지를 include할지 정보
		
		forward.setRedirect(false);
		forward.setPath("/hmy_mypage.jsp");
		
		return forward;
	}
}
