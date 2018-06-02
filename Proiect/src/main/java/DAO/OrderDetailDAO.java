package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import Model.OrderDetail;

public class OrderDetailDAO {
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	public static Integer create(OrderDetail m) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
			session.save(m);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + m.toString());
		return m.getId();
	}
	public static List<OrderDetail> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<OrderDetail> p = session.createQuery("FROM OrderDetail").list();
		session.close();
		System.out.println("Found " + p.size() + " OrdersDetail");
		return p;

	}
}
