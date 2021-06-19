package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.C;
import itTalkDO.Mb;

public class DelreplyAction implements Action{// 댓글 삭제(비밀댓글도 포함)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		Board board = new Board();//dao

		C c=new C();//do
		Mb mb =new Mb();//do
		

		//c_no pk.댓글번호
		//b_no fk.게시글번호
		//mb_nick; 닉네임
		mb.setMb_nick(req.getParameter("mb_nick"));
		//mb_no fk.회원번호
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//c_write 댓글내용
		//c_date 등록일자
		//c_secret 비밀댓글여부
		
		
		
		// 댓글 삭제
		//board.delC(Integer.parseInt(req.getParameter("c_no")));


		forward.setRedirect(false);
		forward.setPath("댓글삭제.jsp");


		return forward;
	}

}
