package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.MyPageDAO;
import itTalkDO.B;
import itTalkDO.Mb;

public class MypostAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward= new ActionForward();
		
		MyPageDAO mypageDAO= new MyPageDAO();//���������� ���� �ʿ��� ������ ��������
		
		HttpSession session= req.getSession();
		session.getAttribute("mb_no");//���ǿ� �α��εǾ��ִ� ȸ����ȣ
		
		ArrayList<B> arrB = mypageDAO.getMyBoard(1);
		
		req.setAttribute("mypostList", arrB);//�Խñ��� ��� ����Ʈ
		req.setAttribute("kind", "post");//�������������� � �������� include���� ����
		
		forward.setRedirect(false);
		forward.setPath("/hmy_mypage.jsp");
		
		return forward;
	}

}
