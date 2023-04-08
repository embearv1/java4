package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class Video implements Serializable{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="href")
	private String href;
	
	@Column(name="poster")
	private String poster;
	
	@Column(name = "views")
	private int view;
	
	@Column(name = "shares")
	private int share;
	
	@Column(name="description")
	private String descrip;
	
	@Column(name ="active")
	private boolean active;
	
	@ManyToOne 
	@JoinColumn(name = "id_type")
	private Type_Video type;

	@OneToMany(mappedBy = "video",fetch = FetchType.LAZY)
	List<History> listhis;
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Video(int id, String title, String href, String poster, int view, int share, String descrip, boolean active,
			Type_Video type) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.poster = poster;
		this.view = view;
		this.share = share;
		this.descrip = descrip;
		this.active = active;
		this.type = type;
	}
	

	

	public Video(int id, String title, String href, String poster, int view, int share, String descrip, boolean active,
			Type_Video type, List<History> listhis) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.poster = poster;
		this.view = view;
		this.share = share;
		this.descrip = descrip;
		this.active = active;
		this.type = type;
		this.listhis = listhis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Type_Video getType() {
		return type;
	}

	public void setType(Type_Video type) {
		this.type = type;
	}
	
	

	public List<History> getListhis() {
		return listhis;
	}

	public void setListhis(List<History> listhis) {
		this.listhis = listhis;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + "]";
	}
	
	
}
