package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//b_no 게시글번호
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		
		
		PrintWriter out =res.getWriter();
		
		HttpSession session = req.getSession(false);
		
		// 게시글 좋아요
			
		
		if(!board.like(Integer.parseInt(req.getParameter("mb_no")),Integer.parseInt(req.getParameter("b_no")))) {//게시글 좋아요 실패
			out.println("<script>alert('좋아요 실패');history.go(-1);</script>");
		}
		else {// 게시글 좋아요 성공
			Boolean like=board.like(Integer.parseInt(req.getParameter("mb_no")),Integer.parseInt(req.getParameter("b_no")));
			out.println("<script>alert('좋아요 성공');</script>");
			session.setAttribute("like", like);
		}
		
		
		

		forward.setRedirect(false);
		forward.setPath("좋아요를 담당하는.jsp");


		return forward;
	}

}
