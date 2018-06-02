package DAO;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import Model.Product;

public class ProductDAO {
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	public static List<Object> readProducts() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Object> m = session.createQuery("FROM Product").list();
		session.close();
		System.out.println("Found " + m.size() + " Products");
		return m;

	}
	public static Integer create(Product m) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		if(m.getQuantity()<=0) {
			JOptionPane.showMessageDialog(null,"Cantitate invalida");
		}
		session.save(m);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + m.toString());
		return m.getId();
	}
	public static List<Product> read() {
		Session session = getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Product> p = session.createQuery("FROM Product").list();
		session.close();
		System.out.println("Found " + p.size() + " Products");
		return p;

	}
	public static List<Product> searchName(String name) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("FROM Product m where (m.name LIKE :medName) ");
		query.setParameter("medName","%" +name +"%");
		@SuppressWarnings("unchecked")
		List<Product> m = query.list();
		session.close();
		System.out.println("Found " + m.size() + " Products");
		return m;

	}
	public static Product findId(int id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Product m = (Product) session.get(Product.class, id);
		session.close();
		return m;

	}
	public static Product findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Product m = (Product) session.load(Product.class, id);
		session.close();
		return m;
	}
	public static void delete(Integer id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		if(id<=0) {
			JOptionPane.showMessageDialog(null,"Id invalid");
		}
		Product m = findByID(id);
		session.delete(m);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + m.toString());

	}
	public static void updateQuantity(int id, int quantity) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		if(id<=0) {
			JOptionPane.showMessageDialog(null,"Id invalid");
		}
		if(quantity<=0) {
			JOptionPane.showMessageDialog(null,"Cantitate invalida");
		}
		Product em = (Product) session.load(Product.class, id);
		if(quantity < em.getQuantity()) {
			em.setQuantity(em.getQuantity()-quantity);
			System.out.println("Successfully updated " );
		}
		else
			JOptionPane.showMessageDialog(null,"Cantitate indisponibila");
		
		session.getTransaction().commit();
		session.close();
		

	}
	public static void updateStock(int id, int quantity) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		if(id<=0) {
			JOptionPane.showMessageDialog(null,"Id invalid");
		}
		if(quantity<=0) {
			JOptionPane.showMessageDialog(null,"Cantitate invalida");
		}
		Product em = (Product) session.load(Product.class, id);
		em.setQuantity(em.getQuantity()+quantity);
		System.out.println("Successfully updated " );
		
		session.getTransaction().commit();
		session.close();
		

	}
	public static void changePrice(int id, float price) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		if(id<=0) {
			JOptionPane.showMessageDialog(null,"Id invalid");
		}
		
		Product em = (Product) session.load(Product.class, id);
		em.setPrice(price);
		System.out.println("Successfully updated " );
		
		session.getTransaction().commit();
		session.close();
		

	}


}
