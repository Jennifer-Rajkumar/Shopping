package exercise.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import exercise.login.LoginServiceImpl;
import exercise.user.UserDAOImpl;
/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@WebListener
public class MySessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se)  {
         System.out.println("session created....");
    }
	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  {
         System.out.println("session destroyed...");
         //you have to write the logic of changing the flag in DB to zero
         HttpSession session=se.getSession();
         String uname=(String)session.getAttribute("name");
          
 	     session.invalidate();
 	        
 		 LoginServiceImpl obj = new LoginServiceImpl();
 		 obj.setUserDao(new UserDAOImpl());
 		 obj.updateFlag(uname, 0);
    }
	
}