package com.poly.dao;

import java.util.List;

import com.poly.entity.Video;

public interface VideoDAO {

	List<Video> getAll();

	List<Video> getPaging(int index);

	Video getOne(int id);

	void setView(int id, int view);
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

	List<Video> getMostView();

	List<Video> getMostLike();

	List<Video> getNewVideo();

	Video getVideoByUrl(String href);

	void setShare(int view, int share, int id);

	List<Video> getMostShare();

	void deleteVideo(int id);

	void addVideo(Video v);

	void updateVideo(Video v);

}