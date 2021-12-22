package exercise.model;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exercise.item.ItemDAOImpl;
import exercise.login.LoginServiceImpl;
import exercise.shopping.ShoppingServiceImpl;
import exercise.user.UserDAOImpl;

public class ShoppingAction extends Action {

	public ShoppingAction() {
		
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String shopid = request.getParameter("shopid");
		
		HttpSession session=request.getSession();    
        
		Enumeration<String> e = request.getParameterNames();
		while(e.hasMoreElements()) {
			String name=e.nextElement();
			String value=request.getParameter(name);
			session.setAttribute(name, value);
		}
		return shopid;
	}

}
