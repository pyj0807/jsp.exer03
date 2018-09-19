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
		
		List<Map> list = idao.getAllDatas();
		if(list.size() == 0) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/");
		}else {
			
		}
		
	}
}
