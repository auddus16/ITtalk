package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.C;
import itTalkDO.Mb;
import itTalkDO.Rc;
import itTalkDO.Rctg;

public class ReplyReportAction implements Action{// 댓글신고

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		Board board = new Board(); //dao
		
		C c=new C(); //do
		Mb mb =new Mb(); //do
		Rctg rctg =new Rctg(); //do
		Rc rc= new Rc(); //do

		//c_no 댓글번호
		c.setC_no(Integer.parseInt(req.getParameter("c_no")));
		//mb_no 회원번호
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//rctg_no 신고카테고리번호
		rctg.setRctg_no(Integer.parseInt(req.getParameter("rctg_no")));
		//rc_write 신고내용
		rc.setRc_write(req.getParameter("rc_write"));
		//c_report 신고수
		c.setC_report(Integer.parseInt(req.getParameter("c_report")));
		//c_deleted 블라인드처리여부
		c.setC_deleted(c.isC_deleted());
		
		
		
		//댓글 신고 boolean ReportC(int c_no , int mb_no , int rctg_no , String rc_write)(댓글 번호,회원번호,신고카테고리번호,신고내용)
		//board.ReportC(Integer.parseInt(req.getParameter("c_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"));
		
		
		if(!board.ReportC(Integer.parseInt(req.getParameter("c_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"))) {//댓글 신고 실패
			try {//댓글 신고 실패
				throw new Exception("댓글 신고 실패");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {// 댓글 신고 성공
			Boolean reportc=board.ReportC(Integer.parseInt(req.getParameter("c_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"));
			req.setAttribute("reportc", reportc);
		}
		
		
		forward.setRedirect(false);
		forward.setPath("댓글신고.jsp");

		return forward;
	}

}
