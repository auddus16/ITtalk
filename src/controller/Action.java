package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//재사용, 강제성
	ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
