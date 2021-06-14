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
		
		ActionForward forward=null;
		if(action.equals("/mypage.mem")) { //���������� ó�� �̵�->�ʿ��� ���������� �־����,,?
			try {
				forward=new MainAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/modify.mem")) {//�������� ����
			try {
				forward=new NewmsgAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/modifypw.mem")) {//��й�ȣ�� ����
			try {
				forward=new NewmsgAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/withdraw.mem")) {//ȸ��Ż��
			try {
				forward=new NewmsgAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/mypost.mem")) {//���� �� �Խñ� ��ȸ
			try {
				forward=new NewmsgAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/myreply.mem")) {//���� �� ��� ��ȸ
			try {
				forward=new NewmsgAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/store.mem")) {//���ƿ� �� �Խñ� ��ȸ
			try {
				forward=new NewmsgAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			// ������������ �̵�-404
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
