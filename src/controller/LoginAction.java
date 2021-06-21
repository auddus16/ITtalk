package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Login;
import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;


public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Login login = new Login();
		MyPageDAO dao=new MyPageDAO();
		String id=req.getParameter("id");
		Mb mb=new Mb();

		ActionForward forward= null;
		String password = req.getParameter("pw");
		System.out.println("id : "+id+"/ pw : "+password);
		if(login.login(id, req.getParameter("pw"))) {
			HttpSession session=req.getSession();
			session.setAttribute("mb_id", id);
			session.setAttribute("mb_no", dao.getMb_no(id));
			System.out.println("mb_no : "+dao.getMb_no(id));
			System.out.println("세션 mb_id : "+session.getAttribute("mb_id"));
			System.out.println("세션 mb_no : "+session.getAttribute("mb_no"));
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
