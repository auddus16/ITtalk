package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Membership;
import itTalkDO.Mb;

public class AuthNumAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		ActionForward forward= new ActionForward();
		HttpSession session=req.getSession();
		String email = (String) session.getAttribute("mb_email");
		String authNum = req.getParameter("authNum"); // �Է¹��� ȸ������ ������ȣ
		String searchauth = req.getParameter("searchauth"); // �Է¹��� ���̵� ã�� ������ȣ
		System.out.println("�Է� �̸��� : " + email);
		System.out.println("�Է� ȸ������ ������ȣ : "+authNum);
		System.out.println("�Է� ã�� ������ȣ : "+searchauth);
		String checkNum=(String) session.getAttribute("checkNum"); // ��Ʈ�ѷ��� ������ ������ȣ
		System.out.println("��Ʈ�ѷ� ���� ������ȣ : "+checkNum);
		
		PrintWriter out=res.getWriter();
		if(authNum!=null) {
			if(authNum.equals(checkNum)) { // ȸ������ ������ȣ ��ġ
				session.removeAttribute("checkNum"); 
				forward.setRedirect(false);
				forward.setPath("/authCheckProc.jsp");
				return forward;
			}
			else { // ������ȣ ����ġ
				out.println("<script>alert('������ȣ�� Ȯ�����ּ���.');window.history.back();</script>");
				return null;
			}
		}
		else {
			if(searchauth.equals(checkNum)) { // ���̵�ã�� ������ȣ ��ġ
				Membership membership = new Membership();
				try {
				Mb mb = membership.SearchId(email);
				System.out.println("ã�� id : "+mb.getMb_id());
				String SearchedId = mb.getMb_id();
				session.removeAttribute(email);
				System.out.println(SearchedId.substring(0, 2));
				
				String str = "*";
				String Vid = SearchedId.substring(0, 2)+str.repeat(SearchedId.length()-2);
				System.out.println(Vid);
				req.setAttribute("SearchedId",Vid);
				
				session.removeAttribute("checkNum");
				forward.setRedirect(false);
				forward.setPath("/searchIdRes.jsp");
				return forward;
				}catch(Exception e) {
					e.printStackTrace();
					out.println("<script>alert('ȸ�����Ե� �̸����� �ƴմϴ�.');location.href('searchId.jsp');</script>");
					return null;
				}
			}
			else { // ������ȣ ����ġ
				out.println("<script>alert('������ȣ�� Ȯ�����ּ���.');window.history.back();</script>");
				return null;
			}
		}
	}

}
