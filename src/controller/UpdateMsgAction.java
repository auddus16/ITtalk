package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.AdminMenu;
import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Bc;
import itTalkDO.Mb;

public class UpdateMsgAction implements Action{// 게시글 수정(본인게시글 보여줌->수정여부 확인)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		
		ArrayList<Bc> cate =new ArrayList<>();//게시판 카테고리 출력
		
		HttpSession session=req.getSession();
		req.setAttribute("mb_no", session.getAttribute("mb_no"));
		
		AdminMenu adminmenu = new AdminMenu(); //dao
		Board board =new Board(); //dao

		B b = new B(); //do
		Mb mb =new Mb(); //do

		req.setAttribute("b_no", Integer.parseInt(req.getParameter("b_no")));
		
		if(!req.getParameter("b_no").equals("0")) {
			b = board.Load(Integer.parseInt(req.getParameter("b_no")));
			// 게시글 불러오기
			req.setAttribute("b", b);//게시글 불러오기 기능
		}
				
		
//		//b_no 게시글번호
//		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
//		//mb_no 회원번호
//		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
//		//bc_no 게시판카테고리번호
//		bc.setBc_no(Integer.parseInt(req.getParameter("bc_no)")));
//		//b_title 제목
//		b.setB_title(req.getParameter("b_title"));
//		//b_write 내용
//		b.setB_write(req.getParameter("b_write"));
//		//b_file 첨부파일
//		b.setB_file(req.getParameter("b_file"));
//		//b_date 등록일자
//		b.setB_date(req.getParameter("b_date"));


		//json문자열로 변환과정
//		ObjectMapper mapper2= new ObjectMapper();
//
//		String jsonStr2= mapper2.writeValueAsString(cate);
//		req.setAttribute("json", jsonStr2);

		
		// 게시판 카테고리 출력 
		// ArrayList<Bc> getBoardCategory()
		cate=adminmenu.getBoardCategory();
		req.setAttribute("cate", cate);

		
		forward.setRedirect(false);
		forward.setPath("hmy_writemodify.jsp");


		return forward;
	}

}
