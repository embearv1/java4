package com.poly.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.entity.User;

/**
 * Servlet Filter implementation class Login_Role_Filter
 */
@WebFilter("/admin/*")
public class Login_Role_Filter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public Login_Role_Filter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		User u = (User)httpRequest.getSession().getAttribute("user");
		if(u==null) {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/view-login");
			return;
		}else {
			if(u.isActive()==false) {
				httpRequest.setAttribute("err", "Account is not avaiable");
				return;
			}
			Boolean isAdmin = u.isAdmin();
			if(isAdmin==true){
				chain.doFilter(request, response);
				return;
			}
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/403");
			
		}
	}
	public void destroy() {
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
}
