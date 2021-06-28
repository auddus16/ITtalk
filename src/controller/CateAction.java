package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.AdminMenu;
import itTalkDAO.Board;
import itTalkDO.Bc;

public class CateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		AdminMenu adDAO= new AdminMenu();
		Board bDAO = new Board();
		
		ArrayList<Bc> cateList= adDAO.getBoardCategory();
		req.setAttribute("cateList", cateList);
		if(req.getParameter("bc_no")==null) {//ī�װ� ���� ������ ����Ʈ�� �Ǿտ���
			
			req.setAttribute("postList",bDAO.bcSearch(cateList.get(0).getBc_no()));
			ObjectMapper mapper= new ObjectMapper();
			
			String jsonStr= mapper.writeValueAsString(bDAO.bcSearch(cateList.get(0).getBc_no()));//��۸���Ʈ ��ũ������
			req.setAttribute("json", jsonStr);
		}
		else {
			
			for(Bc v: cateList) {
				if(Integer.parseInt(req.getParameter("bc_no"))== v.getBc_no()) {
					req.setAttribute("postList",bDAO.bcSearch(Integer.parseInt(req.getParameter("bc_no"))) );
					//json���ڿ��� ��ȯ����
					ObjectMapper mapper= new ObjectMapper();
								
					String jsonStr= mapper.writeValueAsString(bDAO.bcSearch(Integer.parseInt(req.getParameter("bc_no"))));//��۸���Ʈ ��ũ������
					req.setAttribute("json", jsonStr);
					break;
				}
			}
		}
		
		
		forward.setRedirect(false);
		forward.setPath("hmy_boardlist.jsp");


		return forward;
	}
	
}
