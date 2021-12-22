package exercise.controller;

import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.model.Action;

public class RequestProcessor {

	public void process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			Properties prop = (Properties)request.getAttribute("prop");
			
			String formid=request.getParameter("formid");
			
			String actionClass = prop.getProperty(formid);
			Action action=(Action)Class.forName(actionClass).getConstructor(null).newInstance(null);
			
			System.out.println(actionClass+" "+action);
			String result=action.execute(request, response);
			System.out.println(result);
			String nextPage=prop.getProperty(result);
			
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
