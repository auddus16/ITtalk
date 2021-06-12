package controller;

public class ActionForward {// 방식,경로
	
	private boolean redirect;//방식
	private String path;//경로
	
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
