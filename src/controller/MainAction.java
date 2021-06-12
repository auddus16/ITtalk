package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements Action {//∏ﬁ¿Œ

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		
		
		
		forward.setRedirect(false);
		forward.setPath("hmy_main.jsp");
		
		return forward;
	}
	
}
