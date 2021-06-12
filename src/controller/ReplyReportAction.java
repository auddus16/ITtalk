package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyReportAction implements Action{// ´ñ±Û½Å°í

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();




		forward.setRedirect(false);
		forward.setPath("´ñ±Û½Å°í.jsp");

		return forward;
	}

}
