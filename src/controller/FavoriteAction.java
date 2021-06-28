package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Board;
import itTalkDO.B;
import itTalkDO.Mb;

public class FavoriteAction implements Action {// ���ƿ� 

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Board bDAO =new Board(); //dao
				
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		HttpSession session= req.getSession();
		
		// �Խñ� ���ƿ�
		if(session.getAttribute("mb_no")== null) {
			
			out.println("<script>alert('�α����� �ʿ��մϴ�.');location.href='cate.do';</script>");
		}
		else {
			
			if(!bDAO.like((Integer)session.getAttribute("mb_no"),Integer.parseInt(req.getParameter("b_no")))) {//�Խñ� ���ƿ� ����
			
				out.println("<script>alert('�Խñ� ��������Ͽ����ϴ�. �ٽ� �õ����ּ���!');history.go(-1);</script>");
			}
			else {// �Խñ� ���ƿ� ����
				
				out.println("<script>alert('�Խñ��� �����Ͽ����ϴ�.����� �Խñ��� �������������� Ȯ�ΰ����մϴ�!');location.href='post.do?b_no="+req.getParameter("b_no")+"';</script>");
			}
			
		}
		
		return null;
	}

}
