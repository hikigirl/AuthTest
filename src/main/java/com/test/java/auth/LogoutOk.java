package com.test.java.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/auth/logoutok.do")
public class LogoutOk extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//LogoutOk.java
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/auth/logoutok.jsp");
		dispatcher.forward(req, resp);
	}
}