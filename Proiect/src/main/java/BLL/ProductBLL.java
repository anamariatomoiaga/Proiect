package BLL;

import java.util.List;

import DAO.ProductDAO;
import Model.Product;

public class ProductBLL {
	public static List<Product> read(){
		return ProductDAO.read();
	}
	public static Product findId(int id) {
		return ProductDAO.findId(id);
	}
	public static Integer create(Product m) {
		return ProductDAO.create(m);
	}
	public static List<Product> searchName(String name) {
		return ProductDAO.searchName(name);
	}
	public static Product findByID(Integer id) {
		return ProductDAO.findByID(id);
	}
	public static void delete(Integer id) {
		ProductDAO.delete(id);
	}
	public static void updateQuantity(int id, int quantity) {
		ProductDAO.updateQuantity(id, quantity);
	}
	public static void updateStock(int id, int quantity) {
		ProductDAO.updateStock(id, quantity);
	}
	public static void changePrice(int id, float price) {
		ProductDAO.changePrice(id, price);
	}
	public static List<Object> readProducts() {
		return ProductDAO.readProducts();
	}
}
