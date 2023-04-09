package com.poly.dao;

import java.util.List;

import com.poly.entity.Type_Video;

public interface TypeDAO {

	List<Type_Video> getAll();

	void add(Type_Video type);

	void dele(int id);

	void update(int id, String name);

	Type_Video getOne(int id);

}