package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		session.invalidate(); 
		session.removeAttribute("mb_id");
		
		ActionForward forward=new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(false);
		
		return forward;
	}

}
