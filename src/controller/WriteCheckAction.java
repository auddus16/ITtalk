package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteCheckAction implements Action{// 게시글 번호를 클릭했을 때 나오는 게시글 화면

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();



		forward.setRedirect(false);
		forward.setPath("게시글화면.jsp");


		return forward;
	}
	
}
