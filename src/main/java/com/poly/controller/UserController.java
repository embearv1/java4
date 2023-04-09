package com.poly.controller;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.constant.SessionAtri;
import com.poly.entity.User;
import com.poly.option.AuthenticationMail;
import com.poly.repository.UserRepository;

/**
 * Servlet implementation class UserController
 */
@WebServlet(urlPatterns = { "/view-login", "/view-signup", "/view-forget", "/login", "/sign-up", "/forget", "/logout",
		"/my-profile" ,"/change-pass"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository ur = new UserRepository();
	AuthenticationMail Au_mail = new AuthenticationMail();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		if (uri.contains("view-login")) {
			this.viewLogin(request, response);
		} else if (uri.contains("view-signup")) {
			this.viewRegister(request, response);
		} else if (uri.contains("view-forget")) {
			this.viewForget(request, response);
		} else if (uri.contains("logout")) {
			session.removeAttribute(SessionAtri.Current_User);
			response.sendRedirect("login");
		} else if (uri.contains("my-profile")) {
			this.myProfile(session,request, response);
		} 
		else {
			this.viewLogin(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		if (uri.contains("login")) {
			this.login(session, request, response);
		}
		 if (uri.contains("change-pass")) {
			this.Changepass(session, request, response);
		} 
		if (uri.contains("sign-up")) {
			this.sign_up(request, response);
		}
		if(uri.contains("forget")) {
			this.forgetPass(request, response);
		}
	}

	public void viewLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	public void viewRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/sign-up.jsp").forward(request, response);
	}

	public void viewForget(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/forget.jsp").forward(request, response);
	}

	public void login(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		User u = ur.checkLogin(user, pass);
		if (u != null) {
			session.setAttribute(SessionAtri.Current_User, u);
			Boolean isAdmin = u.isAdmin();
			if(isAdmin==true){
				response.sendRedirect("admin/home");
			}else {
				response.sendRedirect("all-video");
			}
		} else {
			request.setAttribute("err", "Please check your input user or password");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			
		}
	}

	public void sign_up(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		String mail = request.getParameter("mail");
		if (!pass.equals(repass)) {
			request.setAttribute("err", "Password is not correct");
			request.getRequestDispatcher("/views/sign-up.jsp").forward(request, response);
		} else {
			request.setAttribute("err", "Password is not correct");
			User u = new User(0, user, pass, "", mail, false, true);
			ur.addUser(u);
			response.sendRedirect("login");
		}
	}
	
	public void myProfile(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = (User) session.getAttribute(SessionAtri.Current_User);
		request.setAttribute("user", u);
		request.getRequestDispatcher("/views/myprofile.jsp").forward(request, response);
	}
	public void Changepass(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = (User) session.getAttribute(SessionAtri.Current_User);
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		String oldpass = request.getParameter("oldpass");
		if(!u.getPass().equals(oldpass)) {
			session.setAttribute("err", "Please check your old password");
			request.getRequestDispatcher("/views/myprofile.jsp").forward(request, response);
		}else {
		if(!pass.equals(repass)) {
			session.setAttribute("err", "Please check your password");
			request.getRequestDispatcher("/views/myprofile.jsp").forward(request, response);
		}else {
			ur.updatePass(u.getId(), pass);
			this.myProfile(session, request, response);
		}
		}
		
	}
	public void forgetPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String emailTo = request.getParameter("email");
		User u = ur.checkForget(user, emailTo);
		if(u!=null) {
			ur.resetPass(user);;
			Au_mail.adminMail(request, response,emailTo,"Your New Password","123@");
			response.sendRedirect("login");
		}else {
			request.setAttribute("err", "Please Check your email or user name!");
			request.getRequestDispatcher("/views/forget.jsp").forward(request, response);
		}
	}
	

}
