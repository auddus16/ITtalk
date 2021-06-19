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

public class WriteCheckAction implements Action{// �Խñ� ��ȣ�� Ŭ������ �� ������ �Խñ� ȭ��

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
		//mb_no ȸ����ȣ
		//bc_no �Խ���ī�װ���ȣ
		//b_title ����
		//b_write ����
		//b_file ÷������
		//b_date �������
		//b_hits ��ȸ��
		//b_deleted ����ε�ó������(�Ű��� �Խñ��� ����ε� ó���Ѱ�� �ش�Խñ��� ���� �ʿ���)
		//c_no ��۹�ȣ
		//c_secret ��д�ۿ���



		//�ش� �Խñ� ���
		//ArrayList<BoardSet> BoardPrint(int b_no);
		write=board.BoardPrint(Integer.parseInt(req.getParameter("b_no")));
		req.setAttribute("write", write);
		
		
		//view�� �ش� �Խñ� ��ȣ ������ �Ѱܾ���.
		
		forward.setRedirect(false);
		forward.setPath("�۹�ȣ Ŭ�������� ���� �Խñ�.jsp");


		return forward;
	}

}
