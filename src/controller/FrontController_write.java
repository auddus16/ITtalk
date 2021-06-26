package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController_write extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController_write() {
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
		//System.out.println("uri: "+uri);

		String cp=req.getContextPath();
		//System.out.println("cp: "+cp);
		// 프로그램이 실행되기 위해 필요한 리소스의 명칭
		// 메모리에 로드되기위한 메모리영역

		String command=uri.substring(cp.length());
		System.out.println("command: "+command);

		// XxxAction.java 파일들을 작성할 예정
		// Controller : M->보낼 데이터의 유무   V->어디로 보낼지
		ActionForward forward=null;
		if(command.equals("/Newmsg.do")) {
			try {
				forward=new NewmsgAction().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/delete.do")) {
			try {
				forward=new DeletepostAction().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/delete2.do")) {
			try {
				forward=new DeletereplyAction().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/cate.do")) {//카테고리 더보기
			try {
				forward=new CateAction().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/post.do")) {//게시글 확인
			try {
				forward=new PostAction().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/UpdateMsg.do")) {
			try {
				forward=new UpdateMsgAction().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/report.do")) {
			try {
				forward=new ReportAction().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/report2.do")) {
			try {
				forward=new Report2Action().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/Board.do")) {
			try {
				forward=new BoardAction().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/favorite.do")) {
			try {
				forward=new FavoriteAction().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/Newreply.do")) {
			try {
				forward=new NewreplyAction().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/Search.do")) {
			try {
				forward=new SearchAction().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/error404.jsp");
		}

		
		if(forward!=null) {//방식과 경로가 있다면
			if(forward.isRedirect()) {// 방식이 있다면
				res.sendRedirect(forward.getPath());
			}
			else {//요청 재지정
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, res);
				
				// 요청 지정 등의 기능에 사용되는 API
				// 클라이언트로부터 요청 받은 Servlet 프로그램이 응답하지않고
				// 다른 자원에 수행의 제어권을 넘겨서 처리 결과를 대신 응답하는 기능
				// or 다른 자원에 수행을 시키고 그 결과를 포함해서 응답하는 기능
				// == 요청 재지정

				// 코드작성에 제한이 발생하기때문에(별도의 알고리즘 구현이 필요) << 세션,어플리케이션
				// RD를 get()할때, 경로를 인자로 넣어주면
				// 경로까지 데이터 전달가능
			}
		}











	}

}
