package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Membership;
import itTalkDAO.MyPageDAO;
import itTalkDO.Mb;

public class ChecknickAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		MyPageDAO mypageDAO= new MyPageDAO();
		Membership memDAO= new Membership();
		
		HttpSession session= req.getSession();
		
		Mb myInfo= mypageDAO.Info((Integer)session.getAttribute("mb_no"));// 수정 후 바꿔야함..
		
		String paramNick =req.getParameter("nick");
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=res.getWriter();
		
		if(paramNick.equals( myInfo.getMb_nick())) {
			//넘어온 닉네임과 현재 닉네임이 같을때 == 즉 변경하지 않았을 경우
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("info.mem?flag='true'");
			
			return forward;
		}
		else {
			if(!(memDAO.nickCheck(paramNick))) {
				req.setAttribute("flag", true);
				
				//info.jsp에 변경된 닉네임이 안보임..
				out.println("<script>alert('사용가능한 닉네임입니다.');location.href='info.mem?flag=true&nick="+paramNick+"&job="+req.getParameter("job")+"';</script>");
			}
			else {
				out.println("<script>alert('이미 사용중인 닉네임이 존재합니다. 다른 닉네임을 입력하세요.');location.href='info.mem?flag=false&job="+req.getParameter("job")+"';</script>");
				req.setAttribute("flag", false);//넘어가면 안됨
			}
			
		}
		
		
		
		return null;
	}

}
//if(action.equals("checknick")){
//	//alert로 
//	//본인아이디
//	if(!(memDAO.nickCheck(request.getParameter("nick")))){
//		//중복되지 않음
//		request.setAttribute("flag", true);//true일때만 수정완료가 가능
//		out.println("<script>alert('사용가능한 닉네임입니다.');history.go(-1);</script>");
//	}
//	else{
//		
//		out.println("<script>alert('중복되는 닉네임이 존재합니다. 다른 닉네임을 입력하세요.');history.go(-1);</script>");
//	}
//	
//}