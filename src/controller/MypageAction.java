package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;

public class MypageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward= new ActionForward();
		
		MyPageDAO mypageDAO= new MyPageDAO();//���������� ���� �ʿ��� ������ ��������
		
//		ArrayList<String> myInfo = new ArrayList<>();//���������� ���� ����Ʈ
//		req.setAttribute("info", new Mb());
//		
//		MessageDAO msgDAO= new MessageDAO();
//		req.setAttribute("datas", msgDAO.getAll(mcnt));//�Խ��� ���
//		MemberDAO memDAO= new MemberDAO();
//		req.setAttribute("users", memDAO.getMembers());//ȸ�� ���
//		
		//pageContext.forward("main.jsp");
		req.setAttribute("kind", "info");
		forward.setRedirect(false);
		forward.setPath("/hmy_mypage.jsp");
		
		return forward;
	}

}
