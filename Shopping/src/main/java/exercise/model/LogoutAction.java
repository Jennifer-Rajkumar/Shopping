package exercise.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exercise.login.LoginServiceImpl;
import exercise.user.UserDAOImpl;

public class LogoutAction extends Action {
	
	public LogoutAction() {
		
	}
	
	@Override 
	public String execute(HttpServletRequest request, HttpServletResponse response)  {
		// TODO Auto-generated method stub
		try {
			HttpSession session=request.getSession(false);  

	        String uname=(String)session.getAttribute("name");  
	        System.out.println(uname);
	        session.invalidate();
	        
			LoginServiceImpl obj = new LoginServiceImpl();
			obj.setUserDao(new UserDAOImpl());
			obj.updateFlag(uname, 0);
			return "logout.success";
        }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return "logout.fail";

    }
}
