package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.AdminMenu;

public class AddelcateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		AdminMenu adDAO = new AdminMenu();
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(adDAO.deleteBc(Integer.parseInt(req.getParameter("bc_no")))) {
			out.println("<script>alert('삭제되었습니다.');location.href='adcate.ad';</script>");
		}
		else {
			
			out.println("<script>alert('다시 시도하세요. 삭제실패!');location.href='adcate.ad';</script>");
		}
		return null;
	}

}
