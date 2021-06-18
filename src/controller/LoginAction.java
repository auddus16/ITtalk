package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Login;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Login login = new Login();
		
		String mb_id=req.getParameter("mb_id");
		String ad_id=req.getParameter("ad_id");
		ActionForward forward= null;
		
		if(login.login(mb_id, req.getParameter("mb_pw"))) {
			HttpSession session=req.getSession();
			session.setAttribute("mb_id", mb_id);
			forward=new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		}
		else if(login.adminLogin(ad_id, req.getParameter("ad_pw"))) {
			HttpSession session=req.getSession();
			session.setAttribute("ad_id", ad_id);
			forward=new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		}
		else {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out=res.getWriter();
			out.println("<script>alert('로그인 실패');history.go(-1);</script>");
		}
		
		return forward;
	}

}
