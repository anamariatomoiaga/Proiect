package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import Model.User;

public class UserDAO {
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public static int login(String username, String password) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("FROM User u where u.username= :username and u.password= :password");
		query.setParameter("username",username);
		query.setParameter("password",password);
		@SuppressWarnings("unchecked")
		List<User> u = query.list();
		for(User x: u) {
			if(x.getAdmin() == true) {
				return 0;
			}
			else 
				return x.getId();
		}
		session.close();
		return -1; 
	}
	public static Integer create(User u) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + u.toString());
		return u.getId();
	}
}
