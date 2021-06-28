package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Membership;
import itTalkDO.Mb;

public class AuthNumAction implements Action {
   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      req.setCharacterEncoding("UTF-8");
      res.setContentType("text/html; charset=UTF-8");
      
      ActionForward forward= new ActionForward();
      HttpSession session=req.getSession();
      Membership membership = new Membership();
      String email = (String) session.getAttribute("mb_email");
      String authNum = req.getParameter("authNum"); // 입력받은 회원가입 인증번호
      String searchid = req.getParameter("searchidAuth"); // 입력받은 아이디 찾기 인증번호
      String searchpw = req.getParameter("searchPwAuth"); // 입력받으느 비밀번호 찾기 인증번호
      System.out.println("입력받은 이메일 : " + email);
      System.out.println("입력받은 회원가입 인증번호 : "+authNum);
      System.out.println("입력받은 찾기 인증번호 : "+searchid);
      String checkNum=(String) session.getAttribute("checkNum"); // 컨트롤러가 발행한 인증번호
      System.out.println("컨트롤러 발행 인증번호 : "+checkNum);
      
      PrintWriter out=res.getWriter();
      if(authNum!=null) {   // 회원가입 인증
         if(authNum.equals(checkNum)) { // 회원가입 인증번호 일치
            boolean authcheck = authNum.equals(checkNum);
            req.setAttribute("authcheck", authcheck);
            forward.setRedirect(false);
            forward.setPath("/authCheckProc.jsp");
            return forward;
         }
         else { // 인증번호 불일치
            out.println("<script>alert('인증번호를 확인해주세요.');window.history.go(-1);</script>");
            return null;
         }
      }
      else if(searchid!=null){ // 아이디찾기 인증
         if(searchid.equals(checkNum)) { // 아이디찾기 인증번호 일치
            
            try {
            Mb mb = membership.SearchId(email);
            System.out.println("찾은 id : "+mb.getMb_id());
            String SearchedId = mb.getMb_id();
            session.removeAttribute(email);
            System.out.println(SearchedId.substring(0, 2));
            
            String str = "*";
            String repeated = new String(new char[SearchedId.length()-2]).replace("\0", str);
            String Vid = SearchedId.substring(0, 2)+repeated;
            System.out.println(Vid);
            req.setAttribute("SearchedId",Vid);
            
            session.invalidate();
            forward.setRedirect(false);
            forward.setPath("/searchIdRes.jsp");
            return forward;
            }catch(Exception e) {
               session.invalidate();
               out.println("<script>alert('회원가입된 이메일이 아닙니다.');location.href=\"searchId.jsp\"</script>");
               return null;
            }
         }
         else { // 인증번호 불일치
            out.println("<script>alert('인증번호를 확인해주세요.');window.history.back();</script>");
            return null;
         }
      }
      else {
         if(searchpw.equals(checkNum)) { // 비밀번호 찾기 인증
            try {
               String searchPwid=(String)session.getAttribute("searchPwid");
               Mb mb = membership.SearchPw(searchPwid,email);
               System.out.println("찾은 pw : "+mb.getMb_pw());
               String SearchedPw = mb.getMb_id();
               session.removeAttribute(email);
               
               String str = "*";
               String repeated = new String(new char[SearchedPw.length()-2]).replace("\0", str);
               String Vid = SearchedPw.substring(0, 2)+repeated;
               System.out.println(Vid);
               req.setAttribute("SearchedPw",Vid);
               
               session.invalidate();
               forward.setRedirect(false);
               forward.setPath("/searchPwRes.jsp");
               return forward;
               }catch(Exception e) {
                  session.invalidate();
                  out.println("<script>alert('아이디 및 이메일을 확인해주세요!');location.href=\"searchPw.jsp\"</script>");
                  return null;
               }
         }
         else { // 인증번호 불일치
            out.println("<script>alert('인증번호를 확인해주세요.');window.history.back();</script>");
            return null;
         }
      }
   }

}