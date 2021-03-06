package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class JDBCInitListener
 *
 */
@WebListener
public class JDBCInitListener implements ServletContextListener {

	/**
	 * Default constructor. 
	 */
	public JDBCInitListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce)  { 
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce)  { 

		ServletContext application = sce.getServletContext();

		String url = application.getInitParameter("jdbcUrl");
		String user = application.getInitParameter("jdbcUser");
		String password = application.getInitParameter("jdbcPassword");

		System.out.println(url);
		System.out.println(user);
		System.out.println(password);

		//1.클래스 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//2.drivermanager에서 connection

		//3.close();
		try(
				Connection con = DriverManager.getConnection(url, user, password);
				) {
			System.out.println("실행 됨.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConnectionProvider.setUrl(url);
		ConnectionProvider.setUser(user);
		ConnectionProvider.setPassword(password);
		
		// context root 경로
		String contextPath = application.getContextPath();
		application.setAttribute("root", contextPath);
	}
	

}
