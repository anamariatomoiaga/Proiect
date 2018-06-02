package BLL;

import java.util.List;

import DAO.OrderDetailDAO;
import Model.OrderDetail;

public class OrderDetailBLL {
	public static Integer create(OrderDetail m) {
		return OrderDetailDAO.create(m);
	}
	public static List<OrderDetail> read() {
		return OrderDetailDAO.read();
	}
}
