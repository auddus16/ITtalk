package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;

public class SearchAction implements Action{//검색할 때 쓰임

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();


		ArrayList<B> titlewrite = new ArrayList<>();// 검색 게시글 목록 출력(제목+내용)	
		ArrayList<B> nickwrite = new ArrayList<>();// 검색 게시글 목록 출력(작성자)

		
		Board board =new Board(); //dao

		Mb mb = new Mb(); //do
		B b = new B(); //do


		//mb_no 회원번호
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//mb_nick 닉네임
		mb.setMb_nick(req.getParameter("mb_nick"));
		//b_title 제목
		b.setB_title(req.getParameter("b_title"));
		//b_write 내용
		b.setB_write(req.getParameter("b_write"));
		//b_no 게시글번호
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));




		//ArrayList<B> titleSearch(String search) 검색 게시글 목록 출력(제목+내용)
		titlewrite=board.titleSearch(req.getParameter("search"));


		//json문자열로 변환과정
		ObjectMapper mapper= new ObjectMapper();

		String jsonStr= mapper.writeValueAsString(titlewrite);
		req.setAttribute("json", jsonStr);

		req.setAttribute("titlewrite", titlewrite);


		
		
		//ArrayList<B> nickSearch(String nick) 검색 게시글 목록 출력(작성자)
		nickwrite=board.nickSearch(req.getParameter("nick"));
		
		
		//json문자열로 변환과정
		ObjectMapper mapper2= new ObjectMapper();

		String jsonStr2= mapper.writeValueAsString(nickwrite);
		req.setAttribute("json", jsonStr2);

		req.setAttribute("nickwrite", nickwrite);

		
		
		forward.setRedirect(false);
		forward.setPath("hmy_board.jsp");


		return forward;
	}

}
