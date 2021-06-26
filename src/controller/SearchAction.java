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
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		ActionForward forward = new ActionForward();
		Board board =new Board(); //dao
		ArrayList<B> searchB = new ArrayList<>();// �˻��� �Խñ�
		
		
		String pets=req.getParameter("pets"); // �˻��ɼ�
		System.out.println("�˻��ɼ� :" +pets);
		String searchinfo =req.getParameter("searchinfo");
		System.out.println("�˻����� : "+searchinfo);
		//ArrayList<B> titleSearch(String search) �˻� �Խñ� ��� ���(����+����)
		if(pets.equals("1")) { // ����+���� 
			searchB=board.titleSearch(searchinfo);
			req.setAttribute("searchB", searchB);
			
			ObjectMapper mapper= new ObjectMapper();
			String jsonStr= mapper.writeValueAsString(searchB);
			req.setAttribute("json", jsonStr);
		}
		else { // �ۼ��ڸ�
			Mb mb=board.nickSearchmb(req.getParameter("searchinfo"));
			System.out.println("mb_no : "+mb.getMb_no());
			searchB=board.nickSearch(mb.getMb_no());
			req.setAttribute("searchB", searchB);
			
			ObjectMapper mapper= new ObjectMapper();
			String jsonStr= mapper.writeValueAsString(searchB);
			req.setAttribute("json", jsonStr);
		}
		
		forward.setRedirect(false);
		forward.setPath("hmy_boardsearch.jsp");


		return forward;
	}

}
