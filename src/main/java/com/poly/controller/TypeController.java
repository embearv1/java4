package com.poly.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.entity.Type_Video;
import com.poly.dao.TypeDAO;
import com.poly.repository.Type_Repo;

/**
 * Servlet implementation class TypeController
 */
@WebServlet(urlPatterns = {"/TypeController","/type/add-type","/type/view-edit-type","/type/edit-type","/type/delete-type"})
public class TypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TypeDAO tr = new Type_Repo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if(uri.contains("TypeController")) {
			this.hienThiType(request, response);
		}
		if(uri.contains("delete-type")) {
			this.deleteType(request, response);
		}
		if(uri.contains("view-edit-type")) {
			this.detailType(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if(uri.contains("add-type")) {
			this.addType(request, response);
		}
		if(uri.contains("edit-type")) {
			this.updateType(request, response);
		}
	}
	private void hienThiType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("all_type", tr.getAll());
		request.setAttribute("link","/views/admin/admin-type.jsp");
		request.getRequestDispatcher("/views/admin/admin-home.jsp").forward(request, response);
	}
	private void addType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		boolean active = true;
		Type_Video type = new Type_Video(name, active);
		tr.add(type);
		request.setAttribute("alert", "Add Success!");
		//this.hienThiType(request, response);
		response.sendRedirect("/Assignment/admin/type");
	}
	
	private void deleteType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		this.tr.dele(Integer.parseInt(id));
		response.sendRedirect("/Assignment/admin/type");;
	}
	
	private void detailType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Type_Video type = tr.getOne(Integer.parseInt(id));
		request.setAttribute("type",type);
		this.hienThiType(request, response);
	}

	private void updateType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		tr.update(Integer.parseInt(id), name);
		response.sendRedirect("/Assignment/admin/type");
	}
}
