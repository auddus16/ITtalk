package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.AdminMenu;
import itTalkDO.Bc;

public class AdcateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward= new ActionForward();
		
		AdminMenu adDAO = new AdminMenu();
		
		ArrayList<Bc> adcateList= adDAO.getBoardCategory();
		
		req.setAttribute("adcateList", adcateList);
		req.setAttribute("kind", "modifycate");//어떤 페이지를 include할지 정보
		
		forward.setRedirect(false);
		forward.setPath("/hmy_adpage.jsp");
		
		return forward;
	}

}
