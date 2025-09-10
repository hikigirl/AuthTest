package com.test.java.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/auth/logoutok.do")
public class LogoutOk extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//LogoutOk.java
		HttpSession session = req.getSession();
		
		//인증 티켓 제거 = 세션에 담아놓은 모든 정보 제거
//		session.removeAttribute("auth");
//		session.removeAttribute("name");
//		session.removeAttribute("grade");
		
		//세션을 버리고 새로 만듬, 일괄적으로 날리는것도 가능..
		session.invalidate(); 
		
		resp.sendRedirect("/auth/index.do");
	}
}