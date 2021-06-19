package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;

public class FavoriteAction implements Action {// 좋아요 

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		Board board =new Board(); //dao
		
		Mb mb = new Mb(); //do
		B b = new B(); //do
		
		
		//mb_no 회원번호
		
		//b_no 게시글번호
		
		
		
		
		
		// 게시글 좋아요
		//board.like(Integer.parseInt(req.getParameter("mb_no")),Integer.parseInt(req.getParameter("b_no")));
		
		

		forward.setRedirect(false);
		forward.setPath("좋아요를 담당하는.jsp");


		return forward;
	}

}
