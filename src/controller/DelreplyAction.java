package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.C;
import itTalkDO.Mb;

public class DelreplyAction implements Action{// ��� ����(��д�۵� ����)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		Board board = new Board();//dao

		C c=new C();//do
		Mb mb =new Mb();//do
		

		//c_no pk.��۹�ȣ
		//b_no fk.�Խñ۹�ȣ
		//mb_nick; �г���
		mb.setMb_nick(req.getParameter("mb_nick"));
		//mb_no fk.ȸ����ȣ
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//c_write ��۳���
		//c_date �������
		//c_secret ��д�ۿ���
		
		
		
		// ��� ����
		//board.delC(Integer.parseInt(req.getParameter("c_no")));


		forward.setRedirect(false);
		forward.setPath("��ۻ���.jsp");


		return forward;
	}

}
