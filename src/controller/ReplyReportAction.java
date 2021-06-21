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
		c.setC_no(Integer.parseInt(req.getParameter("c_no")));
		//mb_no ȸ����ȣ
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//rctg_no �Ű�ī�װ���ȣ
		rctg.setRctg_no(Integer.parseInt(req.getParameter("rctg_no")));
		//rc_write �Ű���
		rc.setRc_write(req.getParameter("rc_write"));
		//c_report �Ű��
		c.setC_report(Integer.parseInt(req.getParameter("c_report")));
		//c_deleted ����ε�ó������
		c.setC_deleted(c.isC_deleted());
		
		
		
		//��� �Ű� boolean ReportC(int c_no , int mb_no , int rctg_no , String rc_write)(��� ��ȣ,ȸ����ȣ,�Ű�ī�װ���ȣ,�Ű���)
		//board.ReportC(Integer.parseInt(req.getParameter("c_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"));
		
		
		if(!board.ReportC(Integer.parseInt(req.getParameter("c_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"))) {//��� �Ű� ����
			try {//��� �Ű� ����
				throw new Exception("��� �Ű� ����");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {// ��� �Ű� ����
			Boolean reportc=board.ReportC(Integer.parseInt(req.getParameter("c_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"));
			req.setAttribute("reportc", reportc);
		}
		
		
		forward.setRedirect(false);
		forward.setPath("��۽Ű�.jsp");

		return forward;
	}

}
