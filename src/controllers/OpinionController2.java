package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.OpinionDao;

public class OpinionController2 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String choice = req.getParameter("choice");
		String ment = req.getParameter("ment");
		String ino = req.getParameter("ino");
		
		Map user = (Map)session.getAttribute("user");
		String talker = (String)user.get("ID");
		
		Map m = new HashMap<>();
		m.put("choice", choice);
		m.put("ment", ment);
		m.put("ino", ino);
		m.put("talker", talker);
		OpinionDao oDao = new OpinionDao();
		int r = oDao.addOne(m);
		System.out.println(m.toString() +"¢¹¢¹¢¹"+r);
		
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(r==1) {
			out.println("{\"rst\":true}");
		}else {
			out.println("{\"rst\":false}");
		}
		
		
	}
	

}
