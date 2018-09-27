package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AccountDao;
import models.IssueDao;

@WebServlet("/issue/trend.do")
public class TrendController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IssueDao idao = new IssueDao();
		
		List<Map> list = idao.getAllData();
		for(int i=0; i<list.size(); i++) {
			Map p = list.get(i);
			String ctr = (String)p.get("CONTENT");
			if(ctr.contains("\n")) {
				p.put("REP", ctr.substring(0, ctr.indexOf("\n")));
			}else {
				p.put("REP", ctr);
			}
		}
		
		
		
		req.setAttribute("list", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/trend.jsp"); 
		rd.forward(req, resp);
		
	}
}
