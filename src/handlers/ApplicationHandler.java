package handlers;

import java.util.LinkedHashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

//@WebListener//�˾Ƽ� ����� ���ش�
public class ApplicationHandler implements ServletContextListener{	
	// �ѱ۱����� ������ @WebListener�� ���ϸ� web.xml�� ����� ���־�� �Ѵ�	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		//���̹�Ƽ���� �ϸ� try-catch���� ���ص� �ȴ�
		
		ServletContext ctx = sce.getServletContext();	
		ctx.setRequestCharacterEncoding("UTF-8");	
		ctx.setAttribute("users", new LinkedHashSet<>());
		
	}
}
