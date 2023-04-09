package com.poly.dao;

import java.util.List;

import com.poly.entity.User;

public interface UserDAO {

	User checkLogin(String username, String pass);

	void addUser(User u);

	void updatePass(int id, String pass);

	User checkForget(String user, String mail);

	void resetPass(String user);

	List<User> getAll();

	void delete(int id);

	User getOne(int id);

	void updateUser(User u);

}