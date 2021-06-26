package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.AdminMenu;

public class RemoveBlind1Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		AdminMenu adDAO= new AdminMenu();
		
		if(adDAO.updateB_deleted(Integer.parseInt(req.getParameter("b_no")))){
			if(adDAO.deleteRb2(Integer.parseInt(req.getParameter("b_no")))){
				
				out.println("<script>alert('블라인드 해제되었습니다.');location.href='adpost.ad';</script>");
			}
		}
		else {
			out.println("<script>alert('블라인드 해제 실패하였습니다. 다시 시도하세요.');location.href='adpost.ad';</script>");
			
		}
		return null;
	}

}
