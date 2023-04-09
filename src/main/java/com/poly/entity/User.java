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
@Table(name = "account")
public class User implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username")
	private String user;

	@Column(name = "password")
	private String pass;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "isAdmin")
	private boolean admin;

	@Column(name = "active")
	private boolean active;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<History> listHis;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String user, String pass, String name, String email, boolean admin, boolean active) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.admin = admin;
		this.active = active;
	}

	
	public User(int id, String user, String pass, String name, String email, boolean admin, boolean active,
			List<History> listHis) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.admin = admin;
		this.active = active;
		this.listHis = listHis;
	}

	
	

	public User(String user, String pass, String name, String email, boolean admin, boolean active) {
		super();
		this.user = user;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.admin = admin;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	public List<History> getListHis() {
		return listHis;
	}

	public void setListHis(List<History> listHis) {
		this.listHis = listHis;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + ", pass=" + pass + ", name=" + name + ", email=" + email
				+ ", admin=" + admin + ", active=" + active + "]";
	}

}
