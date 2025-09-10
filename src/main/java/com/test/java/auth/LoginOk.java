package com.test.java.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.java.model.AuthDAO;
import com.test.java.model.UserDTO;

@WebServlet(value = "/auth/loginok.do")
public class LoginOk extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//LoginOk.java
		
		//서블릿에서 세션을 얻어오는 방법
		HttpSession session = req.getSession();
		
		//1.
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		//2.
		AuthDAO dao = new AuthDAO();
		
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setPw(pw);
		
		UserDTO result = dao.login(dto);
		
		//실제 인증 티켓 발급 부분
		if (result != null) {
			//로그인 성공
			
			//인증 티켓 발급
			session.setAttribute("auth", id);
			session.setAttribute("name", result.getName());
			session.setAttribute("grade", result.getGrade());
			
		} else {
			//로그인 실패
		}
		
		//피드백
		if (result != null) {
			resp.sendRedirect("/auth/index.do");
//			resp.sendRedirect("/index.do");
		} else {
			PrintWriter writer = resp.getWriter();
			
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			writer.close();
		}
		
		
	}
}