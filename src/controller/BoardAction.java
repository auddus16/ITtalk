package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDO.B;

public class BoardAction implements Action{//게시판  화면(게시글 목록 화면)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();


		// 검색 게시글 목록 출력(제목+내용)
		//ArrayList<B> titleSearch(String search)
		
		// 검색 게시글 목록 출력(작성자)
		//ArrayList<B> nickSearch(String nick)
		
		// 카테고리 게시글 목록 출력
		//ArrayList<B> bcSearch(String bc_no)
		
		// 게시글 목록 출력
		//ArrayList<B> search()
		

		
		forward.setRedirect(false);
		forward.setPath("업데이트.jsp");


		return forward;
	}

}
