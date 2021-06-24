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
		
		int cnt=0; //처음 몇개 게시글을 업로드 할지 저장하는 변수
		if(req.getParameter("cnt")==null){//기본 댓글 개수 5개로 지정
			cnt=5;
		}
		else {
			cnt=Integer.parseInt(req.getParameter("cnt"));
		}
		
		req.setAttribute("cnt", cnt);//더보기변수 셋
		
		ArrayList<B> adallpostList= adDAO.getBoardList();
		
		ObjectMapper mapper= new ObjectMapper();
		String jsonStr= mapper.writeValueAsString(adallpostList);
		req.setAttribute("json", jsonStr);
		
		req.setAttribute("adallpostList", adallpostList);//댓글이 담긴 리스트
		
		req.setAttribute("kind", "allpost");//어떤 페이지를 include할지 정보
		
		forward.setRedirect(false);
		forward.setPath("/hmy_adpage.jsp");
		
		return forward;
	}

}
