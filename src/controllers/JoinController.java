package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AccountDao;

@WebServlet("/join.do")
public class JoinController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath()+"/views/login.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		
		AccountDao adao = new AccountDao();
		
		Map map = new HashMap<>();
			map.put("id", id);
			map.put("pass", pass);
			map.put("name", name);
			map.put("gender", gender);
		
			
		int t = adao.adddata(map);
		HttpSession session = req.getSession();
		
		if(t == 1) {
			session.setAttribute("auth", true);
			resp.sendRedirect(req.getContextPath()+ "/index.do");
		}else {
			
		}
		
		
	
	}
}
