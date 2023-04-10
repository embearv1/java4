package com.poly.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.poly.constant.SessionAtri;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.option.AuthenticationMail;
import com.poly.dao.HistoryDAO;
import com.poly.repository.HistoryRepository;
import com.poly.dao.VideoDAO;
import com.poly.repository.VideoRepository;

/**
 * Servlet implementation class VideoController
 */
@WebServlet(urlPatterns = { "/home", "/all-video", "/video/detail", "/video/blog", "/video/like", "/video/my-history",
		"/video/favorite", "/video/view-share", "/video/share" })
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private VideoDAO vr = new VideoRepository();
	private HistoryDAO hr = new HistoryRepository();
	private AuthenticationMail atm = new AuthenticationMail();
	private String linkVideo;
	private int idvd;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoController() {
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
		if (uri.contains("all-video")) {
			this.hienthi(request, response);
		} else if (uri.contains("detail")) {
			this.detail(session, request, response);

		} else if (uri.contains("blog")) {
			this.hienthiBlog(request, response);
		} else if (uri.contains("home")) {
			this.homepage(request, response);
		} else if (uri.contains("like")) {
			this.likeVideo(session, request, response);
		} else if (uri.contains("my-history")) {
			this.history(session, request, response);
		} else if (uri.contains("favorite")) {
			this.myfavorite(session, request, response);
		} else if (uri.contains("view-share")) {
			this.viewShareVideo(session, request, response);
		} else {
			this.homepage(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		if (uri.contains("share")) {
			this.shareVideo(session, request, response);
		}
	}

	private void hienthi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		request.setAttribute("view", "/views/movie.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void hienthiBlog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("view", "/views/blog.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
//		request.getRequestDispatcher("/views/blog.jsp").forward(request, response);
	}

	private void detail(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			this.homepage(request, response);
			return;
		}
		Video vd = this.vr.getOne(Integer.parseInt(id));
		vr.setView(vd.getId(), vd.getView());
		User u = (User) session.getAttribute(SessionAtri.Current_User);
		if (u != null) {
			History hisCheck = hr.checkHis(u.getId(), vd.getId());
			System.out.println(hisCheck);
			Date date = new Date(Calendar.getInstance().getTime().getTime());
			if (hisCheck != null) {
				History h2 = new History(u, vd, date, hisCheck.getIslike(), hisCheck.getLikeDate());
				hr.setHistory(h2);
				request.setAttribute("liked", hisCheck.getIslike());
			} else {
				History his1 = new History(u, vd, date, false, null);
				hr.setHistory(his1);
				request.setAttribute("liked", false);
			}
		}

		request.setAttribute("video", vd);
		request.setAttribute("view", "/views/about-film.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
//		request.getRequestDispatcher("/views/about-film.jsp").forward(request, response);

	}

	private void homepage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> ds = vr.getMostView();
		List<Video> ds_like = vr.getNewVideo();
		request.setAttribute("_list", ds);
		request.setAttribute("_ds", ds_like);
		request.setAttribute("view", "/views/home.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void likeVideo(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = (User) session.getAttribute(SessionAtri.Current_User);
		String id = request.getParameter("id");
		Video vd = this.vr.getOne(Integer.parseInt(id));
		if (u == null) {
			response.sendRedirect("/Assignment/login");
		} else {
			Date date = new Date(Calendar.getInstance().getTime().getTime());
			History hisCheck = hr.checkHis(u.getId(), Integer.parseInt(id));
			if (hisCheck.getIslike() == true) {
				hr.updateDisLikeHistory(u.getId(), vd.getId());
				request.setAttribute("liked", false);
			} else {
				/* Video vd = this.vr.getOne(Integer.parseInt(id)); */
				History his1 = new History(u, vd, date, true, date);
				hr.setHistory(his1);
				request.setAttribute("liked", true);
			}
			vr.setView(vd.getId(), vd.getView() - 2);
//			request.setAttribute("view", "/video/detail?id=" + id);
			this.detail(session, request, response);
//			response.sendRedirect("/Assignment/video/detail?id=" + id);
		}
	}

	private void history(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = (User) session.getAttribute(SessionAtri.Current_User);
		List<History> ds = hr.getHistoryByUser(u.getId());
		request.setAttribute("videohis", ds);
		request.setAttribute("view", "/views/history.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
//		request.getRequestDispatcher("/views/history.jsp").forward(request, response);
	}

	private void myfavorite(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = (User) session.getAttribute(SessionAtri.Current_User);
		List<Video> ds = hr.getLikedByUser(u.getId());
		request.setAttribute("videolike", ds);
//		request.getRequestDispatcher("/views/myfavarite.jsp").forward(request, response);
		request.setAttribute("view", "/views/myfavarite.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void viewShareVideo(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = (User) session.getAttribute("user");
		if (u == null) {
			response.sendRedirect("/Assignment/login");
		} else {
			linkVideo = request.getParameter("link");
			request.setAttribute("view", "/views/shareVideo.jsp");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	private void shareVideo(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User u = (User) session.getAttribute("user");
		String sendmail = u.getEmail();
		String title = "From:" + sendmail + "" + "-send you video";
		String about = "https://www.youtube.com/watch?v=" + linkVideo;
		String reciveMail = request.getParameter("email");
		atm.adminMail(request, response, reciveMail, title, about);
		Video vd = vr.getVideoByUrl(linkVideo);
		vr.setShare(vd.getView(), vd.getShare(), vd.getId());
		/* hr.updateShare(u.getId(),vd.getId()); */
		this.hienthi(request, response);
	}

}
