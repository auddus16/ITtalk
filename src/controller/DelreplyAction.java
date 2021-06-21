package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.C;
import itTalkDO.Mb;

public class DelreplyAction implements Action{// 댓글 삭제(비밀댓글도 포함)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		Board board = new Board();//dao

		C c=new C();//do
		B b =new B();//do
		Mb mb =new Mb();//do
		

		//c_no pk.댓글번호
		c.setC_no(Integer.parseInt(req.getParameter("c_no")));
		//b_no fk.게시글번호
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//mb_nick; 닉네임
		mb.setMb_nick(req.getParameter("mb_nick"));
		//mb_no fk.회원번호
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//c_write 댓글내용
		c.setC_write(req.getParameter("c_write"));
		//c_date 등록일자
		c.setC_date(req.getParameter("c_date"));
		//c_secret 비밀댓글여부
		c.setC_secret(c.isC_secret());
		
		
		ServletContext application = req.getServletContext();
		
		// 댓글 삭제
		
		if(!board.delC(Integer.parseInt(req.getParameter("c_no")))) {//댓글 삭제 실패
			try {
				throw new Exception("댓글 삭제 실패");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {//댓글 삭제 성공
			Boolean delreply =board.delC(Integer.parseInt(req.getParameter("c_no")));
			application.setAttribute("delreply", delreply);
		}

		
		
		
		forward.setRedirect(false);
		forward.setPath("댓글삭제.jsp");


		return forward;
	}

}
