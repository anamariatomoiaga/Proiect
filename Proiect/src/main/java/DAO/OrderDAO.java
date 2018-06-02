package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import Model.Order;

public class OrderDAO {
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	public static Integer create(Order m) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
			session.save(m);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + m.toString());
		return m.getId();
	}
	public static List<Order> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Order> p = session.createQuery("FROM Order").list();
		session.close();
		System.out.println("Found " + p.size() + " Orders");
		return p;

	}

}
