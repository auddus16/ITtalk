package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Bc;
import itTalkDO.BoardSet;
import itTalkDO.C;
import itTalkDO.Mb;

public class WriteCheckAction implements Action{// 게시글 번호를 클릭했을 때 나오는 게시글 화면

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		ArrayList<BoardSet> write =new ArrayList<>();//게시글 출력

		Board board = new Board();//dao

		Mb mb =new Mb(); //do
		Bc bc =new Bc(); //do
		B b = new B(); //do
		C c= new C(); //do



		//b_no 게시글번호
		//mb_no 회원번호
		//bc_no 게시판카테고리번호
		//b_title 제목
		//b_write 내용
		//b_file 첨부파일
		//b_date 등록일자
		//b_hits 조회수
		//b_deleted 블라인드처리여부(신고한 게시글을 블라인드 처리한경우 해당게시글을 볼때 필요함)
		//c_no 댓글번호
		//c_secret 비밀댓글여부



		//해당 게시글 출력
		//ArrayList<BoardSet> BoardPrint(int b_no);
		write=board.BoardPrint(Integer.parseInt(req.getParameter("b_no")));
		req.setAttribute("write", write);
		
		
		//view에 해당 게시글 번호 정보를 넘겨야함.
		
		forward.setRedirect(false);
		forward.setPath("글번호 클릭했을때 보는 게시글.jsp");


		return forward;
	}

}
