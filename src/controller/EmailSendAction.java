package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailSendAction implements Action{
	
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
		String authNum="";
		
		String host = "stmt.gmail.com";
		String from = "pjiq98346527@gmail.com";
		String to = req.getParameter("mb_email");
		String subject = "회원가입을 위한 이메일인증 확인 메일입니다.";
		authNum=RandomNum();
		String content = "인증번호 ["+authNum+"]";
		
		Properties p = new Properties();
		p.put("mail.smtp.user", from);
		p.put("mail.smtp.host", "smtp.googlemail.com");
		p.put("mail.smtp.port", "456");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");

		try {
			   Authenticator auth = new Gmail();
			   Session ses = Session.getInstance(p, auth);
			   ses.setDebug(true);
			   MimeMessage msg = new MimeMessage(ses);
			   msg.setSubject(subject);
			   Address fromAddr = new InternetAddress(from);
			   msg.setFrom(fromAddr);
			   Address toAddr = new InternetAddress(to);
			   msg.addRecipient(Message.RecipientType.TO, toAddr);
			   msg.setContent(content, "text/html;charset=UTF8");
			   Transport.send(msg);
			   
		   } catch (Exception e) {
			   e.printStackTrace();
			   PrintWriter script = res.getWriter();
			   script.println("<script>");
			   script.println("alert('오류가 발생했습니다..');");
			   script.println("history.back();");
			   script.println("</script>");
			   script.close();
			   
			   return null;
		   }

		return null;
	}

}
