package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.AdminMenu;

public class RemoveBlind2Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		AdminMenu adDAO= new AdminMenu();
		
		if(adDAO.updateC_deleted(Integer.parseInt(req.getParameter("c_no")))){
			adDAO.deleteRc2(Integer.parseInt(req.getParameter("c_no")));
			out.println("<script>alert('블라인드 해제되었습니다.');location.href='adreply.ad';</script>");
		}
		else {
			out.println("<script>alert('블라인드 해제 실패하였습니다. 다시 시도하세요.');location.href='adreply.ad';</script>");
			
		}
		return null;
	}

}
