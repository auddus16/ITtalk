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

public class SearchAction implements Action{//검색할 때 쓰임

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		ActionForward forward = new ActionForward();


		ArrayList<B> searchB = new ArrayList<>();// 검색된 게시글
		
		Board board =new Board(); //dao
		String pets=req.getParameter("pets"); // 검색옵션
		System.out.println("검색옵션 :" +pets);
		String searchinfo =req.getParameter("searchinfo");
		System.out.println("검색내용 : "+searchinfo);
		//ArrayList<B> titleSearch(String search) 검색 게시글 목록 출력(제목+내용)
		if(pets.equals("1")) {
			searchB=board.titleSearch(searchinfo);
			req.setAttribute("searchB", searchB);
		}
		else {
			searchB=board.nickSearch(searchinfo);
			req.setAttribute("searchB", searchB);
		}
		
		forward.setRedirect(false);
		forward.setPath("hmy_boardsearch.jsp");


		return forward;
	}

}
