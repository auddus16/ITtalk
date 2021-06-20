package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Bc;
import itTalkDO.BoardSet;
import itTalkDO.C;
import itTalkDO.Mb;

public class TitelCheckAction implements Action{//�Խñ� ������ Ŭ������ �� ������ �Խñ� ȭ��

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		ArrayList<BoardSet> write =new ArrayList<>();//�Խñ� ���
		
		Board board = new Board();//dao
		
		Mb mb =new Mb(); //do
		Bc bc =new Bc(); //do
		B b = new B(); //do
		C c= new C(); //do
		
		

		//b_no �Խñ۹�ȣ
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//mb_no ȸ����ȣ
		mb.setMb_no(Integer.parseInt("mb_no"));
		//bc_no �Խ���ī�װ���ȣ
		bc.setBc_no(Integer.parseInt(req.getParameter("bc_no")));
		//b_title ����
		b.setB_title(req.getParameter("b_title"));
		//b_write ����
		b.setB_write(req.getParameter("b_write"));
		//b_file ÷������
		b.setB_file(req.getParameter("b_file"));
		//b_date �������
		b.setB_date(req.getParameter("b_date"));
		//b_hits ��ȸ��
		b.setB_hits(Integer.parseInt(req.getParameter("b_hits")));
		//b_deleted ����ε�ó������(�Ű��� �Խñ��� ����ε� ó���Ѱ�� �ش�Խñ��� ���� �ʿ���)
		b.setB_deleted(b.isB_deleted());
		//c_no ��۹�ȣ
		c.setC_no(Integer.parseInt(req.getParameter("c_no")));
		//c_secret ��д�ۿ���
		c.setC_secret(c.isC_secret());
		
		
		
		//�ش� �Խñ� ���
		//ArrayList<BoardSet> BoardPrint(int b_no);
		write=board.BoardPrint(Integer.parseInt(req.getParameter("b_no")));
		req.setAttribute("write", write);
		

		//view�� ���� ������ �Ѱܾ���.
		
		forward.setRedirect(false);
		forward.setPath("����Ŭ�������� ���°Խñ�.jsp");


		return forward;
	}
	
}
