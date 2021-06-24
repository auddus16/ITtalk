package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.MyPageDAO;
import itTalkDO.C;

public class MyreplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward= new ActionForward();
		
		MyPageDAO mypageDAO= new MyPageDAO();//마이페이지 사용시 필요한 정보를 가져오기
		
		HttpSession session= req.getSession();
		
		int cnt=0; //처음 몇개 게시글을 업로드 할지 저장하는 변수
		if(req.getParameter("cnt")==null){//기본 댓글 개수 5개로 지정
			cnt=5;
		}
		else {
			cnt=Integer.parseInt(req.getParameter("cnt"));
		}
		
		req.setAttribute("cnt", cnt);//더보기변수 셋
		
		//ArrayList<C> arrC= mypageDAO.getMyComment((Integer)session.getAttribute("mb_no"));
		ArrayList<C> arrC= mypageDAO.getMyComment((Integer)session.getAttribute("mb_no"));
		
		ObjectMapper mapper= new ObjectMapper();
		String jsonStr= mapper.writeValueAsString(arrC);
		req.setAttribute("json", jsonStr);

		req.setAttribute("myreplyList", arrC);//댓글이 담긴 리스트
		
		req.setAttribute("kind", "reply");//마이페이지에서 어떤 페이지를 include할지 정보
		
		forward.setRedirect(false);
		forward.setPath("/hmy_mypage.jsp");
		
		return forward;
	}

}
