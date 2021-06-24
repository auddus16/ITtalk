package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;

public class DelmsgAction implements Action{//�Խñ� ����

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();


		Board board = new Board();//dao

		Mb mb =new Mb();//do
		B b =new B();//do


		//mb_nick; �г���
		mb.setMb_nick(req.getParameter("mb_nick"));
		//mb_no fk.ȸ����ȣ
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//b_no; �Խñ۹�ȣ
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//bc_no; ī�װ���ȣ -> ���ڷδ� int����, �������� ���ڿ��� �����ߵ�.  �信�� ������ ��ȣ�� �޾ƾ���.(num)
		b.setBc_no(Integer.parseInt(req.getParameter("bc_no")));
		//b_title; ����
		b.setB_title(req.getParameter("b_title"));
		//b_write; ����
		b.setB_write(req.getParameter("b_write"));
		//b_file ÷������
		b.setB_file(req.getParameter("b_file"));
		//b_date; �������
		b.setB_date(req.getParameter("b_date"));



		//�Խñ� �ҷ�����(�ش� �Խñ��� �����ϱ�����)
		//B Load(int b_no)

		b=board.Load(Integer.parseInt(req.getParameter("b_no")));

		//json���ڿ��� ��ȯ����
		ObjectMapper mapper= new ObjectMapper();

		String jsonStr= mapper.writeValueAsString(b);
		req.setAttribute("json", jsonStr);

		req.setAttribute("b", b);//�Խñ� �ҷ����� ���


		PrintWriter out=res.getWriter();

		//�Խñ� ����
		//boolean delB(HttpServletRequest req, HttpServletResponse res)

		ServletContext application = req.getServletContext();

		if(!board.delB(req, res)) {//�Խñ� ���� ����
			out.println("<script>alert('�Խñ� ���� ����');history.go(-1);</script>");
		}
		else {//�Խñ� ���� ����
			Boolean writedelete =board.delB(req, res);
			out.println("<script>alert('�Խñ� ���� ����');</script>");
			application.setAttribute("writedelete", writedelete);
		}





		// �̹��� ����
		//boolean delF(HttpServletRequest req, HttpServletResponse res)


		if(!board.delF(req, res)) {//�̹��� ���� ����
			out.println("<script>alert('�̹��� ���� ����');history.go(-1);</script>");
		}
		else {//�̹��� ���� ����
			Boolean imagedelete =board.delF(req, res);
			out.println("<script>alert('�̹��� ���� ����');</script>");
			application.setAttribute("imagedelete", imagedelete);
		}




		forward.setRedirect(false);
		forward.setPath("�Խñۻ���.jsp");


		return forward;
	}

}
