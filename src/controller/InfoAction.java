package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;

public class InfoAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("�����׼� ����");
		ActionForward forward= new ActionForward();
		
		MyPageDAO mypageDAO= new MyPageDAO();//���������� ���� �ʿ��� ������ ��������
		
		HttpSession session= req.getSession();
		session.getAttribute("mb_no");//���ǿ� �α��εǾ��ִ� ȸ����ȣ�� ���������ؾ���..
		
//		Mb myInfo= mypageDAO.Info(1);
//		myInfo.setMb_id("auddus16");
		
		Mb myInfo= new Mb();//db mypageDAO.Info() ���� �� �ٲ����..
		myInfo.setMb_id("auddus16");
		
		req.setAttribute("myInfo", myInfo);//��������
		req.setAttribute("kind", "info");//�������������� � �������� include���� ����
		
		forward.setRedirect(false);
		forward.setPath("/hmy_mypage.jsp");
		
		return forward;
	}
}
