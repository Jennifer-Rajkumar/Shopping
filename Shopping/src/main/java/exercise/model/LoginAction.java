package exercise.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exercise.login.LoginServiceImpl;
import exercise.user.UserDAOImpl;

public class LoginAction extends Action {

	public LoginAction() {
		
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		LoginServiceImpl obj = new LoginServiceImpl();
		obj.setUserDao(new UserDAOImpl());
		if(obj.checkUser(uname,upass) && obj.checkFlag(uname)) {
			obj.updateFlag(uname, 1);
			HttpSession session=request.getSession();  
	        session.setAttribute("name",uname);  
			return "login.success";
		}
		return "login.fail";
	}

}
