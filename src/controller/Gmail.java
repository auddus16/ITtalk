package controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator { //���̵� �н����� �����ޱ� �Լ�
	  PasswordAuthentication pa;
	  public Gmail(){
	    pa=new PasswordAuthentication("ssikhj1214@gmail.com","@@@");        
	  }
	  @Override
	  protected PasswordAuthentication getPasswordAuthentication() {
	    return pa;
	  }
	}
