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

public class TitelCheckAction implements Action{//게시글 제목을 클릭했을 때 나오는 게시글 화면

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
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//mb_no 회원번호
		mb.setMb_no(Integer.parseInt("mb_no"));
		//bc_no 게시판카테고리번호
		bc.setBc_no(Integer.parseInt(req.getParameter("bc_no")));
		//b_title 제목
		b.setB_title(req.getParameter("b_title"));
		//b_write 내용
		b.setB_write(req.getParameter("b_write"));
		//b_file 첨부파일
		b.setB_file(req.getParameter("b_file"));
		//b_date 등록일자
		b.setB_date(req.getParameter("b_date"));
		//b_hits 조회수
		b.setB_hits(Integer.parseInt(req.getParameter("b_hits")));
		//b_deleted 블라인드처리여부(신고한 게시글을 블라인드 처리한경우 해당게시글을 볼때 필요함)
		b.setB_deleted(b.isB_deleted());
		//c_no 댓글번호
		c.setC_no(Integer.parseInt(req.getParameter("c_no")));
		//c_secret 비밀댓글여부
		c.setC_secret(c.isC_secret());
		
		
		
		//해당 게시글 출력
		//ArrayList<BoardSet> BoardPrint(int b_no);
		write=board.BoardPrint(Integer.parseInt(req.getParameter("b_no")));
		req.setAttribute("write", write);
		

		//view에 제목 정보를 넘겨야함.
		
		forward.setRedirect(false);
		forward.setPath("제목클릭했을때 보는게시글.jsp");


		return forward;
	}
	
}
