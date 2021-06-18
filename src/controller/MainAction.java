package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.MainDAO;
import itTalkDO.Ts;


public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward=new ActionForward();
		
		MainDAO maindao = new MainDAO();
		ArrayList<String> hits=maindao.getHits();
		req.setAttribute("hits", hits);
		
		ArrayList<Ts> topMain = maindao.top();
		req.setAttribute("topMain", topMain);
		
		
		
		
		forward.setRedirect(false);
		forward.setPath("hmy_main.jsp");
		
		return forward;
	}

}
