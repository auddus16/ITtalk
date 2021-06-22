package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;

public class Addelpost2Action implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Board bDAO = new Board();
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(bDAO.delB(req, res)) {
			//신고게시글테이블+게시글테이블에서 삭제
			out.println("<script>alert('삭제되었습니다.');location.href='adallpost.ad';</script>");
		}
		
		else {
			out.println("<script>alert('삭제실패! 다시 시도하세요');location.href='adallpost.ad';</script>");
		}
		
		return null;
	}

}
