package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;

public class ModifypwAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MyPageDAO mypageDAO= new MyPageDAO();
		
		HttpSession session= req.getSession();
		
		String paramPw =req.getParameter("pw");
		
		Mb mb= new Mb();
		mb.setMb_no((Integer)session.getAttribute("mb_no"));
		mb.setMb_pw(paramPw);
		
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(paramPw.equals(req.getParameter("checkpw"))) {
			//비밀번호확인됨.
			if(mypageDAO.updateMemberPw(mb)) {
				
				out.println("<script>alert('비밀번호 변경했습니다.');window.close();</script>");
			}
			else {
				out.println("<script>alert('다시 시도하세요.');window.close();</script>");
			}
		}
		else {
			//비밀번호 확인 실패
			out.println("<script>alert('비밀번호를 확인해주세요.');history.go(-1);</script>");
		}
		return null;
	}

}
