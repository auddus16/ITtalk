package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;

public class MymodifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward= new ActionForward();
		
		MyPageDAO mypageDAO= new MyPageDAO();//���������� ���� �ʿ��� ������ ��������
		
		HttpSession session= req.getSession();
		
		Mb mb= new Mb();
		
		mb.setMb_no((Integer)session.getAttribute("mb_no"));
		mb.setMb_nick(req.getParameter("nick"));
		mb.setMb_job(Boolean.parseBoolean(req.getParameter("job")));
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(mypageDAO.updateMember(mb)) {
			out.println("<script>alert('�����Ϸ�Ǿ����ϴ�.');</script>");
		}
		else {
			out.println("<script>alert('��й�ȣ �����߽��ϴ�.');history.go(-1);</script>");
		}
		
		//req.setAttribute("kind", "info");//�������������� � �������� include���� ����
		forward.setRedirect(false);
		forward.setPath("info.mem");
		
		return forward;
	}

}

//updateMember(Mb mb)