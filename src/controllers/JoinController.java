package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.AccountDao;

@WebServlet("/join.do")
public class JoinController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("id","");
		req.setAttribute("pass","");
		req.setAttribute("name","");
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/join.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		
		Map map = new HashMap<>();
			map.put("id", id);
			map.put("pass", pass);
			map.put("name", name);
			map.put("gender", gender);
		
		AccountDao adao = new AccountDao();
		int t = adao.addAccount(map);
		
		
		if(t == 1) {
			HttpSession session = req.getSession();
			session.setAttribute("auth", true);
			
		}else {
			resp.sendRedirect(req.getContextPath()+ "/index.do");
			
		}
	
		
	
	}
}
