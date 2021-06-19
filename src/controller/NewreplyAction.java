package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.C;
import itTalkDO.Mb;

public class NewreplyAction implements Action{//��� ���(��� ��۵� ����)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		Board board = new Board();//dao
		
		C c=new C();//do
		Mb mb =new Mb();//do
		B b =new B();//do
		
		//c_no pk.��۹�ȣ
		c.setC_no(Integer.parseInt(req.getParameter("c_no")));
		//b_no fk.�Խñ۹�ȣ
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//mb_nick; �г���
		mb.setMb_nick(req.getParameter("mb_nick"));
		//mb_no fk.ȸ����ȣ
		c.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//c_write ��۳���
		c.setC_write(req.getParameter("c_write"));
		//c_date �������
		c.setC_date(req.getParameter("c_date"));
		//c_secret ��д�ۿ���
		c.setC_secret(c.isC_secret());
		
		
		
//		String cnt=req.getParameter("cnt");
//		 ����� ����� �����ִ����� ���� ������
		
//		int rcnt;
//		if(cnt==null){//����� ���ٸ�
//			rcnt=0;
//		}
//		else{//����� �ִٸ� ��� �� ��ŭ ���
//			rcnt=Integer.parseInt(cnt);
//		}
//		req.setAttribute("rcnt", rcnt);
		
	
		//��� ��� b_no,mb_no,c_write
		if(!board.newReply(c)) {//��� ���(��� ��� ����) ����
			try {
				throw new Exception("��� ��� ����");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {//��� ���(��� ��� ����) ����	
			Boolean comment=board.newReply(c);
			req.setAttribute("comment", comment);//����� ��� ����
		}
		

		
		//req.setAttribute("datas", ���s); ���� ������ ����
		
	


		forward.setRedirect(false);
		forward.setPath("����ۼ�.jsp");

		return forward;
	}

}
