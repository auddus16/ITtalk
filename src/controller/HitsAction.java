package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;

public class HitsAction implements Action{//��ȸ��

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ActionForward forward = new ActionForward();

		Board board = new Board();//dao

		B b=new B(); //do
		
		//b_no �Խñ� ��ȣ
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//b_hits ��ȸ��
		b.setB_hits(Integer.parseInt(req.getParameter("b_hits")));


		//��ȸ��
		
		Boolean hits=board.hits(Integer.parseInt(req.getParameter("b_no")));
		req.setAttribute("hits", hits);

		
		
		forward.setRedirect(false);
		forward.setPath("��ȸ�����°�.jsp");

		return forward;
	}
}
