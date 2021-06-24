package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.MainDAO;
import itTalkDO.B;
import itTalkDO.Ts;


public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward=new ActionForward();
		ArrayList<B> Hits = new ArrayList<>();
		MainDAO maindao = new MainDAO();
		
		Hits=maindao.getHits();
		req.setAttribute("Hits", Hits);
		
		ArrayList<Ts> topMain = maindao.top();
		req.setAttribute("topMain", topMain);
		
		forward.setRedirect(false);
		forward.setPath("hmy_main.jsp");
		
		return forward;
	}

}
