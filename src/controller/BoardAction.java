package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Bc;
import itTalkDO.Mb;

public class BoardAction implements Action{//게시판  화면(게시글 목록 화면)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		ArrayList<B> titlewrite = new ArrayList<>();// 검색 게시글 목록 출력(제목+내용)	
		ArrayList<B> nickwrite = new ArrayList<>();// 검색 게시글 목록 출력(작성자)
		ArrayList<B> bcwrite = new ArrayList<>();// 카테고리 게시글 목록 출력
		ArrayList<B> write = new ArrayList<>();// 게시글 목록 출력

		Board board = new Board(); //dao
		
		B b =new B(); //do
		Mb mb= new Mb(); //do
		Bc bc = new Bc(); //do
			
		//b_no 게시글번호
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//mb_no 회원번호
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//bc_no 게시판카테고리번호
		bc.setBc_no(Integer.parseInt(req.getParameter("bc_no")));
		//b_title 제목
		b.setB_title(req.getParameter("b_title"));
		//b_write 내용
		b.setB_write(req.getParameter("b_write)"));
		//b_file 첨부파일
		b.setB_file(req.getParameter("b_file"));
		//b_date 등록일자
		b.setB_date(req.getParameter("b_date"));
		//b_hits 조회수
		b.setB_hits(Integer.parseInt(req.getParameter("b_hits")));
		//b_deleted 블라인드처리여부
		b.setB_deleted(b.isB_deleted());
		
		
		
		// 검색 게시글 목록 출력(제목+내용)
		//ArrayList<B> titleSearch(String search)
		titlewrite=board.titleSearch(req.getParameter("search"));
		req.setAttribute("titlewrite", titlewrite);
		
		// 검색 게시글 목록 출력(작성자)
		//ArrayList<B> nickSearch(String nick)
		nickwrite=board.nickSearch(req.getParameter("nick"));
		req.setAttribute("nickwrite", nickwrite);
		
		
		// 카테고리 게시글 목록 출력
		//ArrayList<B> bcSearch(String bc_no)
		bcwrite=board.bcSearch(req.getParameter("bc_no"));
		req.setAttribute("bcwrite", bcwrite);
		
		
		// 게시글 목록 출력
		//ArrayList<B> search()
		write=board.search();
		req.setAttribute("write", write);
		
		forward.setRedirect(false);
		forward.setPath("hmy_board.jsp");


		return forward;
	}

}
