package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUntil;
import model.User;

public class UserDAO implements DAOInterface<User>{

	public static UserDAO getInstance() {
		return new UserDAO();
	}
	@Override
	public int insert(User t) {
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = "INSERT INTO QLUser (username, password) " +
						"VALUES ('" + t.getUsername()+ "' , '" + t.getPassword() + "')";
		
		int ketQua = st.executeUpdate(sql);
			
			//4.
		System.out.println("Ban da thuc hien cau lenh" + sql);
		System.out.println("Co " + ketQua +" dong bi thay doi");
			//5.
		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = "UPDATE QLUser" +
						" SET" + 
						" username = '" + t.getUsername()+"'"+
						",password = '" + t.getPassword() +"'" +
						"WHERE userid = 2"  ;
		
		int ketQua = st.executeUpdate(sql);
			
			//4.
		System.out.println("Ban da thuc hien cau lenh" + sql);
		System.out.println("Co " + ketQua +" dong bi thay doi");
			//5.
		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(User t) {
		// TODO Auto-generated method stub
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = "DELETE FROM QLUser" +
						" WHERE username ='" +t.getUsername() +"'" ;
		
		int ketQua = st.executeUpdate(sql);
			
			//4.
		System.out.println("Ban da thuc hien cau lenh " + sql);
		System.out.println("Co " + ketQua +" dong bi thay doi");
			//5.
		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<User> selectALL() {
		// TODO Auto-generated method stub
		ArrayList<User> ketQua = new ArrayList<User>();
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = "SELECT* FROM QLUser" ;
		
			ResultSet rs = st.executeQuery(sql);
			
			//4.
		System.out.println("Ban da thuc hien cau lenh " + sql);
		System.out.println("Co " + ketQua +" dong bi thay doi");
		while(rs.next()) {
			int id = rs.getInt("userid");
			String userName = rs.getString("username");
			String password = rs.getString("password");
			User user = new User (userName, password);
			user.setUserid(id);
			ketQua.add(user);
			
		}
			//5.
		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public User selectByusername(User t) {
		// TODO Auto-generated method stub
		User ketQua = null;
				try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = "SELECT* FROM QLUser WHERE username = '" + t.getUsername() + "'";
			System.out.println("Ban da thuc hien cau lenh " + sql);
			ResultSet rs = st.executeQuery(sql);
			
			
			//4.
			while(rs.next()) {
				int id = rs.getInt("userid");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				User user = new User (userName, password);
				user.setUserid(id);
				ketQua = user;
			}
			
		
		
			//5.
		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<User> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<User> ketQua = new ArrayList<User>();
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = "SELECT* FROM QLUser WHERE " + condition ;
			System.out.println("Ban da thuc hien cau lenh " + sql);
			ResultSet rs = st.executeQuery(sql);
			
			//4.
			while(rs.next()) {
				int id = rs.getInt("userid");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				User user = new User (userName, password);
				user.setUserid(id);
				ketQua.add(user);
				
			}
		System.out.println("Co " + ketQua +" dong bi thay doi");
		
			//5.
		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	@Override
	public boolean checkExitsUserName(User t) {
		// TODO Auto-generated method stub
		User Exits = UserDAO.getInstance().selectByusername(t);
		if (Exits != null) {
			System.out.println("Da co username trung vui long nhap username khac");
			return true;
		}
		return false;
	}
	

}
