package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.MyPageDAO;
import itTalkDO.B;

public class MypostAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward= new ActionForward();
		
		MyPageDAO mypageDAO= new MyPageDAO();//���������� ���� �ʿ��� ������ ��������
		
		HttpSession session= req.getSession();
		
		int cnt=0; //ó�� � �Խñ��� ���ε� ���� �����ϴ� ����
		if(req.getParameter("cnt")==null){//�⺻ �Խñ� ���� 10���� ����
			cnt=10;
		}
		else {
			cnt=Integer.parseInt(req.getParameter("cnt"));
		}
		
		req.setAttribute("cnt", cnt);//�����⺯�� ��
		
		//ArrayList<B> arrB= mypageDAO.getMyBoard((Integer)session.getAttribute("mb_no"));
		ArrayList<B> arrB= mypageDAO.getMyBoard((Integer)session.getAttribute("mb_no"));
		
		//json���ڿ��� ��ȯ����
		ObjectMapper mapper= new ObjectMapper();
			
		String jsonStr= mapper.writeValueAsString(arrB);
		req.setAttribute("json", jsonStr);
		
		req.setAttribute("mypostList", arrB);//�Խñ��� ��� ����Ʈ
		req.setAttribute("kind", "post");//�������������� � �������� include���� ����
		
		forward.setRedirect(false);
		forward.setPath("/hmy_mypage.jsp");
		
		return forward;
	}

}
