package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type_video")
public class Type_Video implements Serializable{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="isActive",insertable = true)
	private boolean isactive;
	
	@OneToMany(mappedBy = "type",fetch = FetchType.LAZY)
	private List<Video> listVideo;
	
	public Type_Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Type_Video(int id, String name, List<Video> listVideo) {
		super();
		this.id = id;
		this.name = name;
		this.listVideo = listVideo;
	}



	public Type_Video(int id, String name, boolean isactive, List<Video> listVideo) {
		super();
		this.id = id;
		this.name = name;
		this.isactive = isactive;
		this.listVideo = listVideo;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public List<Video> getListVideo() {
		return listVideo;
	}



	public void setListVideo(List<Video> listVideo) {
		this.listVideo = listVideo;
	}
	


	public boolean isIsactive() {
		return isactive;
	}



	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}



	@Override
	public String toString() {
		return "Type_Video [id=" + id + ", name=" + name + "]";
	}
	
}
