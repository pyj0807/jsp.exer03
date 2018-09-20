package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.google.gson.Gson;

import models.OpinionDao;

@WebServlet("/issue/opinion.do")
public class OpinionController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ino 값을 parameter 넘겨줬을때 그 ino로 등록된 opinion들 뽑아서
		// JSON으로 응답보내게 이 컨크롤러의 get을 구현
		int ino = Integer.parseInt(req.getParameter("ino"));
		OpinionDao odao = new OpinionDao();
		List<Map> li = odao.getSomeByIno(ino);
		Gson gson = new Gson();
		String json = gson.toJson(li);
		resp.setContentType("application/json.;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(json);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getContentType());
		BufferedReader br = req.getReader();
		String line = br.readLine();
		System.out.println(line);
		Gson gson = new Gson();
		Map map =gson.fromJson(line, Map.class);
		
		System.out.println(map);
		HttpSession session = req.getSession();

		
		String talker = (String)session.getAttribute("id");
		
		map.put("talker", talker);
		OpinionDao oDao = new OpinionDao();
		int r = oDao.addOne(map);
		System.out.println(map.toString() +"▷▷▷"+r);
		
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(r==1) {
			out.println("{\"rst\":true}");
		}else {
			out.println("{\"rst\":false}");
		}
		
		
	}
	

}
