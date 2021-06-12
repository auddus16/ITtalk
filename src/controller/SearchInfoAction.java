package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchInfoAction implements Action{//회원 id,pw찾기

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();




		forward.setRedirect(false);
		forward.setPath("아이디,비밀번호 찾기.jsp");

		return forward;
	}
	
}
