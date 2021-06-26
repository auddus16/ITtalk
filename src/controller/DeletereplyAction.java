package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;

public class DeletereplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		Board bDAO= new Board();
		
		if(bDAO.delC(Integer.parseInt(req.getParameter("c_no")))) {
			out.println("<script>alert('삭제되었습니다.');location.href='post.do?b_no="+req.getParameter("b_no")+"';</script>");
		}
		else {
			out.println("<script>alert('삭제실패했습니다.');location.href='post.do?b_no="+req.getParameter("b_no")+"';</script>");
			
		}
		return null;
	}

}
