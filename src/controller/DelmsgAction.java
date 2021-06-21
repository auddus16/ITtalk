package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;

public class DelmsgAction implements Action{//게시글 삭제

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		

		Board board = new Board();//dao
		
		Mb mb =new Mb();//do
		B b =new B();//do
		
	
		//mb_nick; 닉네임
		mb.setMb_nick(req.getParameter("mb_nick"));
		//mb_no fk.회원번호
		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//b_no; 게시글번호
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//bc_no; 카테고리번호 -> 인자로는 int지만, 보낼때는 문자열로 보내야됨.  뷰에서 받을때 번호로 받아야함.(num)
		b.setBc_no(Integer.parseInt(req.getParameter("bc_no")));
		//b_title; 제목
		b.setB_title(req.getParameter("b_title"));
		//b_write; 내용
		b.setB_write(req.getParameter("b_write"));
		//b_file 첨부파일
		b.setB_file(req.getParameter("b_file"));
		//b_date; 등록일자
		b.setB_date(req.getParameter("b_date"));
		
		
		
		//게시글 불러오기(해당 게시글을 삭제하기위함)
		//B Load(int b_no)
		
		b=board.Load(Integer.parseInt(req.getParameter("b_no")));
		req.setAttribute("b", b);//게시글 불러오기 기능
		
		
		
		
		//게시글 삭제
		//boolean delB(HttpServletRequest req, HttpServletResponse res)
		
		ServletContext application = req.getServletContext();
		
		if(!board.delB(req, res)) {//게시글 삭제 실패
			try {
				throw new Exception("게시글 삭제 실패");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {//게시글 삭제 성공
			Boolean writedelete =board.delB(req, res);
			application.setAttribute("writedelete", writedelete);
		}
		
		
		
		
		
		// 이미지 삭제
		//boolean delF(HttpServletRequest req, HttpServletResponse res)

			
		if(!board.delF(req, res)) {//이미지 삭제 실패
			try {
				throw new Exception("이미지 삭제 실패");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {//이미지 삭제 성공
			Boolean imagedelete =board.delF(req, res);
			application.setAttribute("imagedelete", imagedelete);
		}
		
		
		
		
		forward.setRedirect(false);
		forward.setPath("게시글삭제.jsp");


		return forward;
	}

}
