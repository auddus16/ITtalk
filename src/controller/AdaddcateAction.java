package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.AdminMenu;
import itTalkDO.Bc;

public class AdaddcateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AdminMenu adDAO = new AdminMenu();
		
		Bc bc= new Bc();
		bc.setBc_name(req.getParameter("new"));
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(adDAO.addMember(bc)) {
			out.println("<script>alert('�߰��Ǿ����ϴ�.');location.href='adcate.ad';</script>");
		}
		else {
			
			out.println("<script>alert('�ٽ� �õ��ϼ���. �߰�����!');location.href='adcate.ad';</script>");
		}
		return null;
	}

}
//public boolean addMember(Bc bc)