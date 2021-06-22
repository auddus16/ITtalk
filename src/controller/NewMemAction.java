package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Membership;
import itTalkDO.Mb;


public class NewMemAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward=new ActionForward();
		
		Membership membership=new Membership();
		
		Mb mem=new Mb();
		mem.setMb_id(req.getParameter("mb_id"));
		mem.setMb_pw(req.getParameter("mb_pw"));
		mem.setMb_email(req.getParameter("mb_email"));
		mem.setMb_nick(req.getParameter("mb_nick"));
		mem.setMb_job(Boolean.parseBoolean(req.getParameter("mb_job")));
		mem.setMb_certify(Boolean.parseBoolean(req.getParameter("mb_certify")));
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out=res.getWriter();
		if(membership.addMember(mem)){
			forward.setPath("regcompletion.jsp");
			forward.setRedirect(false);
			return forward;
		}
		else{
			out.println("<script>alert('회원가입 실패');history.go(-1);</script>");
			forward.setPath("newmem.main");
			forward.setRedirect(false);
			return forward;
		}
		
		
		
		
	}	

}
