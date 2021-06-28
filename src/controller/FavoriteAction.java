package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;

public class FavoriteAction implements Action {// 좋아요 

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Board bDAO =new Board(); //dao
				
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		HttpSession session= req.getSession();
		
		// 게시글 좋아요
		if(session.getAttribute("mb_no")== null) {
			
			out.println("<script>alert('로그인이 필요합니다.');location.href='cate.do';</script>");
		}
		else {
			
			if(!bDAO.like((Integer)session.getAttribute("mb_no"),Integer.parseInt(req.getParameter("b_no")))) {//게시글 좋아요 실패
			
				out.println("<script>alert('게시글 저장실패하였습니다. 다시 시도해주세요!');history.go(-1);</script>");
			}
			else {// 게시글 좋아요 성공
				
				out.println("<script>alert('게시글을 저장하였습니다.저장된 게시글은 마이페이지에서 확인가능합니다!');location.href='post.do?b_no="+req.getParameter("b_no")+"';</script>");
			}
			
		}
		
		return null;
	}

}
