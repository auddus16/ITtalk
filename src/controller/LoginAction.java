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
		
		String id=req.getParameter("id");
		ActionForward forward= null;
		String password = req.getParameter("pw");
		System.out.println(password+" "+id);
		if(login.login(id, req.getParameter("pw"))) {
			HttpSession session=req.getSession();
			session.setAttribute("mb_id", id);
			forward=new ActionForward();
			forward.setPath("main.main");
			forward.setRedirect(false);
		}
		else if(login.adminLogin(id, req.getParameter("pw"))) {
			HttpSession session=req.getSession();
			session.setAttribute("ad_id", id);
			forward=new ActionForward();
			forward.setPath("main.main");
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
