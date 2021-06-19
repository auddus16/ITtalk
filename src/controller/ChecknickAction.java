package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Membership;
import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;

public class ChecknickAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		MyPageDAO mypageDAO= new MyPageDAO();
		Membership memDAO= new Membership();
		
		HttpSession session= req.getSession();
		session.getAttribute("mb_no");//���ǿ� �α��εǾ��ִ� ȸ����ȣ�� ���������ؾ���..
		
		Mb myInfo= mypageDAO.Info(1);// ���� �� �ٲ����..
		
		String paramNick =req.getParameter("nick");
		
		PrintWriter out=res.getWriter();
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		if(paramNick == myInfo.getMb_nick()) {
			//�Ѿ�� �г��Ӱ� ���� �г����� ������ == �� �������� �ʾ��� ���
			req.setAttribute("flag", true);
		}
		else {
			if(!(memDAO.nickCheck(paramNick))) {
				req.setAttribute("flag", true);
				out.println("<script>alert('��밡���� �г����Դϴ�.');history.go(-1);</script>");
			}
			else {
				req.setAttribute("flag", false);//�Ѿ�� �ȵ�
				out.println("<script>alert('�̹� ������� �г����� �����մϴ�. �ٸ� �г����� �Է��ϼ���.');history.go(-1);</script>");
			}
			
		}
		
		return null;
	}

}
//if(action.equals("checknick")){
//	//alert�� 
//	//���ξ��̵�
//	if(!(memDAO.nickCheck(request.getParameter("nick")))){
//		//�ߺ����� ����
//		request.setAttribute("flag", true);//true�϶��� �����Ϸᰡ ����
//		out.println("<script>alert('��밡���� �г����Դϴ�.');history.go(-1);</script>");
//	}
//	else{
//		
//		out.println("<script>alert('�ߺ��Ǵ� �г����� �����մϴ�. �ٸ� �г����� �Է��ϼ���.');history.go(-1);</script>");
//	}
//	
//}