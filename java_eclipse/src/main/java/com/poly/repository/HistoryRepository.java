package com.poly.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.poly.config.HibernateConfig;
import com.poly.dao.HistoryDAO;
import com.poly.entity.History;
import com.poly.entity.Video;

public class HistoryRepository implements HistoryDAO {
	
	@Override
	public History checkHis(int userId, int videoId ) {
		History his = null;
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Query query = session.createQuery("From History where user.id=:userid and video.id=:videoid order by id desc");
			query.setParameter("userid", userId);
			query.setParameter("videoid", videoId);
			query.setMaxResults(1);
			his = (History) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return his;
	}
	
	@Override
	public void updateDisLikeHistory(int userId, int videoId ) {
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Transaction tran = session.beginTransaction();
			Query query = session.createQuery("Update History set islike=:like where user.id=:userid and video.id=:videoid");
			query.setParameter("like", false);
			query.setParameter("userid", userId);
			query.setParameter("videoid", videoId);
			query.executeUpdate();
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public void setHistory(History his) {
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Transaction tran = session.beginTransaction();
			session.save(his);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean likeVideo(int userId, int videoId,boolean like, Date ng) {
		
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Transaction tran = session.beginTransaction();
			String hql ="Update History set islike=:like ,likeDate=:likedate where user.id =:userid and video.id =:videoid";
			Query query = session.createQuery(hql);
			query.setParameter("like",like);
			query.setParameter("likedate",ng);
			query.setParameter("userid",userId);
			query.setParameter("videoid",videoId);
			query.executeUpdate();
			tran.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<History> getHistoryByUser(int userId){
		List<History> ds = new ArrayList<>();
		try(Session session = HibernateConfig.getFACTORY().openSession()){
			String hql ="FROM History h WHERE h.viewDate IN (SELECT MAX(h2.viewDate)"
					+ " FROM History h2 WHERE h2.user.id = :userid GROUP BY h2.video.id) ORDER BY h.viewDate DESC";
			//String hql = "From History where user.id=:userid order by viewDate desc";
			Query query = session.createQuery(hql);
			query.setParameter("userid", userId);
			ds = query.getResultList();
		}
		return ds;
	}
	@Override
	public List<Video> getLikedByUser(int userId){
		List<Video> videos = new ArrayList<>();
	    try (Session session = HibernateConfig.getFACTORY().openSession()) {
	        Query query = session.createQuery("SELECT DISTINCT history.video FROM History history "
	        		+ "WHERE history.user.id = :userId AND history.islike = true AND history.video.active=true "
	        		+ "ORDER BY history.video.title DESC");
	        query.setParameter("userId", userId);
	        videos = query.getResultList();
	    }
	    return videos;
	}

	@Override
	public void updateShare(int idu, int idvd) {
//		Date date = new Date(Calendar.getInstance().getTime().getTime());
//		try (Session session = HibernateConfig.getFACTORY().openSession()){
//			Transaction tran = session.beginTransaction();
//			String hql ="Update History set  likeDate=:x where user.id =:userid and video.id =:videoid";
//			Query query = session.createQuery(hql);
//			query.setParameter("userid",idu);
//			query.setParameter("videoid",idvd);
//			query.setParameter("x", date);
//			query.executeUpdate();
//			tran.commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
	}
}
