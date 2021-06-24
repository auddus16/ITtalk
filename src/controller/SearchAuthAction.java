package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import itTalkDAO.Membership;

public class SearchAuthAction implements Action{
	// ������ȣ ����
	public String RandomNum() {
		StringBuffer buffer = new StringBuffer();

		for(int i=0;i<=6;i++) {
			int n=(int) (Math.random()*10);
			buffer.append(n);
		}
		return buffer.toString();
	}


	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		ActionForward forward= new ActionForward();
		String checkNum="";
		
		String fromEmail = "pjiq98346527@gmail.com";
		String fromName="ITtalk ������";
		String toEmail = req.getParameter("mb_email");
		String subject = "���̵�/���ã�⸦ ���� �̸������� �����Դϴ�.";
		HttpSession session=req.getSession();
		
		PrintWriter out=res.getWriter();
		try {	
			checkNum=RandomNum();
			String content = "������ȣ ["+checkNum+"]";
			session.setAttribute("checkNum", checkNum);
			System.out.println("checkNum : "+session.getAttribute("checkNum"));
			session.setAttribute("mb_email", toEmail);
			Properties p = new Properties();
			p.put("mail.smtp.user", fromEmail);
			p.put("mail.smtp.host", "smtp.googlemail.com");
			p.put("mail.smtp.port", "456");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.debug", "true");
			p.put("mail.smtp.socketFactory.port", "465");
			p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.put("mail.smtp.socketFactory.fallback", "false");

			Authenticator myauth=new Gmail(); 
			Session sess=Session.getInstance(p, myauth);


			InternetAddress addr = new InternetAddress();
			addr.setPersonal(fromName,"UTF-8");
			addr.setAddress(fromEmail);


			Message msg = new MimeMessage(sess);
			msg.setFrom(addr);         
			msg.setSubject(MimeUtility.encodeText(subject, "utf-8","B"));
			msg.setContent(content, "text/html;charset=utf-8");
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

			
			Transport.send(msg);
			
			
			System.out.println("������ ���۵Ǿ����ϴ�.");
			out.println("<script>alert('���� ������ ���۵Ǿ����ϴ�.');<script>");
			String searchPwid = req.getParameter("mb_id");
			if(searchPwid==null) {
				forward.setRedirect(false);
				forward.setPath("/SearchIdAuth.jsp");
				return forward;
			}
			else {
				session.setAttribute("searchPwid", searchPwid);
				forward.setRedirect(false);
				forward.setPath("/SearchPwAuth.jsp");
				return forward;
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<script>alert('������ �߻��߽��ϴ�..');history.back();<script>");

			return null;
		}
	}

}
