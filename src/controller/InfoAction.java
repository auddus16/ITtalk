package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;

public class InfoAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("�����׼� ����");
		ActionForward forward= new ActionForward();
		
		MyPageDAO mypageDAO= new MyPageDAO();//���������� ���� �ʿ��� ������ ��������
		Mb myInfo= new Mb();
		myInfo.setMb_nick("fff");
		
		//pageContext.forward("main.jsp");
		req.setAttribute("myInfo", myInfo);//��������
		req.setAttribute("kind", "info");//�������������� � �������� include���� ����
		
		forward.setRedirect(false);
		forward.setPath("/hmy_mypage.jsp");
		
		return forward;
	}
}
