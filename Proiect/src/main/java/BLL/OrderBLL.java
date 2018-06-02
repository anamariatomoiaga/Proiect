package BLL;

import java.util.List;

import DAO.OrderDAO;
import Model.Order;

public class OrderBLL {
	public static Integer create(Order m) {
		return OrderDAO.create(m);
	} 
	public static List<Order> read() {
		return OrderDAO.read();
	}
}
