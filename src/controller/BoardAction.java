package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDO.B;

public class BoardAction implements Action{//�Խ���  ȭ��(�Խñ� ��� ȭ��)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();


		// �˻� �Խñ� ��� ���(����+����)
		//ArrayList<B> titleSearch(String search)
		
		// �˻� �Խñ� ��� ���(�ۼ���)
		//ArrayList<B> nickSearch(String nick)
		
		// ī�װ� �Խñ� ��� ���
		//ArrayList<B> bcSearch(String bc_no)
		
		// �Խñ� ��� ���
		//ArrayList<B> search()
		

		
		forward.setRedirect(false);
		forward.setPath("������Ʈ.jsp");


		return forward;
	}

}
