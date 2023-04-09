package com.poly.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class ManyLanguege
 */
@WebFilter(urlPatterns = {"/home","/video/*","/all-video"}, dispatcherTypes = DispatcherType.REQUEST)
public class ManyLanguege extends HttpFilter implements Filter {
	private static final String LANG_DEFAULT = "en";
	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public ManyLanguege() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String lang = httpRequest.getParameter("language");
		
		if(lang != null && !"".equals(lang)) {
			httpRequest.getSession().setAttribute("language", lang);
		} else {
			httpRequest.getSession().setAttribute("language", LANG_DEFAULT);
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
