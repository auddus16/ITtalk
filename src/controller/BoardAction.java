package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;

public class BoardAction implements Action{//게시판  화면(게시글 목록 화면)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		Board board = new Board(); //dao
		
		B b =new B(); //do
		Mb mb= new Mb(); //do
			
		//b_no 게시글번호
		//mb_no 회원번호
		//bc_no 게시판카테고리번호
		//b_title 제목
		//b_write 내용
		//b_file 첨부파일
		//b_date 등록일자
		//b_hits 조회수
		//b_deleted 블라인드처리여부
		
		
		// 검색 게시글 목록 출력(제목+내용)
		//ArrayList<B> titleSearch(String search)
		
		
		// 검색 게시글 목록 출력(작성자)
		
		//ArrayList<B> nickSearch(String nick)
		
		
		// 카테고리 게시글 목록 출력
		
		//ArrayList<B> bcSearch(String bc_no)
		
		
		// 게시글 목록 출력
		
		//ArrayList<B> search()
		

		
		forward.setRedirect(false);
		forward.setPath("게시판.jsp");


		return forward;
	}

}
