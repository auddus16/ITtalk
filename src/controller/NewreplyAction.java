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

public class NewreplyAction implements Action{//댓글 등록(비밀 댓글도 포함)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//(b_no,mb_no,c_write)
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		Board bDAO= new Board();
		HttpSession session= req.getSession();
		
		if(session.getAttribute("mb_no") == null) {
			out.println("<script>alert('로그인이 필요합니다.');location.href='/ITtalk/hmy_login.jsp';</script>");
		}
		
		else {
			C c= new C();
			c.setB_no(Integer.parseInt(req.getParameter("b_no")));
			c.setMb_no((Integer)session.getAttribute("mb_no"));
			c.setC_write(req.getParameter("c_write"));
			if(req.getParameter("secret") != null) {//비밀댓글여부
				
				c.setC_secret(true);
			}
			else {
				c.setC_secret(false);
			}
			
			if(bDAO.newReply(c)) {
				String s="post.do?b_no="+req.getParameter("b_no");
				out.println("<script>alert('댓글 등록되었습니다.');location.href='"+s+"';</script>");
			}
		}
		
		return null;
	}

}
