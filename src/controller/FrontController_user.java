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
@WebServlet("*.mem")
public class FrontController_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController_user() {
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
		System.out.println(action);
		
		ActionForward forward=null;
		
		if(action.equals("/info.mem")) { //개인정보 로드
			try {
				forward=new InfoAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/checknick.mem")) {//닉네임 중복확인
			try {
				forward=new ChecknickAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/modify.mem")) {//개인정보 수정
			try {
				forward=new MymodifyAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/checkmem.mem")) {//본인인증->비밀번호변경시 & 회원탈퇴시
			try {
				forward=new CheckmemAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/modifypw.mem")) {//비밀번호만 수정
			try {
				forward=new ModifypwAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(action.equals("/mypost.mem")) {//내가 쓴 게시글 조회
			try {
				forward=new MypostAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/myreply.mem")) {//내가 쓴 댓글 조회
			try {
				forward=new MyreplyAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/mystore.mem")) {//좋아요 한 게시글 조회
			try {
				forward=new MystoreAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
//			// 에러페이지로 이동-404
//			forward=new ActionForward();
//			forward.setRedirect(false);
//			forward.setPath("/error/error404.jsp");
			System.out.println(action);
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

