package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;

public class Addelpost2Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Board bDAO = new Board();
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(bDAO.delB(req, res)) {
			//�Ű�Խñ����̺�+�Խñ����̺��� ����
			out.println("<script>alert('�����Ǿ����ϴ�.');location.href='adallpost.ad';</script>");
		}
		
		else {
			out.println("<script>alert('��������! �ٽ� �õ��ϼ���');location.href='adallpost.ad';</script>");
		}
		
		return null;
	}

}
