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
      String authNum = req.getParameter("authNum"); // �Է¹��� ȸ������ ������ȣ
      String searchid = req.getParameter("searchidAuth"); // �Է¹��� ���̵� ã�� ������ȣ
      String searchpw = req.getParameter("searchPwAuth"); // �Է¹����� ��й�ȣ ã�� ������ȣ
      System.out.println("�Է¹��� �̸��� : " + email);
      System.out.println("�Է¹��� ȸ������ ������ȣ : "+authNum);
      System.out.println("�Է¹��� ã�� ������ȣ : "+searchid);
      String checkNum=(String) session.getAttribute("checkNum"); // ��Ʈ�ѷ��� ������ ������ȣ
      System.out.println("��Ʈ�ѷ� ���� ������ȣ : "+checkNum);
      
      PrintWriter out=res.getWriter();
      if(authNum!=null) {   // ȸ������ ����
         if(authNum.equals(checkNum)) { // ȸ������ ������ȣ ��ġ
            boolean authcheck = authNum.equals(checkNum);
            req.setAttribute("authcheck", authcheck);
            forward.setRedirect(false);
            forward.setPath("/authCheckProc.jsp");
            return forward;
         }
         else { // ������ȣ ����ġ
            out.println("<script>alert('������ȣ�� Ȯ�����ּ���.');window.history.go(-1);</script>");
            return null;
         }
      }
      else if(searchid!=null){ // ���̵�ã�� ����
         if(searchid.equals(checkNum)) { // ���̵�ã�� ������ȣ ��ġ
            
            try {
            Mb mb = membership.SearchId(email);
            System.out.println("ã�� id : "+mb.getMb_id());
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
               out.println("<script>alert('ȸ�����Ե� �̸����� �ƴմϴ�.');location.href=\"searchId.jsp\"</script>");
               return null;
            }
         }
         else { // ������ȣ ����ġ
            out.println("<script>alert('������ȣ�� Ȯ�����ּ���.');window.history.back();</script>");
            return null;
         }
      }
      else {
         if(searchpw.equals(checkNum)) { // ��й�ȣ ã�� ����
            try {
               String searchPwid=(String)session.getAttribute("searchPwid");
               Mb mb = membership.SearchPw(searchPwid,email);
               System.out.println("ã�� pw : "+mb.getMb_pw());
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
                  out.println("<script>alert('���̵� �� �̸����� Ȯ�����ּ���!');location.href=\"searchPw.jsp\"</script>");
                  return null;
               }
         }
         else { // ������ȣ ����ġ
            out.println("<script>alert('������ȣ�� Ȯ�����ּ���.');window.history.back();</script>");
            return null;
         }
      }
   }

}