package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyReportAction implements Action{// 댓글신고

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		//c_report 신고수


		forward.setRedirect(false);
		forward.setPath("댓글신고.jsp");

		return forward;
	}

}
