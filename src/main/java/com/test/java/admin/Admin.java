package com.test.java.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/admin/admin.do")
public class Admin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Admin.java
		HttpSession session = req.getSession();
		if(session.getAttribute("auth")==null 
				|| !session.getAttribute("grade").equals("2")) {
			resp.sendRedirect("/auth/index.do");
			System.out.println("쫓겨남");
			return; //흐름 끊기 위한 빈 리턴문(아래쪽 코드 실행하지 않도록)
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/admin.jsp");
		dispatcher.forward(req, resp);
	}
}