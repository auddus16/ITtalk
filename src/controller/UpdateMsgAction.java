package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Bc;
import itTalkDO.Mb;

public class UpdateMsgAction implements Action{// 게시글 수정(본인게시글 보여줌->수정여부 확인)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		Board board =new Board(); //dao
		
		B b = new B(); //do
		Mb mb =new Mb(); //do
		Bc bc =new Bc(); //do
		
		//b_no 게시글번호
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//mb_no 회원번호
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//bc_no 게시판카테고리번호
		bc.setBc_no(Integer.parseInt(req.getParameter("bc_no)")));
		//b_title 제목
		b.setB_title(req.getParameter("b_title"));
		//b_write 내용
		b.setB_write(req.getParameter("b_write"));
		//b_file 첨부파일
		b.setB_file(req.getParameter("b_file"));
		//b_date 등록일자
		b.setB_date(req.getParameter("b_date"));
		
		
		
		
		
		// 게시글 불러오기
		b=board.Load(Integer.parseInt(req.getParameter("b_no")));
		req.setAttribute("b", b);//게시글 불러오기 기능
		

		

		forward.setRedirect(false);
		forward.setPath("hmy_board.jsp");


		return forward;
	}
	
}
