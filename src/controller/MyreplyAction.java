package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.MyPageDAO;
import itTalkDO.C;

public class MyreplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward= new ActionForward();
		
		MyPageDAO mypageDAO= new MyPageDAO();//���������� ���� �ʿ��� ������ ��������
		
		HttpSession session= req.getSession();
		
		int cnt=0; //ó�� � �Խñ��� ���ε� ���� �����ϴ� ����
		if(req.getParameter("cnt")==null){//�⺻ ��� ���� 5���� ����
			cnt=5;
		}
		else {
			cnt=Integer.parseInt(req.getParameter("cnt"));
		}
		
		req.setAttribute("cnt", cnt);//�����⺯�� ��
		
		//ArrayList<C> arrC= mypageDAO.getMyComment((Integer)session.getAttribute("mb_no"));
		ArrayList<C> arrC= mypageDAO.getMyComment((Integer)session.getAttribute("mb_no"));
		
		ObjectMapper mapper= new ObjectMapper();
		String jsonStr= mapper.writeValueAsString(arrC);
		req.setAttribute("json", jsonStr);

		req.setAttribute("myreplyList", arrC);//����� ��� ����Ʈ
		
		req.setAttribute("kind", "reply");//�������������� � �������� include���� ����
		
		forward.setRedirect(false);
		forward.setPath("/hmy_mypage.jsp");
		
		return forward;
	}

}
