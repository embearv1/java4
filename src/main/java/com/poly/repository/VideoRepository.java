package com.poly.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.swing.text.View;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.poly.config.HibernateConfig;
import com.poly.entity.History;
import com.poly.entity.Video;

public class VideoRepository {
	public List<Video> getAll(){
		List<Video> ds = new ArrayList<>();
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Query query = session.createQuery("From Video where active=:id");
			query.setParameter("id", true);
			ds = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	
	public List<Video> getPaging(int index) {
		List<Video> ds = new ArrayList<>();
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			int pageSize = 8; // Số bản ghi trên mỗi trang
			int start = (index - 1) * pageSize; // Vị trí bắt đầu
			String sql ="SELECT * FROM Video  where active=:id ORDER BY id DESC OFFSET :start ROWS FETCH NEXT 8 ROWS ONLY";
			Query query = session.createNativeQuery(sql, Video.class);
			query.setParameter("id", true);
			query.setParameter("start",start);
			ds = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	
	public Video getOne(int id) {
		Video vd = null;
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Query query = session.createQuery("From Video where id=:id");
			query.setParameter("id", id);
			vd = (Video) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return vd;
	}
	public void setView(int id,int view) {
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Transaction tran = session.beginTransaction();
			Query query = session.createQuery("Update Video set view=:view where id=:id");
			query.setParameter("view", view+1);
			query.setParameter("id", id);
			query.executeUpdate();
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
//	public void setLike(int idvideo,int iduser) {
//		try (Session session = HibernateConfig.getFACTORY().openSession()){
//			Transaction tran = session.beginTransaction();
//			Query query = session.createQuery("Update Video set view=:view where id=:id");
////			query.setParameter("id", id);
//			query.executeUpdate();
//			tran.commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
	
	public List<Video> getMostView() {
		List<Video> ds= new ArrayList<>();
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Query query = session.createQuery("From Video Where active=:id order by view desc");
			query.setParameter("id", true);
			query.setMaxResults(6);
			ds = query.getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	public List<Video> getMostLike() {
		List<Video> ds= new ArrayList<>();
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			String sql =  "select * from Video v where v.id in \r\n"
					+ "			 (select top 3 id_video from History his where his.isLiked = 1 \r\n"
					+ "			 group by id_video \r\n"
					+ "			 order by count(distinct id_user) desc)\r\n";
//			======================================================================
			String hql ="select v from Video v where v.id in \r\n"
					+ "(select h.video.id from History h where h.islike = true \r\n"
					+ "group by h.video.id \r\n"
					+ "order by count(distinct h.user.id) desc)";
			Query query = session.createSQLQuery(hql);
			query.setMaxResults(3);
			ds = query.getResultList();
			System.out.println(ds.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	
	public List<Video> getNewVideo() {
		List<Video> ds= new ArrayList<>();
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Query query = session.createQuery("From Video Where active=:id order by id desc");
			query.setParameter("id", true);
			query.setMaxResults(3);
			ds = query.getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	
	
	public Video getVideoByUrl(String href) {
		try (Session session = HibernateConfig.getFACTORY().openSession()) {
			Query query =session.createQuery("From Video where href=:href");
			query.setParameter("href",href);
			Video v = (Video) query.getSingleResult();
			return v;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public void setShare(int view,int share,int id) {
		try (Session session = HibernateConfig.getFACTORY().openSession()) {
			Transaction tran = session.beginTransaction();
			Query query =session.createQuery("Update Video set share=:x,view=:y where id=:id");
			query.setParameter("y", view-2);
			query.setParameter("x", share+1);
			query.setParameter("id", id);
			query.executeUpdate();
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Video> getMostShare(){
		List<Video> ds = new ArrayList<>();
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Query query = session.createQuery("From Video where active=:id Order By share desc");
			query.setParameter("id", true);
			query.setMaxResults(4);
			ds = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	
}
