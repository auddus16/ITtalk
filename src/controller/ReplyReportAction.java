package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.C;
import itTalkDO.Mb;
import itTalkDO.Rc;
import itTalkDO.Rctg;

public class ReplyReportAction implements Action{// ��۽Ű�

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		Board board = new Board(); //dao
		
		C c=new C(); //do
		Mb mb =new Mb(); //do
		Rctg rctg =new Rctg(); //do
		Rc rc= new Rc(); //do

		//c_no ��۹�ȣ
		//mb_no ȸ����ȣ
		//rctg_no �Ű�ī�װ���ȣ
		//rc_write �Ű���
		//c_report �Ű��
		//c_deleted ����ε�ó������

		
		//��� �Ű� boolean ReportC(int c_no , int mb_no , int rctg_no , String rc_write)(��� ��ȣ,ȸ����ȣ,�Ű�ī�װ���ȣ,�Ű���)
		//board.ReportC(Integer.parseInt(req.getParameter("c_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"));

		
		
		
		forward.setRedirect(false);
		forward.setPath("��۽Ű�.jsp");

		return forward;
	}

}
