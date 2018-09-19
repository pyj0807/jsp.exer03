package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/index.do")
public class IndexController extends HttpServlet {
	/*
	 * ����� ��û�� ���ؼ� �۵����Ѿ� �� �۾���
	 * 		service(HttpServletRequest , HttpServletResponse arg1) : get�� post ó�� 
	 * 		doGet(HttpServletRequest , HttpServletResponse arg1) : get�� ó���ǰ�
	 * 		doPost(HttpServletRequest , HttpServletResponse arg1) : post�� ó����.
	 * 
	 * 	�� �����߿� �ϳ��� �̿��ؼ� �����صθ� �ȴ�
	 * 		
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("auth") == null) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/guest.jsp");
			/*
			 * MVC ����� response �� �����ϱ� ���ؼ� 
			 * �����ϴ� jsp ������ WebContent �ٷ� �Ʒ����ٴ�
			 * WEB-INF ������ ���踦 �صδ� ���̴�. 
			 * ���� ���� ������ �ɸ��� ��ζ� ��� ����ϴ� ���� ��ȣ�� ����. 
			 */
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/home.jsp");
			rd.forward(req, resp);
		}
	}
}











