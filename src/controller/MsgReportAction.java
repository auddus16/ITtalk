package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
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
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		// mb_no ȸ����ȣ
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		// rctg_no �Ű�ī�װ���ȣ
		rctg.setRctg_no(Integer.parseInt(req.getParameter("rctg_no")));
		// rc_write �Ű���
		rc.setRc_write(req.getParameter("rc_write"));
		// b_report �Ű��
		b.setB_report(Integer.parseInt(req.getParameter("b_report")));
		// b_deleted ����ε�ó������
		b.setB_deleted(b.isB_deleted());



		ServletContext application = req.getServletContext();
		PrintWriter out =res.getWriter();

		// �Խñ� �Ű� boolean ReportB(int b_no , int mb_no , int rctg_no , String rc_write)(�Խñ۹�ȣ,ȸ����ȣ,�Ű�ī�װ���ȣ,�Ű���)
		//board.ReportB(Integer.parseInt(req.getParameter("b_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"));



		if(!board.ReportB(Integer.parseInt(req.getParameter("b_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"))) {//�Խñ� �Ű� ����
			//�Խñ� �Ű� ����
			out.println("<script>alert('�Խñ� �Ű� ����');history.go(-1);</script>");
		}
		else {//�Խñ� �Ű� ����
			Boolean reportb =board.ReportB(Integer.parseInt(req.getParameter("b_no")), Integer.parseInt(req.getParameter("mb_no")), Integer.parseInt(req.getParameter("rctg_no")), req.getParameter("rc_write"));
			out.println("<script>alert('�Խñ� �Ű� ����');</script>");
			application.setAttribute("reportb", reportb);
		}





		forward.setRedirect(false);
		forward.setPath("�Խñ۽Ű�.jsp");

		return forward;
	}

}
