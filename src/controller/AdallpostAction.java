package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.AdminMenu;
import itTalkDO.B;

public class AdallpostAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ActionForward forward= new ActionForward();
		
		AdminMenu adDAO = new AdminMenu();
		
		int cnt=0; //ó�� � �Խñ��� ���ε� ���� �����ϴ� ����
		if(req.getParameter("cnt")==null){//�⺻ ��� ���� 5���� ����
			cnt=5;
		}
		else {
			cnt=Integer.parseInt(req.getParameter("cnt"));
		}
		
		req.setAttribute("cnt", cnt);//�����⺯�� ��
		
		ArrayList<B> adallpostList= adDAO.getBoardList();
		
		ObjectMapper mapper= new ObjectMapper();
		String jsonStr= mapper.writeValueAsString(adallpostList);
		req.setAttribute("json", jsonStr);
		
		req.setAttribute("adallpostList", adallpostList);//����� ��� ����Ʈ
		
		req.setAttribute("kind", "allpost");//� �������� include���� ����
		
		forward.setRedirect(false);
		forward.setPath("/hmy_adpage.jsp");
		
		return forward;
	}

}
