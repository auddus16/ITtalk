package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.AdminMenu;
import itTalkDO.Rb;

public class AdpostAction implements Action{
	
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
		
		ArrayList<Rb> adpostList= adDAO.getReportBoardList();
		
		ObjectMapper mapper= new ObjectMapper();
		String jsonStr= mapper.writeValueAsString(adpostList);
		req.setAttribute("json", jsonStr);
		
		req.setAttribute("adpostList", adpostList);//����� ��� ����Ʈ
		
		req.setAttribute("kind", "adpost");//� �������� include���� ����
		
		forward.setRedirect(false);
		forward.setPath("/hmy_adpage.jsp");
		
		return forward;
	}
}
