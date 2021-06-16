package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;

public class MypageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward= new ActionForward();
		
		MyPageDAO mypageDAO= new MyPageDAO();//마이페이지 사용시 필요한 정보를 가져오기
		
//		ArrayList<String> myInfo = new ArrayList<>();//개인정보를 담을 리스트
//		req.setAttribute("info", new Mb());
//		
//		MessageDAO msgDAO= new MessageDAO();
//		req.setAttribute("datas", msgDAO.getAll(mcnt));//게시판 목록
//		MemberDAO memDAO= new MemberDAO();
//		req.setAttribute("users", memDAO.getMembers());//회원 목록
//		
		//pageContext.forward("main.jsp");
		req.setAttribute("kind", "info");
		forward.setRedirect(false);
		forward.setPath("/hmy_mypage.jsp");
		
		return forward;
	}

}
