package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.AdminMenu;
import itTalkDAO.Board;

public class AddelreplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AdminMenu adDAO= new AdminMenu();
		Board bDAO = new Board();
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if((adDAO.deleteRc(Integer.parseInt(req.getParameter("c_no"))) && bDAO.delC(Integer.parseInt(req.getParameter("c_no"))))) {
			//�Ű�Խñ����̺�+�Խñ����̺��� ����
			out.println("<script>alert('�����Ǿ����ϴ�.');location.href='adreply.ad';</script>");
		}
		
		else {
			out.println("<script>alert('��������! �ٽ� �õ��ϼ���');location.href='adreply.ad';</script>");
		}
//		req.setAttribute("kind", "adreply");//� �������� include���� ����
//		forward.setRedirect(false);
//		forward.setPath("/adreply.ad");
		return null;
	}

}
