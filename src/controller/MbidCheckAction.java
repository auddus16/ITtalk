package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Membership;

public class MbidCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward=new ActionForward();
		
		String mb_id = req.getParameter("mb_id");
		Membership membership = new Membership();
		System.out.println(mb_id);
		boolean check = membership.idCheck(mb_id);
		System.out.println(check);
		req.setAttribute("check", check);
		System.out.println(req.getAttribute("check"));
		PrintWriter out = res.getWriter();

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		return null;
	}

}
