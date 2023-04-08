package com.poly.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "id_video")
	private Video video;
	
	@Column(name="viewDate")
	private Date viewDate;
	
	@Column(name = "isLiked")
	private Boolean islike;
	
	@Column(name="likedDate")
	private Date likeDate;

	public History() {
		super();
		// TODO Auto-generated constructor stub
	}

	public History(int id, User user, Video video, Date viewDate, Boolean islike, Date likeDate) {
		super();
		this.id = id;
		this.user = user;
		this.video = video;
		this.viewDate = viewDate;
		this.islike = islike;
		this.likeDate = likeDate;
	}
	
	

	public History(User user, Video video, Date viewDate, Boolean islike, Date likeDate) {
		super();
		this.user = user;
		this.video = video;
		this.viewDate = viewDate;
		this.islike = islike;
		this.likeDate = likeDate;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Date getViewDate() {
		return viewDate;
	}

	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}

	public Boolean getIslike() {
		return islike;
	}

	public void setIslike(Boolean islike) {
		this.islike = islike;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

	@Override
	public String toString() {
		return "History [id=" + id + "]";
	}
	
}
