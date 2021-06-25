package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.AdminMenu;
import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Bc;
import itTalkDO.Mb;

public class UpdateMsgAction implements Action{// �Խñ� ����(���ΰԽñ� ������->�������� Ȯ��)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		
		ArrayList<Bc> cate =new ArrayList<>();//�Խ��� ī�װ� ���
		
		HttpSession session=req.getSession();
		req.setAttribute("mb_no", session.getAttribute("mb_no"));
		
		AdminMenu adminmenu = new AdminMenu(); //dao
		Board board =new Board(); //dao

		B b = new B(); //do
		Mb mb =new Mb(); //do

		req.setAttribute("b_no", Integer.parseInt(req.getParameter("b_no")));
		
		if(!req.getParameter("b_no").equals("0")) {
			b = board.Load(Integer.parseInt(req.getParameter("b_no")));
			// �Խñ� �ҷ�����
			req.setAttribute("b", b);//�Խñ� �ҷ����� ���
		}
				
		
//		//b_no �Խñ۹�ȣ
//		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
//		//mb_no ȸ����ȣ
//		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
//		//bc_no �Խ���ī�װ���ȣ
//		bc.setBc_no(Integer.parseInt(req.getParameter("bc_no)")));
//		//b_title ����
//		b.setB_title(req.getParameter("b_title"));
//		//b_write ����
//		b.setB_write(req.getParameter("b_write"));
//		//b_file ÷������
//		b.setB_file(req.getParameter("b_file"));
//		//b_date �������
//		b.setB_date(req.getParameter("b_date"));


		//json���ڿ��� ��ȯ����
//		ObjectMapper mapper2= new ObjectMapper();
//
//		String jsonStr2= mapper2.writeValueAsString(cate);
//		req.setAttribute("json", jsonStr2);

		
		// �Խ��� ī�װ� ��� 
		// ArrayList<Bc> getBoardCategory()
		cate=adminmenu.getBoardCategory();
		req.setAttribute("cate", cate);

		
		forward.setRedirect(false);
		forward.setPath("hmy_writemodify.jsp");


		return forward;
	}

}
