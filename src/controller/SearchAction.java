package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;

public class SearchAction implements Action{//�˻��� �� ����

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();


		ArrayList<B> titlewrite = new ArrayList<>();// �˻� �Խñ� ��� ���(����+����)	
		ArrayList<B> nickwrite = new ArrayList<>();// �˻� �Խñ� ��� ���(�ۼ���)

		
		Board board =new Board(); //dao

		Mb mb = new Mb(); //do
		B b = new B(); //do


		//mb_no ȸ����ȣ
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//mb_nick �г���
		mb.setMb_nick(req.getParameter("mb_nick"));
		//b_title ����
		b.setB_title(req.getParameter("b_title"));
		//b_write ����
		b.setB_write(req.getParameter("b_write"));
		//b_no �Խñ۹�ȣ
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));




		//ArrayList<B> titleSearch(String search) �˻� �Խñ� ��� ���(����+����)
		titlewrite=board.titleSearch(req.getParameter("search"));


		//json���ڿ��� ��ȯ����
		ObjectMapper mapper= new ObjectMapper();

		String jsonStr= mapper.writeValueAsString(titlewrite);
		req.setAttribute("json", jsonStr);

		req.setAttribute("titlewrite", titlewrite);


		
		
		//ArrayList<B> nickSearch(String nick) �˻� �Խñ� ��� ���(�ۼ���)
		nickwrite=board.nickSearch(req.getParameter("nick"));
		
		
		//json���ڿ��� ��ȯ����
		ObjectMapper mapper2= new ObjectMapper();

		String jsonStr2= mapper.writeValueAsString(nickwrite);
		req.setAttribute("json", jsonStr2);

		req.setAttribute("nickwrite", nickwrite);

		
		
		forward.setRedirect(false);
		forward.setPath("hmy_board.jsp");


		return forward;
	}

}
