package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.C;
import itTalkDO.Mb;

public class NewreplyAction implements Action{//��� ���(��� ��۵� ����)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//(b_no,mb_no,c_write)
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		Board bDAO= new Board();
		HttpSession session= req.getSession();
		
		if(session.getAttribute("mb_no") == null) {
			out.println("<script>alert('�α����� �ʿ��մϴ�.');location.href='/ITtalk/hmy_login.jsp';</script>");
		}
		
		else {
			C c= new C();
			c.setB_no(Integer.parseInt(req.getParameter("b_no")));
			c.setMb_no((Integer)session.getAttribute("mb_no"));
			c.setC_write(req.getParameter("c_write"));
			if(req.getParameter("secret") != null) {//��д�ۿ���
				
				c.setC_secret(true);
			}
			else {
				c.setC_secret(false);
			}
			
			if(bDAO.newReply(c)) {
				String s="post.do?b_no="+req.getParameter("b_no");
				out.println("<script>alert('��� ��ϵǾ����ϴ�.');location.href='"+s+"';</script>");
			}
		}
		
		return null;
	}

}
