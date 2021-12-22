package exercise.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exercise.register.RegisterServiceImpl;
import exercise.user.UserDAOImpl;
import exercise.user.UserDTO;

public class RegisterAction extends Action {

	public RegisterAction() {
		
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int uid = Integer.parseInt(request.getParameter("uid")); 
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		int amt = Integer.parseInt(request.getParameter("amt"));
		int flag = 1;
	
		RegisterServiceImpl obj = new RegisterServiceImpl();
		obj.setUserDao(new UserDAOImpl());
		if(obj.checkUser(uname)) {
			obj.register(UserDTO.createInstanceWithValues(uid,uname,upass,amt,flag));
			HttpSession session=request.getSession();  
	        session.setAttribute("name",uname); 
			return "register.success";
		}
		return "register.fail";
	}
	
}
