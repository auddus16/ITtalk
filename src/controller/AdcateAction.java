package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.AdminMenu;

public class AdcateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward= new ActionForward();
		
		AdminMenu adDAO = new AdminMenu();
		
		//adDAO.get
		
		req.setAttribute("kind", "modifycate");//� �������� include���� ����
		
		forward.setRedirect(false);
		forward.setPath("/hmy_adpage.jsp");
		
		return forward;
	}

}
