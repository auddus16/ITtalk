package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;

public class NewmsgAction implements Action{// �Խñ� �ۼ�

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		
		Board board = new Board();//dao
		
		Mb mb =new Mb();//do
		B b =new B();//do
		
		//mb_nick; �г���
		mb.setMb_nick(req.getParameter("mb_nick"));
		//mb_no fk.ȸ����ȣ
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//b_no; �Խñ۹�ȣ
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//bc_no; ī�װ���ȣ -> ���ڷδ� int����, �������� ���ڿ��� �����ߵ�.  �信�� ������ ��ȣ�� �޾ƾ���.(num)
		b.setBc_no(Integer.parseInt(req.getParameter("bc_no")));
		//b_title; ����
		b.setB_title(req.getParameter("b_title"));
		//b_write; ����
		b.setB_write(req.getParameter("b_write"));
		//b_file ÷������
		b.setB_file(req.getParameter("b_file"));
		//b_date; �������
		b.setB_date(req.getParameter("b_date"));
		
	


		//��ü �Խñ� ��� ���

		
		

		forward.setRedirect(false);
		forward.setPath("�Խñ��ۼ�.jsp");


		return forward;
	}

}
