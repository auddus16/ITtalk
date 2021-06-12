package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.ActionForward;
import test.MainAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.jsp")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
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
		if(command.equals("/hmy_main.do")) {
			try {
				forward=new MainAction().execute(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/ȸ������.do")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("form.jsp");
		}
		else if(command.equals("/�α���.do")) {

		}
		else if(command.equals("/id,pwã��.do")) {
			
		}
		else if(command.equals("/����������.do")) {

		}
		else if(command.equals("/������.do")) {

		}
		else if(command.equals("/�Խ���.do")) {

		}
		else {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("error.jsp");
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
