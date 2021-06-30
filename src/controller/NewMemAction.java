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
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		Membership membership=new Membership();
		Mb mb=new Mb();
		String mb_id=req.getParameter("mb_id");
		String mb_pw=req.getParameter("mb_pw");
		String mb_pw_check=req.getParameter("mb_pw_check");
		String mb_email=req.getParameter("mb_email");
		String mb_nick=req.getParameter("mb_nick");
		boolean mb_job=Boolean.parseBoolean(req.getParameter("mb_job"));
		boolean mb_certify=Boolean.parseBoolean(req.getParameter("mb_certify"));
		System.out.println("mb_job:"+mb_job);
		
		PrintWriter out=res.getWriter();
		
		if(mb_id!="" && mb_pw!="" && mb_email!="" && mb_nick!="" && mb_certify!=true && mb_pw.equals(mb_pw_check) && membership.idCheck(mb_id)==false && membership.nickCheck(mb_nick)==false) {
			mb.setMb_id(mb_id);
			mb.setMb_pw(mb_pw);
			mb.setMb_email(mb_email);
			mb.setMb_nick(mb_nick);
			mb.setMb_job(mb_job);
			mb.setMb_certify(mb_certify);
			
			membership.addMember(mb);
			out.println("<script>alert('회원가입 성공'); location.href  ='index.jsp';</script>");
		}
		else if(membership.nickCheck(mb_nick)){
			out.println("<script>alert('중복된 닉네임입니다.');history.go(-1)</script>");
		}
		else {
			out.println("<script>alert('회원가입 실패');location.href='regform.jsp';</script>");
		}
		
		return null;
		


	}	

}
