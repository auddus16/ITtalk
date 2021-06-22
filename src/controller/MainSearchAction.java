package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDAO.MainDAO;
import itTalkDO.B;

public class MainSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		ArrayList<B> titlewrite = new ArrayList<>();
		ArrayList<B> nickwrite = new ArrayList<>();
		Board board = new Board();
		B b=new B();
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		String keyword = req.getParameter("keyword");
		String pets = req.getParameter("pets");
		
		
		
		if(pets.equals("1")) {
			titlewrite=board.titleSearch(keyword);
			req.setAttribute("titlewirte", titlewrite);
		}
		else {
			nickwrite=board.nickSearch(keyword);
			req.setAttribute("nickwrite", nickwrite);
		}
		
		
		forward.setRedirect(false);
		forward.setPath("hmy_boardsearch.jsp");
		return forward;
	}

}
