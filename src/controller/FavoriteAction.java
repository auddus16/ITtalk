package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;

public class FavoriteAction implements Action {// ���ƿ� 

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		Board board =new Board(); //dao
		
		Mb mb = new Mb(); //do
		B b = new B(); //do
		
		
		//mb_no ȸ����ȣ
		
		//b_no �Խñ۹�ȣ
		
		
		
		
		
		// �Խñ� ���ƿ�
		//board.like(Integer.parseInt(req.getParameter("mb_no")),Integer.parseInt(req.getParameter("b_no")));
		
		

		forward.setRedirect(false);
		forward.setPath("���ƿ並 ����ϴ�.jsp");


		return forward;
	}

}
