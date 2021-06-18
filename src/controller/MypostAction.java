package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.MyPageDAO;
import itTalkDAO.Scroll;
import itTalkDO.B;

public class MypostAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward= new ActionForward();
		
		Scroll mypageDAO= new Scroll();//마이페이지 사용시 필요한 정보를 가져오기
		
		HttpSession session= req.getSession();
		session.getAttribute("mb_no");//세션에 로그인되어있는 회원번호
		
		int cnt=0; //처음 몇개 게시글을 업로드 할지 저장하는 변수
		if(req.getParameter("cnt")==null){//기본 게시글 개수 10개로 지정
			cnt=10;
		}
		else {
			cnt=Integer.parseInt(req.getParameter("cnt"));
		}
		
		req.setAttribute("cnt", cnt);//더보기변수 셋
		
		ArrayList<B> arrB = mypageDAO.getMyBoard(1, cnt);
		ArrayList<B> total= new MyPageDAO().getMyBoard(1);
		
		req.setAttribute("total", total.size());
		req.setAttribute("mypostList", arrB);//게시글이 담긴 리스트
		req.setAttribute("kind", "post");//마이페이지에서 어떤 페이지를 include할지 정보
		
		forward.setRedirect(false);
		forward.setPath("/hmy_mypage.jsp");
		
		return forward;
	}

}
