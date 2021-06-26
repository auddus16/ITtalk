package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import itTalkDAO.Board;
import itTalkDAO.MyPageDAO;
import itTalkDO.BoardSet;

public class PostAction implements Action{
	@SuppressWarnings("null")
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		Board bDAO = new Board();
		MyPageDAO myDAO= new MyPageDAO();
		
		int cnt=0; //ó�� � �Խñ��� ���ε� ���� �����ϴ� ����
		if(req.getParameter("cnt")==null){//�⺻ �Խñ� ���� 10���� ����
			cnt=5;
		}
		else {
			cnt=Integer.parseInt(req.getParameter("cnt"));
		}
		
		req.setAttribute("cnt", cnt);//�����⺯�� ��
		
		bDAO.hits(Integer.parseInt(req.getParameter("b_no")));
		BoardSet boardSet = bDAO.BoardPrint(Integer.parseInt(req.getParameter("b_no")), cnt);
		
		req.setAttribute("write", boardSet.getBoard());		
		req.setAttribute("replyList", boardSet.getRlist());		
		
		//��ȸ��+1
		
		req.setAttribute("write_nick", myDAO.Info(boardSet.getBoard().getMb_no()).getMb_nick());//�ۼ��� �г���
		req.setAttribute("write_cate", bDAO.Bc_Bn(boardSet.getBoard().getBc_no()));//category name set�ؾ���
		
		//json���ڿ��� ��ȯ����
		ObjectMapper mapper= new ObjectMapper();
		String jsonStr= mapper.writeValueAsString(boardSet.getRlist());//��۸���Ʈ ��ũ������
		req.setAttribute("json", jsonStr);
		
		forward.setRedirect(false);
		forward.setPath("hmy_write.jsp");

		return forward;
	}
}
//public boolean hits(int b_no) {
//B Load(int b_no){//�Խñ� ��ȣ