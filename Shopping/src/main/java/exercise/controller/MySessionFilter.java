package exercise.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet Filter implementation class MySessionFilter
 */
@WebFilter(
		
		urlPatterns = {"*.do"}
		
		)
public class MySessionFilter implements Filter {
	public void destroy() {
		System.out.println("filter destroy called...");
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest=(HttpServletRequest)request;
		HttpServletResponse hresponse=(HttpServletResponse)response;
		
		HttpSession session=hrequest.getSession();
		String formid=request.getParameter("formid");
		if(session.isNew()) {
			if(formid.equals("login")) {
				chain.doFilter(request, response);
			}
			else {
				hresponse.sendRedirect("expiry.jsp");
			}
		}
		else {
			chain.doFilter(request, response);
		}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter init called...");
	}
}