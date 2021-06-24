package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
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
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		// mb_no 회원번호
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		// rctg_no 신고카테고리번호
		rctg.setRctg_no(Integer.parseInt(req.getParameter("rctg_no")));
		// rc_write 신고내용
		rc.setRc_write(req.getParameter("rc_write"));
		// b_report 신고수
		b.setB_report(Integer.parseInt(req.getParameter("b_report")));
		// b_deleted 블라인드처리여부
		b.setB_deleted(b.isB_deleted());



		ServletContext application = req.getServletContext();
		PrintWriter out =res.getWriter();

		// 게시글 신고 boolean ReportB(int b_no , int mb_no , int rctg_no , String rc_write)(게시글번호,회원번호,신고카테고리번호,신고내용)
		//board.ReportB(Integer.parseInt(req.getParameter("b_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"));



		if(!board.ReportB(Integer.parseInt(req.getParameter("b_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"))) {//게시글 신고 실패
			//게시글 신고 실패
			out.println("<script>alert('게시글 신고 실패');history.go(-1);</script>");
		}
		else {//게시글 신고 성공
			Boolean reportb =board.ReportB(Integer.parseInt(req.getParameter("b_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"));
			out.println("<script>alert('게시글 신고 성공');</script>");
			application.setAttribute("reportb", reportb);
		}





		forward.setRedirect(false);
		forward.setPath("게시글신고.jsp");

		return forward;
	}

}
