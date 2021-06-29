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

public class CheckmemAction implements Action {
	//��й�ȣ ���� �׼� & ȸ��Ż��� ��й�ȣ Ȯ�� �׼�
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MyPageDAO mypageDAO= new MyPageDAO();
		
		HttpSession session= req.getSession();
		
		Mb myInfo= mypageDAO.Info((Integer)session.getAttribute("mb_no"));
		
		String paramPw =req.getParameter("pw");
		System.out.println(paramPw);
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(paramPw.equals(myInfo.getMb_pw())) {
			//�������� ����
			System.out.println(myInfo.getMb_pw());
			System.out.println(req.getParameter("c"));
			
			if(req.getParameter("c").equals("withdraw")) {//ȸ��Ż�� �׼��� ��
				
				if(req.getParameter("c").equals("withdraw")) {
					mypageDAO.deleteMember((Integer)session.getAttribute("mb_no"));
					session.invalidate();
					out.println("<script>alert('ȸ��Ż�� �Ǿ����ϴ�.');opener.document.location='main.main';self.close();</script>");
				}
			}
			
			else {//��й�ȣ���� �׼��϶�
				
				out.println("<script>location.href='newpw2.jsp';</script>");
			}
		}
		else {
			//�������� ����
			System.out.println(myInfo.getMb_pw());
			out.println("<script>alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');history.go(-1);</script>");
		}
		return null;
	}

}
