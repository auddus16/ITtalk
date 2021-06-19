package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Bc;
import itTalkDO.Mb;

public class UpdateMsgAction implements Action{// �Խñ� ����(���ΰԽñ� ������->�������� Ȯ��)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		Board board =new Board(); //dao
		
		B b = new B(); //do
		Mb mb =new Mb(); //do
		Bc bc =new Bc(); //do
		
		//b_no �Խñ۹�ȣ
		//mb_no ȸ����ȣ
		//bc_no �Խ���ī�װ���ȣ
		//b_title ����
		//b_write ����
		//b_file ÷������
		//b_date �������
		
		
		
		
		
		
		
		// �Խñ� �ҷ�����
		b=board.Load(Integer.parseInt(req.getParameter("b_no")));
		req.setAttribute("load", b);//�Խñ� �ҷ����� ���
		
		
		

		forward.setRedirect(false);
		forward.setPath("������Ʈ.jsp");


		return forward;
	}
	
}
