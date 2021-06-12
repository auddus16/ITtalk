package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewscretmsgAction implements Action{//비밀 댓글 작성

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();




		forward.setRedirect(false);
		forward.setPath("비밀댓글 작성.jsp");

		return forward;
	}

}
