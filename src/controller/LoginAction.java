package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.AdminMenu;
import itTalkDAO.Login;
import itTalkDAO.MyPageDAO;
import itTalkDO.Ad;
import itTalkDO.B;
import itTalkDO.Mb;


public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Login login = new Login();
		MyPageDAO dao=new MyPageDAO();
		AdminMenu adm=new AdminMenu();
		
		String id=req.getParameter("id");
		int mb_no=dao.getMb_no(id);
		int ad_no=adm.getAd_no(id);
		
		Mb mb= dao.Info(mb_no);
		Ad ad= adm.AdInfo(ad_no);
		
		HttpSession session=req.getSession();
		ActionForward forward= null;
		String password = req.getParameter("pw");
		System.out.println("id : "+id+"/ pw : "+password);
		if(login.login(id, req.getParameter("pw"))) { // mb 로그인
			session.setAttribute("mb_id", id);
			session.setAttribute("mb_no", mb_no);
			session.setAttribute("mb_job", mb.isMb_job());
			session.setAttribute("mb_nick", mb.getMb_nick());
			forward=new ActionForward();
			forward.setPath("main.main");
			forward.setRedirect(false);
		}
		else if(login.adminLogin(id, req.getParameter("pw"))) { // ad 로그인
			session.setAttribute("ad_id", id);
			session.setAttribute("ad_nick", ad.getAd_nick());
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
