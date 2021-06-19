package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.C;
import itTalkDO.Mb;

public class NewreplyAction implements Action{//댓글 등록(비밀 댓글도 포함)

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();

		Board board = new Board();//dao
		
		C c=new C();//do
		Mb mb =new Mb();//do
		B b =new B();//do
		
		//c_no pk.댓글번호
		c.setC_no(Integer.parseInt(req.getParameter("c_no")));
		//b_no fk.게시글번호
		b.setB_no(Integer.parseInt(req.getParameter("b_no")));
		//mb_nick; 닉네임
		mb.setMb_nick(req.getParameter("mb_nick"));
		//mb_no fk.회원번호
		c.setMb_no(Integer.parseInt(req.getParameter("mb_no")));
		//c_write 댓글내용
		c.setC_write(req.getParameter("c_write"));
		//c_date 등록일자
		c.setC_date(req.getParameter("c_date"));
		//c_secret 비밀댓글여부
		c.setC_secret(c.isC_secret());
		
		
		
//		String cnt=req.getParameter("cnt");
//		 댓글을 몇개까지 볼수있는지에 대한 데이터
		
//		int rcnt;
//		if(cnt==null){//댓글이 없다면
//			rcnt=0;
//		}
//		else{//댓글이 있다면 댓글 수 만큼 출력
//			rcnt=Integer.parseInt(cnt);
//		}
//		req.setAttribute("rcnt", rcnt);
		
	
		//댓글 등록 b_no,mb_no,c_write
		if(!board.newReply(c)) {//댓글 등록(비밀 댓글 포함) 실패
			try {
				throw new Exception("댓글 등록 실패");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {//댓글 등록(비밀 댓글 포함) 성공	
			Boolean comment=board.newReply(c);
			req.setAttribute("comment", comment);//등록한 댓글 정보
		}
		

		
		//req.setAttribute("datas", 댓글s); 보낼 데이터 정보
		
	


		forward.setRedirect(false);
		forward.setPath("댓글작성.jsp");

		return forward;
	}

}
