package test;

import java.util.ArrayList;

import dao.UserDAO;
import model.User;

public class testUserDAO {
	public static void main(String[] args) {
		User user = new User("adada", "admin");
//		UserDAO.getInstance().insert(user);
		UserDAO.getInstance().checkExitsUserName(user);

//		User user2 = new User("admin", "Thanhtu");
//		UserDAO.getInstance().update(user2);
		
//		User user3 = new User("admin", "admin");
//		UserDAO.getInstance().delete(user3);
		
//		ArrayList<User> user = UserDAO.getInstance().selectALL();
//		System.out.println(user.toString());
		
//		User user = new User();
//		user.setUserid(1);
//		user.setUsername("admin");
//		User find = UserDAO.getInstance().selectByusername(user);
//		System.out.println(find);
		
//		String condition = "userid = 1";
//		UserDAO.getInstance().selectByCondition(condition);
	}
}
