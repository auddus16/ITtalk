package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelreplyAction implements Action{// ¥Ò±€ ªË¡¶

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();



		forward.setRedirect(false);
		forward.setPath("¥Ò±€ªË¡¶.jsp");


		return forward;
	}

}
