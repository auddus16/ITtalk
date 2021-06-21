package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.C;
import itTalkDO.Mb;

public class DelreplyAction implements Action{// ��� ����(��д�۵� ����)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		Board board = new Board();//dao

		C c=new C();//do
		B b =new B();//do
		Mb mb =new Mb();//do
		

		//c_no pk.��۹�ȣ
		c.setC_no(Integer.parseInt(req.getParameter("c_no")));
		//b_no fk.�Խñ۹�ȣ
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//mb_nick; �г���
		mb.setMb_nick(req.getParameter("mb_nick"));
		//mb_no fk.ȸ����ȣ
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//c_write ��۳���
		c.setC_write(req.getParameter("c_write"));
		//c_date �������
		c.setC_date(req.getParameter("c_date"));
		//c_secret ��д�ۿ���
		c.setC_secret(c.isC_secret());
		
		
		ServletContext application = req.getServletContext();
		
		// ��� ����
		
		if(!board.delC(Integer.parseInt(req.getParameter("c_no")))) {//��� ���� ����
			try {
				throw new Exception("��� ���� ����");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {//��� ���� ����
			Boolean delreply =board.delC(Integer.parseInt(req.getParameter("c_no")));
			application.setAttribute("delreply", delreply);
		}

		
		
		
		forward.setRedirect(false);
		forward.setPath("��ۻ���.jsp");


		return forward;
	}

}
