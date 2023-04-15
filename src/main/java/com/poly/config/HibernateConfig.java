package com.poly.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.poly.entity.History;
import com.poly.entity.Type_Video;
import com.poly.entity.User;
import com.poly.entity.Video;


public class HibernateConfig {
	 private static final SessionFactory FACTORY;

	    static {
	        Configuration conf = new Configuration();

	        Properties properties = new Properties();
	        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
	        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=QLClip");
	        properties.put(Environment.USER, "sa");
	        properties.put(Environment.PASS, "123456");
	        properties.put(Environment.SHOW_SQL, "true");

	        conf.setProperties(properties);
//	        conf.addAnnotatedClass(Catecory.class);
	        conf.addAnnotatedClass(User.class);
	        conf.addAnnotatedClass(Video.class);
	        conf.addAnnotatedClass(Type_Video.class);
	        conf.addAnnotatedClass(History.class);
	        ServiceRegistry registry = new StandardServiceRegistryBuilder()
	                .applySettings(conf.getProperties()).build();
	        FACTORY = conf.buildSessionFactory(registry);

	    }

	    public static SessionFactory getFACTORY() {
	        return FACTORY;
	    }

	    public static void main(String[] args) {
	        System.out.println(getFACTORY());
	    }
}
