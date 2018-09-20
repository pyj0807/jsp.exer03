package handlers;

import java.util.LinkedHashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

//@WebListener//알아서 등록을 해준다
public class ApplicationHandler implements ServletContextListener{	
	// 한글깨짐을 막아줌 @WebListener을 안하면 web.xml에 등록을 해주어야 한다	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		//마이바티스를 하면 try-catch문을 안해도 된다
		
		ServletContext ctx = sce.getServletContext();	
		ctx.setRequestCharacterEncoding("UTF-8");	
		ctx.setAttribute("users", new LinkedHashSet<>());
		
	}
}
