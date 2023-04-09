package com.poly.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.entity.User;
import com.poly.repository.UserRepository;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet(urlPatterns = {"/AccountController","/account/add-acc","/account/delete-acc","/account/detail-acc","/account/update-acc"})
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserRepository ur = new UserRepository();
    private int idt;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if(uri.contains("/AccountServlet")) {
			this.viewAccount(request, response);
		}else if(uri.contains("delete-acc")) {
			this.deleteAccount(request, response);
		}else if(uri.contains("detail-acc")) {
			this.detailAccount(request, response);
		}else {
			this.viewAccount(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if(uri.contains("add-acc")) {
			this.addAccount(request, response);
		}if(uri.contains("update-acc")) {
			this.updateAccount(request, response);
		}
	}
	
	private void viewAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("all_acc",ur.getAll());
		request.setAttribute("link","/views/admin/mange-account.jsp");
		request.getRequestDispatcher("/views/admin/admin-home.jsp").forward(request, response);
	}
	
	private void addAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String email =request.getParameter("email");
		User u = new User(user, pass, name, email, false, true);
		ur.addUser(u);
		response.sendRedirect("/Assignment/admin/account");
	}
	private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ur.delete(Integer.parseInt(id));
		response.sendRedirect("/Assignment/admin/account");
	}
	private void detailAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User u = ur.getOne(Integer.parseInt(id));
		idt = Integer.parseInt(id);
		request.setAttribute("uu", u);
		this.viewAccount(request, response);
	}
	private void updateAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String email =request.getParameter("email");
		User u = new User(idt, user, pass, name, email, false, true);
		ur.updateUser(u);
		this.viewAccount(request, response);
	}
}
