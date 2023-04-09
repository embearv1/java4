package com.poly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.entity.Video;
import com.poly.repository.Type_Repo;
import com.poly.repository.UserRepository;
import com.poly.repository.VideoRepository;

/**
 * Servlet implementation class AdminController
 */
@WebServlet(urlPatterns = {"/admin/home","/admin/logout","/admin/manage-video",
		"/admin/update-video","/admin/view-add-video","/admin/delete-video",
		"/admin/add-video","/admin/view-video","/admin/type","/admin/account"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideoRepository vr = new VideoRepository();
    private Type_Repo tr = new Type_Repo();
    private UserRepository ur = new UserRepository();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		if(uri.contains("home")) {
			request.setAttribute("videoView", vr.getMostView());
			request.setAttribute("videoShare", vr.getMostShare());
			request.setAttribute("link","/views/admin/admin-trangnen.jsp");
			request.getRequestDispatcher("/views/admin/admin-home.jsp").forward(request, response);
		}else if(uri.contains("logout")) {
			session.removeAttribute("user");
			response.sendRedirect("login");
		}else if(uri.contains("manage-video")){
			this.viewAll(request, response);
		}
		else if(uri.contains("view-add-video")){
			this.viewAdd(request, response);
		}
		else if(uri.contains("view-video")){
			response.sendRedirect("/Assignment/all-video");
		}
		else if(uri.contains("type")){
			this.viewType(request, response);
		}
		else if(uri.contains("account")){
			this.viewAccount(request, response);
		}
		else {
			request.setAttribute("link","/views/admin/admin-trangnen.jsp");
			request.getRequestDispatcher("/views/admin/admin-home.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void viewAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Video> ds = vr.getAll();
		int end = ds.size() / 8;
		if (end % 8 != 0) {
			end++;
		}
		List<Video> listPhantrang = new ArrayList<>();
		String i = request.getParameter("index");
		if (i == null || "".equals(i)) {
			i = "1";
		}
		int index = Integer.parseInt(i);
		listPhantrang = vr.getPaging(index);
		request.setAttribute("video", listPhantrang);
		request.setAttribute("end", end);
		request.setAttribute("all_type", tr.getAll());
		request.setAttribute("link","/views/admin/manage-film.jsp");
		request.getRequestDispatcher("/views/admin/admin-home.jsp").forward(request, response);
	}
	
	private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("all_type", tr.getAll());
		request.setAttribute("link","/views/admin/film-add.jsp");
		request.getRequestDispatcher("/views/admin/admin-home.jsp").forward(request, response);
	}
	private void viewType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("all_type", tr.getAll());
		request.setAttribute("link","/views/admin/admin-type.jsp");
		request.getRequestDispatcher("/views/admin/admin-home.jsp").forward(request, response);
	}
	private void viewAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("all_acc",ur.getAll());
		request.setAttribute("link","/views/admin/mange-account.jsp");
		request.getRequestDispatcher("/views/admin/admin-home.jsp").forward(request, response);
	}
	
}
