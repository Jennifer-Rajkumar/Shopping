package exercise.model;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LanguageAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String lang=request.getParameter("lang");
		
		ResourceBundle rb=ResourceBundle.getBundle("exercise.model.Dictionary",new Locale(lang));
		
		HttpSession session=request.getSession();
		
		session.setAttribute("rb", rb);
		
		return "lang.success";
	}
}
