package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;

public class BoardAction implements Action{//�Խ���  ȭ��(�Խñ� ��� ȭ��)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		Board board = new Board(); //dao
		
		B b =new B(); //do
		Mb mb= new Mb(); //do
			
		//b_no �Խñ۹�ȣ
		//mb_no ȸ����ȣ
		//bc_no �Խ���ī�װ���ȣ
		//b_title ����
		//b_write ����
		//b_file ÷������
		//b_date �������
		//b_hits ��ȸ��
		//b_deleted ����ε�ó������
		
		
		// �˻� �Խñ� ��� ���(����+����)
		//ArrayList<B> titleSearch(String search)
		
		
		// �˻� �Խñ� ��� ���(�ۼ���)
		
		//ArrayList<B> nickSearch(String nick)
		
		
		// ī�װ� �Խñ� ��� ���
		
		//ArrayList<B> bcSearch(String bc_no)
		
		
		// �Խñ� ��� ���
		
		//ArrayList<B> search()
		

		
		forward.setRedirect(false);
		forward.setPath("�Խ���.jsp");


		return forward;
	}

}
