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
		
		Membership membership=new Membership();
		Mb mem=new Mb();
		mem.setMb_id(req.getParameter("mb_id"));
		mem.setMb_pw(req.getParameter("mb_pw"));
		mem.setMb_email(req.getParameter("md_email"));
		mem.setMb_nick(req.getParameter("mb_nick"));
		mem.setMb_job(Boolean.parseBoolean(req.getParameter("mb_job")));
		mem.setMb_certify(Boolean.parseBoolean(req.getParameter("mb_certify")));
		
		
		PrintWriter out=res.getWriter();
		if(membership.addMember(mem)){
			out.println("<script>alert('회원가입 성공');opener.location.reload();window.close();</script>");
		}
		else{
			out.println("<script>alert('회원가입 실패');history.go(-1);</script>");
		}
		
		return null;
		
		
		
	}	

}
