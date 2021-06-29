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
		
//		<li><a href="adrepost.ad?cnt=10">�Ű�Խñ�</a></li>
//        <li><a href="adreply.ad?cnt=10">�Ű���</a></li>
//        <li><a href="adallpost.ad?cnt=10">��ü �Խñ� ��ȸ �� ����</a></li>
//        <li><a href="admodifycate.ad">�Խ���ī�װ� ����</a></li>
		
		ActionForward forward=null;
		if(action.equals("/adpost.ad")) { //�Ű�Խñ� Ȯ��
			try {
				forward=new AdpostAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(action.equals("/admodifycate.ad")) {//�Խ���ī�װ� ����
			try {
				forward=new AdmodicateAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/addelcate.ad")) {//�Խ���ī�װ� ����
			try {
				forward=new AddelcateAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/adaddcate.ad")) {//�Խ���ī�װ� ����
			try {
				forward=new AdaddcateAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/adcate.ad")) {//�Խ���ī�װ� ��ȸ
			try {
				forward=new AdcateAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/adreply.ad")) {//�Ű���
			try {
				forward=new AdreplyAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/adallpost.ad")) {//��ü �Խñ���ȸ �� ����
			try {
				forward=new AdallpostAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/addelpost.ad")) {//�Ű�Խñ� ����
			try {
				forward=new AddelpostAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/addelpost2.ad")) {//�Խñ� ����
			try {
				forward=new Addelpost2Action().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/addelreply.ad")) {//�Ű��� ����
			try {
				forward=new AddelreplyAction().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/removeblind.ad")) {//�Ű�Խñ� ����ε�����
			try {
				forward=new RemoveBlind1Action().execute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("/removeblind2.ad")) {//�Ű��� ����ε�����
			try {
				forward=new RemoveBlind2Action().execute(req, res);
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


