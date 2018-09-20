package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.IssueDao;
import models.OpinionDao;

@WebServlet("/issue/detail.do")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no"));
		IssueDao idao = new IssueDao();
		OpinionDao odao = new OpinionDao();
		List<Map> opinions = odao.getSomeByIno(no);
		Map a = idao.getOneByNo(no);
		if (a == null) {
			resp.sendRedirect(req.getContextPath() + "/issue/trend.do");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/detail.jsp");
			req.setAttribute("issue", a);
			req.setAttribute("opinions", opinions);
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String choice = req.getParameter("choice");
		String ment = req.getParameter("coment");
		Number ino = (Number)session.getAttribute("ino");
		String talker = (String)session.getAttribute("id");
				
		Map m = new HashMap<>();
		m.put("choice", choice);
		m.put("ment", ment);
		m.put("ino", ino);
		m.put("talker", talker);
		
		
		resp.setContentType("application.json;charset=utf-8");
		OpinionDao oDao = new OpinionDao();
		PrintWriter out = resp.getWriter();
		System.out.println( choice + "  /  " +ment + " / " + ino + " / " +  talker);
	}
}
