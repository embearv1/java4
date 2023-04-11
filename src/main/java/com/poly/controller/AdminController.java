package com.poly.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.entity.Type_Video;
import com.poly.entity.Video;
import com.poly.dao.TypeDAO;
import com.poly.repository.Type_Repo;
import com.poly.dao.UserDAO;
import com.poly.repository.UserRepository;
import com.poly.dao.VideoDAO;
import com.poly.repository.VideoRepository;


/**
 * Servlet implementation class AdminController
 */
@MultipartConfig
@WebServlet(urlPatterns = {"/admin/home","/admin/logout","/admin/manage-video",
		"/admin/update-video","/admin/view-add-video","/admin/delete-video",
		"/admin/add-video","/admin/view-video","/admin/type","/admin/account","/admin/view-update-video"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideoDAO vr = new VideoRepository();
    private TypeDAO tr = new Type_Repo();
    private UserDAO ur = new UserRepository();
    private int idvd;
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
		else if(uri.contains("delete-video")){
			this.deleteVideo(request, response);
		}
		else if(uri.contains("type")){
			this.viewType(request, response);
		}else if(uri.contains("view-update-video")){
			this.viewDetail(request, response);
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
		String uri = request.getRequestURI();
		if(uri.contains("add-video")) {
			this.addfilm(request, response);
		}
		else if(uri.contains("update-video")) {
			this.updateVideo(request, response);
		}else {
			this.viewAll(request, response);
		}
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
	
	private void deleteVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		vr.deleteVideo(Integer.parseInt(id));
		this.viewAll(request, response);
	}
	
	private void addfilm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Video vd = new Video();
		String fileNameRandom = "default.png";
		Part part = request.getPart("poster");
		String fileName = part.getSubmittedFileName();
		fileNameRandom = UUID.randomUUID() + ".png";

		String uploadFile = "/upload/" + fileNameRandom;

		String uploadDirectory = getServletContext().getRealPath("/upload");
		File uploadDir = new File(uploadDirectory);
		if (!uploadDir.exists()) { // Kiểm tra nếu thư mục upload chưa tồn tại thì tạo nó
		    uploadDir.mkdir();
		}
		String filePath = uploadDirectory + File.separator + fileNameRandom; // Đường dẫn tuyệt đối đến tệp được tải lên
		part.write(filePath);
		vd.setPoster(uploadFile);
		String type_id =request.getParameter("type");
		Type_Video type = tr.getOne(Integer.parseInt(type_id));
		vd.setType(type);
		vd.setActive(true);
		vd.setListhis(null);
		vd.setHref(request.getParameter("href"));
		vd.setDescrip(request.getParameter("descrip"));
		try {
			BeanUtils.populate(vd,request.getParameterMap());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		vr.addVideo(vd);
		this.viewAll(request, response);
	}
	
	private void viewDetail (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		Video vd= vr.getOne(Integer.parseInt(id));
		idvd =Integer.parseInt(id);
		request.setAttribute("v",vd);
		this.viewAll(request, response);
	}
	private void updateVideo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video vd_detail = vr.getOne(idvd);
		Video vd = new Video();
		String fileNameRandom = "default.png";
		Part part = request.getPart("poster");
		String fileName = part.getSubmittedFileName();
		fileNameRandom = UUID.randomUUID() + ".png";

		String uploadFile = "/upload/" + fileNameRandom;
		String uploadDirectory = getServletContext().getRealPath("/upload");
		
		System.out.println("Upload directory: " + uploadDirectory);
		File uploadDir = new File(uploadDirectory);
		
		System.out.println("Upload directory is writable: " + uploadDir.canWrite());
		if (!uploadDir.exists()) { // Kiểm tra nếu thư mục upload chưa tồn tại thì tạo nó
		    uploadDir.mkdir();
		}
		String filePath = uploadDirectory + File.separator + fileNameRandom; // Đường dẫn tuyệt đối đến tệp được tải lên
		
		if(fileName==null || ("").equals(fileName)) {
			vd.setPoster(vd_detail.getPoster());
		}else {
			try {
			    part.write(filePath);
			    vd.setPoster(uploadFile);
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
		
		vd.setId(idvd);
		String type_id =request.getParameter("type");
		Type_Video type = tr.getOne(Integer.parseInt(type_id));
		vd.setType(type);
		vd.setActive(true);
		vd.setListhis(null);
		vd.setHref(request.getParameter("href"));
		vd.setDescrip(request.getParameter("descrip"));
		try {
			BeanUtils.populate(vd,request.getParameterMap());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		vr.updateVideo(vd);
		this.viewAll(request, response);
	}
}
