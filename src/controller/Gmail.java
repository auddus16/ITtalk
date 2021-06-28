package controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator { //아이디 패스워드 인증받기 함수
	  PasswordAuthentication pa;
	  public Gmail(){
	    pa=new PasswordAuthentication("ssikhj1214@gmail.com","@@@");        
	  }
	  @Override
	  protected PasswordAuthentication getPasswordAuthentication() {
	    return pa;
	  }
	}
