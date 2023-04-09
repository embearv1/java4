package com.poly.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.poly.config.HibernateConfig;
import com.poly.entity.User;

public class UserRepository {
	public User checkLogin(String username, String pass) {
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Query query = session.createQuery("From User where user=:x and pass=:y and active=true");
			query.setParameter("x", username);
			query.setParameter("y", pass);
			User u = (User)query.getSingleResult();
			return u;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public void addUser(User u) {
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Transaction tran  = session.beginTransaction();
			session.save(u);
			tran.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updatePass(int id,String pass) {
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Transaction tran  = session.beginTransaction();
			Query query = session.createQuery("Update User set pass=:pass where id=:id");
			query.setParameter("pass", pass);
			query.setParameter("id", id);
			query.executeUpdate();
			tran.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public User checkForget(String user,String mail) {
		boolean check = false;
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Query query = session.createQuery("From User where user=:x and email=:y and isadmin=false");
			query.setParameter("y", mail);
			query.setParameter("x", user);
			User ng = (User) query.getSingleResult();
			return ng;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public void resetPass(String user) {
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Transaction tran= session.beginTransaction();
			Query query = session.createQuery("Update User set pass=:pass where user=:user");
			query.setParameter("user",user);
			query.setParameter("pass","123@");
			query.executeUpdate();
			tran.commit();
		}
	}
	public List<User> getAll(){
		List<User> ds = new ArrayList<>();
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Query query = session.createQuery("From User where active=true");
			ds=query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
	
	public void delete(int id) {
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Transaction tran = session.beginTransaction();
			Query query = session.createQuery("Update User set active=false where id=:id");
			query.setParameter("id", id);
			query.executeUpdate();
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public User getOne(int id) {
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Query query = session.createQuery("From User where id=:id");
			query.setParameter("id", id);
			User u = (User) query.getSingleResult();
			return u;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public void updateUser(User u) {
		try (Session session = HibernateConfig.getFACTORY().openSession()){
			Transaction tran = session.beginTransaction();
			session.merge(u);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
