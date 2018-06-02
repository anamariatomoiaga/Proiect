package BLL;

import DAO.UserDAO;
import Model.User;

public class UserBLL {
	public static int login(String username, String password) {
		return UserDAO.login(username, password);
	}
	public static Integer create(User u) {
		return UserDAO.create(u);
	}
	
}
