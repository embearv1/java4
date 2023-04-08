package com.poly.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.poly.config.HibernateConfig;
import com.poly.entity.Type_Video;

public class Type_Repo {
	public List<Type_Video> getAll(){
		List<Type_Video> ds = new ArrayList<>();
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Query query = session.createQuery("From Type_Video where isactive=true");
			ds = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
}
