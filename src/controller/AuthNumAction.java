package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Membership;

public class AuthNumAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		ActionForward forward= new ActionForward();
		HttpSession session=req.getSession();
		String authNum = req.getParameter("authNum");
		System.out.println(authNum);
		String checkNum=(String) session.getAttribute("checkNum");
		System.out.println("checkNum : "+checkNum);
		
		PrintWriter out=res.getWriter();
		if(authNum.equals(checkNum)) {
			
			session.removeAttribute("checkNum");
			
			req.setAttribute("authcheck", true); // 인증번호 일치
			forward.setRedirect(false);
			forward.setPath("/authCheckProc.jsp");
			return forward;
		}
		else {
			out.println("<script>alert('인증번호를 확인해주세요.');window.history.back();</script>");
			return null;
		}
	}

}
