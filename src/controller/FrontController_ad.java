package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController_user
 */
@WebServlet("*.ad")
public class FrontController_ad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController_ad() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	private void actionDo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri=req.getRequestURI();
		String cp=req.getContextPath();
		String action=uri.substring(cp.length());
		
//		<li><a href="adrepost.ad?cnt=10">신고게시글</a></li>
//        <li><a href="adreply.ad?cnt=10">신고댓글</a></li>
//        <li><a href="adallpost.ad?cnt=10">전체 게시글 조회 및 삭제</a></li>
//        <li><a href="admodifycate.ad">게시판카테고리 수정</a></li>
		
		ActionForward forward=null;
		if(action.equals("/adpost.ad")) { //신고게시글 확인
			try {
				forward=new AdpostAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(action.equals("/admodifycate.ad")) {//게시판카테고리 수정
			try {
				forward=new AdmodicateAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/addelcate.ad")) {//게시판카테고리 삭제
			try {
				forward=new AddelcateAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/adaddcate.ad")) {//게시판카테고리 삭제
			try {
				forward=new AdaddcateAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/adcate.ad")) {//게시판카테고리 조회
			try {
				forward=new AdcateAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/adreply.ad")) {//신고댓글
			try {
				forward=new AdreplyAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/adallpost.ad")) {//전체 게시글조회 및 삭제
			try {
				forward=new AdallpostAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/addelpost.ad")) {//신고게시글 삭제
			try {
				forward=new AddelpostAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/addelpost2.ad")) {//게시글 삭제
			try {
				forward=new Addelpost2Action().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/addelreply.ad")) {//신고댓글 삭제
			try {
				forward=new AddelreplyAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/removeblind.ad")) {//신고게시글 블라인드해제
			try {
				forward=new RemoveBlind1Action().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/removeblind2.ad")) {//신고댓글 블라인드해제
			try {
				forward=new RemoveBlind2Action().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			// 에러페이지로 이동-404
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/error404.jsp");
		}
		
		if(forward!=null) {
			if(forward.isRedirect()) {
				res.sendRedirect(forward.getPath());
			}
			else {
				RequestDispatcher dispatcher=req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, res);
			}
		}
	}
}


