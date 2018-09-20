package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.IssueDao;

@WebServlet("/issue/new.do")
public class NewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("µé¾î¿È?");
		
		req.setAttribute("content", "");
		req.setAttribute("agree", "");
		req.setAttribute("disagree", "");
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/new.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String cate = req.getParameter("cate");
		String content = req.getParameter("content");
		String agree = req.getParameter("agree");
		String disagree = req.getParameter("disagree");
		
		Map map = new HashMap<>();
			map.put("cate", cate);
			map.put("content", content);
			map.put("agree", agree);
			map.put("disagree", disagree);
			map.put("writer", session.getAttribute("id"));
		
		IssueDao idao = new IssueDao();
		int t = idao.addData(map);
		if(t == 1) {
			session.setAttribute("cate", cate);
			session.setAttribute("content", content);
			session.setAttribute("agree", agree);
			session.setAttribute("disagree", disagree);
			resp.sendRedirect(req.getContextPath()+"/issue/trend.do");
		}else {
			req.setAttribute("fail", true);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/new.jsp");
			rd.forward(req, resp);
		}
		
		
	}
}
