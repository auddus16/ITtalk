package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Membership;

public class AuthNumAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String authNum = req.getParameter("authNum");
		System.out.println(authNum);
		String checkNum=(String) req.getAttribute("authNum");
		System.out.println("emailcheck : "+checkNum);
		PrintWriter out=res.getWriter();
		if(authNum==checkNum) {
			req.setAttribute("checkAuth", true);
			out.println("<script>alert('������ȣ�� ��ġ�մϴ�.');window.close();<script>");
			return null;
		}
		else {
			req.setAttribute("checkAuth", false);
			out.println("<script>alert('������ȣ�� ��ġ���� �ʽ��ϴ�.');history.back();<script>");
			return null;
		}
	}

}
