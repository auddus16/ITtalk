package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.MyPageDAO;
import itTalkDO.Bs;

public class MystoreAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward= new ActionForward();
		
		MyPageDAO mypageDAO= new MyPageDAO();//���������� ���� �ʿ��� ������ ��������
		
		HttpSession session= req.getSession();
		
		int cnt=0; //ó�� � �Խñ��� ���ε� ���� �����ϴ� ����
		if(req.getParameter("cnt")==null){//�⺻ �Խñ� ���� 5���� ����
			cnt=5;
		}
		else {
			cnt=Integer.parseInt(req.getParameter("cnt"));
		}
		
		req.setAttribute("cnt", cnt);//�����⺯�� ��
		
		//ArrayList<C> arrC= mypageDAO.getMyComment((Integer)session.getAttribute("mb_no"));
		ArrayList<Bs> arrB= mypageDAO.getMyBoardSave((Integer)session.getAttribute("mb_no"));
		
		ObjectMapper mapper= new ObjectMapper();
		String jsonStr= mapper.writeValueAsString(arrB);
		req.setAttribute("json", jsonStr);
		
		req.setAttribute("mystoreList", arrB);//�Խñ��� ��� ����Ʈ
		
		req.setAttribute("kind", "store");//�������������� � �������� include���� ����
		
		forward.setRedirect(false);
		forward.setPath("/hmy_mypage.jsp");
		
		return forward;
	}


}
