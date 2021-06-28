package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;

public class MymodifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward= new ActionForward();
		
		MyPageDAO mypageDAO= new MyPageDAO();//마이페이지 사용시 필요한 정보를 가져오기
		
		HttpSession session= req.getSession();
		
		Mb mb= new Mb();
		
		mb.setMb_no((Integer)session.getAttribute("mb_no"));
		mb.setMb_nick(req.getParameter("nick"));
		System.out.println("job:"+req.getParameter("job"));
		boolean b= (Integer.parseInt(req.getParameter("job")) != 0);
		mb.setMb_job(b);
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(mypageDAO.updateMember(mb)) {
			System.out.println("업데이트 성공");
			session.setAttribute("mb_job", b);
			session.setAttribute("mb_nick", req.getParameter("nick"));
			out.println("<script>alert('수정완료되었습니다.');location.href='info.mem';</script>");
		}
		else {
			out.println("<script>alert('수정을 실패했습니다.');history.go(-1);</script>");
		}
		
		//req.setAttribute("kind", "info");//마이페이지에서 어떤 페이지를 include할지 정보
		//forward.setRedirect(false);
		//forward.setPath("info.mem");
		
		//return forward;
		return null;
	}

}

//updateMember(Mb mb)