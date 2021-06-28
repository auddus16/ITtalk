package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import itTalkDAO.Board;
import itTalkDAO.DBManager;
import itTalkDO.B;
import itTalkDO.Mb;

public class NewmsgAction implements Action{// 게시글 등록

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		Board board = new Board();//dao
		
		Mb mb =new Mb();//do
		B b =new B();//do
		
		//--등록할 때 필요한 정보--
		
//		//mb_nick; 닉네임
//		mb.setMb_nick(req.getParameter("mb_nick"));
//		//mb_no fk.회원번호
//		mb.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
//		
//		//b_no; 게시글번호
//		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
//		//bc_no; 카테고리번호 -> 인자로는 int지만, 보낼때는 문자열로 보내야됨.  뷰에서 받을때 번호로 받아야함.(num)
//		b.setBc_no(Integer.parseInt(req.getParameter("bc_no")));
//		//b_title; 제목
//		b.setB_title(req.getParameter("b_title"));
//		//b_write; 내용
//		b.setB_write(req.getParameter("b_write"));
//		//b_file 첨부파일
//		b.setB_file(req.getParameter("b_file"));
//		//b_date; 등록일자
//		b.setB_date(req.getParameter("b_date"));
		
//		String cnt=req.getParameter("cnt");
//		// 게시글을 몇개까지 볼수있는지에 대한 데이터
		
//		int mcnt;
//		if(cnt==null){//게시글이 없다면
//			mcnt=0;
//		}
//		else{//게시글이 있다면 게시글 수 만큼 출력
//			mcnt=Integer.parseInt(cnt);
//		}
//		req.setAttribute("cnt", mcnt);//게시글 수
		
		ServletContext application = req.getServletContext();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		
		String bc_no = null;
		bc_no=board.Upload(req, res);		
		
		//req.setAttribute("datas", datas); 보낼 데이터 정보
		forward.setRedirect(false);
		forward.setPath("cate.do?bc_no=" + bc_no);


		return forward;
	}

}
