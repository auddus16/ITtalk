package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Board;

public class Report2Action implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		Board bDAO= new Board();
		HttpSession session= req.getSession();
		System.out.println(req.getParameter("b_no"));
		System.out.println(req.getParameter("c_no"));
		if(req.getParameter("b_no") == null) {
			//��۽Ű�
			if(bDAO.ReportC(Integer.parseInt(req.getParameter("c_no")), (Integer)session.getAttribute("mb_no"), 
					Integer.parseInt(req.getParameter("cate")), req.getParameter("r_write"))){
				out.println("<script>alert('�Ű� �Ϸ�Ǿ����ϴ�.');window.close();</script>");
			}
			else {
				out.println("<script>alert('�Ű� �����߽��ϴ�. �ٽ� �õ����ּ���.');window.close();</script>");
			}
		}
		else if(req.getParameter("c_no")==null) {
			//�Խñ۽Ű�
			if(bDAO.ReportB(Integer.parseInt(req.getParameter("b_no")), (Integer)session.getAttribute("mb_no"), 
					Integer.parseInt(req.getParameter("cate")), req.getParameter("r_write"))){
				out.println("<script>alert('�Ű� �Ϸ�Ǿ����ϴ�.');window.close();</script>");
			}
			else {
				out.println("<script>alert('�Ű� �����߽��ϴ�. �ٽ� �õ����ּ���.');window.close();</script>");
			}
		}
		
		return null;
	}
}
