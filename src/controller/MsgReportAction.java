package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;
import itTalkDO.Rc;
import itTalkDO.Rctg;

public class MsgReportAction implements Action{//�Խñ� �Ű�

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		Board board = new Board(); //dao
		
		B b = new B();//do
		Mb mb =new Mb();//do
		Rc rc = new Rc();//do
		Rctg rctg =new Rctg();//do
		
		// b_no �Խñ۹�ȣ
		// mb_no ȸ����ȣ
		// rctg_no �Ű�ī�װ���ȣ
		// rc_write �Ű���
		// b_report �Ű��
		// b_deleted ����ε�ó������
		
		
		// �Խñ� �Ű� boolean ReportB(int b_no , int mb_no , int rctg_no , String rc_write)(�Խñ۹�ȣ,ȸ����ȣ,�Ű�ī�װ���ȣ,�Ű���)
		//board.ReportB(Integer.parseInt(req.getParameter("b_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"));
		
		
		
		
		
		
		forward.setRedirect(false);
		forward.setPath("�Խñ۽Ű�.jsp");

		return forward;
	}

}
