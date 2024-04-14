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
			String sql = "INSERT INTO tbl_user (user_name, password) " +
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
			String sql = "UPDATE tbl_user" +
						" SET" + 
						" user_name = '" + t.getUsername()+"'"+
						",password = '" + t.getPassword() +"'" +
						"WHERE user_id = " +t.getUserid()  ;
		
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
			String sql = "DELETE FROM tbl_user" +
						" WHERE user_name ='" +t.getUsername() +"'" ;
		
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
			String sql = "SELECT* FROM tbl_user" ;
		
			ResultSet rs = st.executeQuery(sql);
			
			//4.
		System.out.println("Ban da thuc hien cau lenh " + sql);
		System.out.println("Co " + ketQua +" dong bi thay doi");
		while(rs.next()) {
			int id = rs.getInt("userid");
			String username = rs.getString("username");
			String password = rs.getString("password");
			User user = new User (username, password);
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
			String sql = "SELECT* FROM tbl_user WHERE user_name = '" + t.getUsername() + "'";
			System.out.println("Ban da thuc hien cau lenh " + sql);
			ResultSet rs = st.executeQuery(sql);
			
			
			//4.
			while(rs.next()) {
				int id = rs.getInt("user_id");
				String username = rs.getString("user_name");
				String password = rs.getString("password");
				User user = new User (username, password);
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
			String sql = "SELECT* FROM tbl_user WHERE " + condition ;
			System.out.println("Ban da thuc hien cau lenh " + sql);
			ResultSet rs = st.executeQuery(sql);
			
			//4.
			while(rs.next()) {
				int id = rs.getInt("user_id");
				String username = rs.getString("user_name");
				String password = rs.getString("password");
				User user = new User (username, password);
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
	public boolean checkExit(User t) {
		// TODO Auto-generated method stub
		User Exits = UserDAO.getInstance().selectByusername(t);
		if (Exits != null) {
			System.out.println("Da co username trung vui long nhap username khac");
			return true;
		}
		return false;
	}
	

}
