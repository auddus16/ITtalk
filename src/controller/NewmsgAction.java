package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import itTalkDAO.Board;
import itTalkDAO.DBManager;
import itTalkDO.B;
import itTalkDO.Mb;

public class NewmsgAction implements Action{// �Խñ� ���

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		Board board = new Board();//dao
		
		Mb mb =new Mb();//do
		B b =new B();//do
		
		//--����� �� �ʿ��� ����--
		
//		//mb_nick; �г���
//		mb.setMb_nick(req.getParameter("mb_nick"));
//		//mb_no fk.ȸ����ȣ
//		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
//		
//		//b_no; �Խñ۹�ȣ
//		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
//		//bc_no; ī�װ���ȣ -> ���ڷδ� int����, �������� ���ڿ��� �����ߵ�.  �信�� ������ ��ȣ�� �޾ƾ���.(num)
//		b.setBc_no(Integer.parseInt(req.getParameter("bc_no")));
//		//b_title; ����
//		b.setB_title(req.getParameter("b_title"));
//		//b_write; ����
//		b.setB_write(req.getParameter("b_write"));
//		//b_file ÷������
//		b.setB_file(req.getParameter("b_file"));
//		//b_date; �������
//		b.setB_date(req.getParameter("b_date"));
		
//		String cnt=req.getParameter("cnt");
//		// �Խñ��� ����� �����ִ����� ���� ������
		
//		int mcnt;
//		if(cnt==null){//�Խñ��� ���ٸ�
//			mcnt=0;
//		}
//		else{//�Խñ��� �ִٸ� �Խñ� �� ��ŭ ���
//			mcnt=Integer.parseInt(cnt);
//		}
//		req.setAttribute("cnt", mcnt);//�Խñ� ��
		
		ServletContext application = req.getServletContext();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		
		String bc_no = null;
		bc_no=board.Upload(req, res);		
		
		//req.setAttribute("datas", datas); ���� ������ ����
		forward.setRedirect(false);
		forward.setPath("cate.do?bc_no=" + bc_no);


		return forward;
	}

}
