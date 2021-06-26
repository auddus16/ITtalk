package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Board;

public class ReportAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		Board bDAO= new Board();
		HttpSession session= req.getSession();
		
		if(session.getAttribute("mb_no")==null) {
			out.println("<script>alert('로그인이 필요합니다.');window.close();</script>");
		}
		else {
			
			if(req.getParameter("b_no") != null) {
				
				if(bDAO.ReportB(Integer.parseInt(req.getParameter("b_no")), (Integer)session.getAttribute("mb_no"), 
						Integer.parseInt(req.getParameter("cate")), req.getParameter("r_write"))){
					out.println("<script>alert('신고가 완료되었습니다.');opener.parent.location.reload(); window.close();</script>");
				}
				else {
					out.println("<script>alert('신고를 실패했습니다. 다시 시도해주세요.');opener.parent.location.reload(); window.close();</script>");
				}
			}
		}
		return null;
	}

}
