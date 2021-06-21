package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//b_no �Խñ۹�ȣ
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		
		
		
		HttpSession session = req.getSession(false);
		
		// �Խñ� ���ƿ�
			
		
		if(!board.like(Integer.parseInt(req.getParameter("mb_no")),Integer.parseInt(req.getParameter("b_no")))) {//�Խñ� ���ƿ� ����
			try {
				throw new Exception("���ƿ� ����");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {// �Խñ� ���ƿ� ����
			Boolean like=board.like(Integer.parseInt(req.getParameter("mb_no")),Integer.parseInt(req.getParameter("b_no")));
			session.setAttribute("like", like);
		}
		
		
		

		forward.setRedirect(false);
		forward.setPath("���ƿ並 ����ϴ�.jsp");


		return forward;
	}

}
