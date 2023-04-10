package com.poly.dao;

import java.sql.Date;
import java.util.List;

import com.poly.entity.History;
import com.poly.entity.Video;

public interface HistoryDAO {

	History checkHis(int userId, int videoId);

	void updateDisLikeHistory(int userId, int videoId);

	void setHistory(History his);

	boolean likeVideo(int userId, int videoId, boolean like, Date ng);

	List<History> getHistoryByUser(int userId);

	List<Video> getLikedByUser(int userId);
	
	void updateShare(int idu,int idvd);

}