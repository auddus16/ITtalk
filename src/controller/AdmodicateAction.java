package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.AdminMenu;

public class AdmodicateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		AdminMenu adDAO = new AdminMenu();
		//updateBc(int bc_no)
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(adDAO.updateBc(Integer.parseInt(req.getParameter("bc_no")), req.getParameter("cate"))) {
			out.println("<script>alert('�����Ǿ����ϴ�.');location.href='adcate.ad';</script>");
		}
		else {
			
			out.println("<script>alert('�ٽ� �õ��ϼ���. ��������!');location.href='adcate.ad';</script>");
		}
		return null;
	}

}
