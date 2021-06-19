package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;
import itTalkDO.Rc;
import itTalkDO.Rctg;

public class MsgReportAction implements Action{//게시글 신고

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		Board board = new Board(); //dao
		
		B b = new B();//do
		Mb mb =new Mb();//do
		Rc rc = new Rc();//do
		Rctg rctg =new Rctg();//do
		
		// b_no 게시글번호
		// mb_no 회원번호
		// rctg_no 신고카테고리번호
		// rc_write 신고내용
		// b_report 신고수
		// b_deleted 블라인드처리여부
		
		
		// 게시글 신고 boolean ReportB(int b_no , int mb_no , int rctg_no , String rc_write)(게시글번호,회원번호,신고카테고리번호,신고내용)
		//board.ReportB(Integer.parseInt(req.getParameter("b_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"));
		
		
		
		
		
		
		forward.setRedirect(false);
		forward.setPath("게시글신고.jsp");

		return forward;
	}

}
