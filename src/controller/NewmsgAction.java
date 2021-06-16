package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;

public class NewmsgAction implements Action{// 게시글 작성

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		
		Board board = new Board();//dao
		
		Mb mb =new Mb();//do
		B b =new B();//do
		
		//mb_nick; 닉네임
		mb.setMb_nick(req.getParameter("mb_nick"));
		//mb_no fk.회원번호
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//b_no; 게시글번호
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//bc_no; 카테고리번호 -> 인자로는 int지만, 보낼때는 문자열로 보내야됨.  뷰에서 받을때 번호로 받아야함.(num)
		b.setBc_no(Integer.parseInt(req.getParameter("bc_no")));
		//b_title; 제목
		b.setB_title(req.getParameter("b_title"));
		//b_write; 내용
		b.setB_write(req.getParameter("b_write"));
		//b_file 첨부파일
		b.setB_file(req.getParameter("b_file"));
		//b_date; 등록일자
		b.setB_date(req.getParameter("b_date"));
		
	


		//전체 게시글 목록 출력

		
		

		forward.setRedirect(false);
		forward.setPath("게시글작성.jsp");


		return forward;
	}

}
