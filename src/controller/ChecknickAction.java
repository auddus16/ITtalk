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
		
		Mb myInfo= mypageDAO.Info((Integer)session.getAttribute("mb_no"));// ���� �� �ٲ����..
		
		String paramNick =req.getParameter("nick");
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(paramNick.equals( myInfo.getMb_nick())) {
			//�Ѿ�� �г��Ӱ� ���� �г����� ������ == �� �������� �ʾ��� ���
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("info.mem?flag='true'");
			
			return forward;
		}
		else {
			if(!(memDAO.nickCheck(paramNick))) {
				req.setAttribute("flag", true);
				
				//info.jsp�� ����� �г����� �Ⱥ���..
				out.println("<script>alert('��밡���� �г����Դϴ�.');location.href='info.mem?flag=true&nick="+paramNick+"&job="+req.getParameter("job")+"';</script>");
			}
			else {
				out.println("<script>alert('�̹� ������� �г����� �����մϴ�. �ٸ� �г����� �Է��ϼ���.');location.href='info.mem?flag=false&job="+req.getParameter("job")+"';</script>");
				req.setAttribute("flag", false);//�Ѿ�� �ȵ�
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