package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session.do")
public class SessionController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pass =req.getParameter("pass");
		
		if(Math.random()>0.9) {
			HttpSession session = req.getSession();
			session.setAttribute("auth", true);
			resp.sendRedirect(req.getContextPath()+ "/index.do");
		}else {
			req.setAttribute("err", true);	
			// MVC ���� ������ view ��½� ����ؾߵ� �����͸� �����ϴ� ����
			
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(req, resp);
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath()+"/login.do");
	}
	
}







