package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.AdminMenu;
import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Bc;
import itTalkDO.Mb;

public class BoardAction implements Action{//게시판  화면(게시글 목록 화면)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		ArrayList<Bc> cate =new ArrayList<>();// 게시판 카테고리 출력
		ArrayList<B> bcwrite = new ArrayList<>();// 카테고리 게시글 목록 출력
		
		ArrayList<B> write = new ArrayList<>();// 게시글 목록 출력


		
		AdminMenu adminmenu = new AdminMenu(); //dao

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



		
		//게시판 카테고리 출력
		//ArrayList<Bc> getBoardCategory()
		cate=adminmenu.getBoardCategory();
		req.setAttribute("cate", cate);
		
		
		
		
		// 카테고리 게시글 목록 출력
		//ArrayList<B> bcSearch(int bc_no)
		bcwrite=board.bcSearch(Integer.parseInt(req.getParameter("bc_no")));

		//json문자열로 변환과정
		ObjectMapper mapper= new ObjectMapper();

		String jsonStr= mapper.writeValueAsString(bcwrite);
		req.setAttribute("json", jsonStr);

		req.setAttribute("bcwrite", bcwrite);
		
		

		// 게시글 목록 출력
		//ArrayList<B> search()
		write=board.search();

		//json문자열로 변환과정
		ObjectMapper mapper2= new ObjectMapper();

		String jsonStr2= mapper2.writeValueAsString(write);
		req.setAttribute("json", jsonStr2);

		req.setAttribute("write", write);

		
		

		forward.setRedirect(false);
		forward.setPath("hmy_board.jsp");


		return forward;
	}

}
