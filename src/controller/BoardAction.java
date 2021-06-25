package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.AdminMenu;
import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Bc;
import itTalkDO.Mb;

public class BoardAction implements Action{//�Խ���  ȭ��(�Խñ� ��� ȭ��)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		ArrayList<Bc> cate =new ArrayList<>();// �Խ��� ī�װ� ���
		ArrayList<B> bcwrite = new ArrayList<>();// ī�װ� �Խñ� ��� ���
		
		ArrayList<B> write = new ArrayList<>();// �Խñ� ��� ���


		
		AdminMenu adminmenu = new AdminMenu(); //dao

		Board board = new Board(); //dao

		B b =new B(); //do
		Mb mb= new Mb(); //do
		Bc bc = new Bc(); //do

		
		
		//b_no �Խñ۹�ȣ
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//mb_no ȸ����ȣ
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//bc_no �Խ���ī�װ���ȣ
		bc.setBc_no(Integer.parseInt(req.getParameter("bc_no")));
		//b_title ����
		b.setB_title(req.getParameter("b_title"));
		//b_write ����
		b.setB_write(req.getParameter("b_write)"));
		//b_file ÷������
		b.setB_file(req.getParameter("b_file"));
		//b_date �������
		b.setB_date(req.getParameter("b_date"));
		//b_hits ��ȸ��
		b.setB_hits(Integer.parseInt(req.getParameter("b_hits")));
		//b_deleted ����ε�ó������
		b.setB_deleted(b.isB_deleted());



		
		//�Խ��� ī�װ� ���
		//ArrayList<Bc> getBoardCategory()
		cate=adminmenu.getBoardCategory();
		req.setAttribute("cate", cate);
		
		
		
		
		// ī�װ� �Խñ� ��� ���
		//ArrayList<B> bcSearch(int bc_no)
		bcwrite=board.bcSearch(Integer.parseInt(req.getParameter("bc_no")));

		//json���ڿ��� ��ȯ����
		ObjectMapper mapper= new ObjectMapper();

		String jsonStr= mapper.writeValueAsString(bcwrite);
		req.setAttribute("json", jsonStr);

		req.setAttribute("bcwrite", bcwrite);
		
		

		// �Խñ� ��� ���
		//ArrayList<B> search()
		write=board.search();

		//json���ڿ��� ��ȯ����
		ObjectMapper mapper2= new ObjectMapper();

		String jsonStr2= mapper2.writeValueAsString(write);
		req.setAttribute("json", jsonStr2);

		req.setAttribute("write", write);

		
		

		forward.setRedirect(false);
		forward.setPath("hmy_board.jsp");


		return forward;
	}

}
