package com.poly.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.poly.config.HibernateConfig;
import com.poly.dao.TypeDAO;
import com.poly.entity.Type_Video;

public class Type_Repo implements TypeDAO {
	@Override
	public List<Type_Video> getAll() {
		List<Type_Video> ds = new ArrayList<>();
		try (Session session = HibernateConfig.getFACTORY().openSession()) {
			Query query = session.createQuery("From Type_Video where isactive=true");
			ds = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public void add(Type_Video type) {
		try (Session session = HibernateConfig.getFACTORY().openSession()) {
			Transaction tran = session.beginTransaction();
			session.save(type);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void dele(int id) {
		try (Session session = HibernateConfig.getFACTORY().openSession()) {
			Transaction tran = session.beginTransaction();
			Query query = session.createQuery("Update Type_Video set isactive=false where id=:id");
			query.setParameter("id", id);
			query.executeUpdate();
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void update(int id,String name) {
		try (Session session = HibernateConfig.getFACTORY().openSession()) {
			Transaction tran = session.beginTransaction();
			Query query = session.createQuery("Update Type_Video set name=:x where id=:id");
			query.setParameter("id", id);
			query.setParameter("x", name);
			query.executeUpdate();
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public Type_Video getOne(int id) {
		try (Session session = HibernateConfig.getFACTORY().openSession()) {
			Query query = session.createQuery("From Type_Video where id=:id");
			query.setParameter("id", id);
			Type_Video type = (Type_Video) query.getSingleResult();
			return type;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
