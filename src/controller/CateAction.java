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
		if(req.getParameter("bc_no")==null) {//카테고리 정보 없을때 디폴트로 맨앞에꺼
			
			req.setAttribute("postList",bDAO.bcSearch(cateList.get(0).getBc_no()));
			ObjectMapper mapper= new ObjectMapper();
			
			String jsonStr= mapper.writeValueAsString(bDAO.bcSearch(cateList.get(0).getBc_no()));//댓글리스트 스크롤위함
			req.setAttribute("json", jsonStr);
		}
		else {
			
			for(Bc v: cateList) {
				if(Integer.parseInt(req.getParameter("bc_no"))== v.getBc_no()) {
					req.setAttribute("postList",bDAO.bcSearch(Integer.parseInt(req.getParameter("bc_no"))) );
					//json문자열로 변환과정
					ObjectMapper mapper= new ObjectMapper();
								
					String jsonStr= mapper.writeValueAsString(bDAO.bcSearch(Integer.parseInt(req.getParameter("bc_no"))));//댓글리스트 스크롤위함
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
