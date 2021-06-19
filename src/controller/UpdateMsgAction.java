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
		//mb_no 회원번호
		//bc_no 게시판카테고리번호
		//b_title 제목
		//b_write 내용
		//b_file 첨부파일
		//b_date 등록일자
		
		
		
		
		
		
		
		// 게시글 불러오기
		b=board.Load(Integer.parseInt(req.getParameter("b_no")));
		req.setAttribute("load", b);//게시글 불러오기 기능
		
		
		

		forward.setRedirect(false);
		forward.setPath("업데이트.jsp");


		return forward;
	}
	
}
