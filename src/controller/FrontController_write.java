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
		// ���α׷��� ����Ǳ� ���� �ʿ��� ���ҽ��� ��Ī
		// �޸𸮿� �ε�Ǳ����� �޸𸮿���

		String command=uri.substring(cp.length());
		System.out.println("command: "+command);

		// XxxAction.java ���ϵ��� �ۼ��� ����
		// Controller : M->���� �������� ����   V->���� ������
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
		else if(command.equals("/cate.do")) {//ī�װ� ������
			try {
				forward=new CateAction().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/post.do")) {//�Խñ� Ȯ��
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

		
		if(forward!=null) {//��İ� ��ΰ� �ִٸ�
			if(forward.isRedirect()) {// ����� �ִٸ�
				res.sendRedirect(forward.getPath());
			}
			else {//��û ������
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, res);
				
				// ��û ���� ���� ��ɿ� ���Ǵ� API
				// Ŭ���̾�Ʈ�κ��� ��û ���� Servlet ���α׷��� ���������ʰ�
				// �ٸ� �ڿ��� ������ ������� �Ѱܼ� ó�� ����� ��� �����ϴ� ���
				// or �ٸ� �ڿ��� ������ ��Ű�� �� ����� �����ؼ� �����ϴ� ���
				// == ��û ������

				// �ڵ��ۼ��� ������ �߻��ϱ⶧����(������ �˰��� ������ �ʿ�) << ����,���ø����̼�
				// RD�� get()�Ҷ�, ��θ� ���ڷ� �־��ָ�
				// ��α��� ������ ���ް���
			}
		}











	}

}
