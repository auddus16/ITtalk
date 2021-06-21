package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Membership;

public class Mb_nickCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String mb_nick = req.getParameter("mb_nick");
		Membership membership = new Membership();

		boolean check = membership.nickCheck(mb_nick);

		PrintWriter out = res.getWriter();

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		if(check){
			req.setAttribute("check", check);
			out.println("<script>alert('중복된 닉네임 입니다.');</script>");
		}
		else{
			out.println("<script>alert('사용가능한 닉네임 입니다.');</script>");
		}
		
		
		return null;
	}

}
