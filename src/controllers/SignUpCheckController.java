package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

@WebServlet("/signup_check.do")
public class SignUpCheckController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 이 컨트롤러에서 처리결과를 보내는데 ajax의 결과물인 json을 보내야 된다면
		resp.setContentType("application/json;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		if(Math.random()>0.5)
			out.println(true);
		else
			out.println(false);
		
		String id = req.getParameter("id");
		
	
	
	}
}
