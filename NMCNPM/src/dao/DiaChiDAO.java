package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUntil;
import model.DiaChi;
import model.User;

public class DiaChiDAO implements DAOInterface<DiaChi>{
	public static DiaChiDAO getInstance() {
		return new DiaChiDAO();
	}
	@Override
	public int insert(DiaChi t) {
		// TODO Auto-generated method stub
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = "INSERT INTO QLDiaChi(ID_diachi, so_phong, dien_tich) " +
						"VALUES (" + t.getID_diachi()+ " , " + t.getSo_phong() + " , " + t.getDien_tich()+")";
		
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
	public int update(DiaChi t) {
		// TODO Auto-generated method stub
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = "UPDATE QLDiaChi" +
						" SET" + 
						"dien_tich = '" + t.getDien_tich()+"'"+
						",so_phong= '" + t.getSo_phong() +"'" +
						"WHERE ID_diachi = " + t.getID_diachi()  ;
		
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
	public int delete(DiaChi t) {
		// TODO Auto-generated method stub
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = "DELETE FROM QLDiaChi" +
						" WHERE ID_diachi ='" +t.getID_diachi() +"'" ;
		
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
	public DiaChi selectByusername(DiaChi t) {
		// TODO Auto-generated method stub
		DiaChi ketQua = null;
		try {
	//1.Tao ket noi den csdl
	Connection con = JDBCUntil.getConnection();
	
	//2.Tao ra doi tuong statement
	Statement st = con.createStatement();		
	//3.run cau lenh SQL
	String sql = "SELECT* FROM QLDiaChi WHERE ID_diachi = '" + t.getID_diachi() + "'";
	System.out.println("Ban da thuc hien cau lenh " + sql);
	ResultSet rs = st.executeQuery(sql);
	
	
	//4.
	while(rs.next()) {
		int id = rs.getInt("ID_diachi");
		char so_phong = (char)rs.getInt("so_phong");
		int dien_tich = rs.getInt("dien_tich");
		DiaChi dia_chi = new DiaChi(so_phong, dien_tich);
		dia_chi.setID_diachi(id);
		ketQua = dia_chi;
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
	public boolean checkExitsUserName(DiaChi t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public ArrayList<DiaChi> selectALL() {
		// TODO Auto-generated method stub
		ArrayList<DiaChi> ketQua = new ArrayList<DiaChi>();
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = "SELECT* FROM QLDiaChi" ;
		
			ResultSet rs = st.executeQuery(sql);
			
			//4.
		System.out.println("Ban da thuc hien cau lenh " + sql);
		System.out.println("Co " + ketQua +" dong bi thay doi");
		while(rs.next()) {
			int id = rs.getInt("ID_diachi");
			char so_phong = (char)rs.getInt("so_phong");
			int dien_tich = rs.getInt("dien_tich");
			DiaChi dia_chi = new DiaChi(so_phong, dien_tich);
			dia_chi.setID_diachi(id);
			ketQua.add(dia_chi);
			
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
	public ArrayList<DiaChi> selectByCondition(String condition) {
		// TODO Auto-generated method stub
				ArrayList<DiaChi> ketQua = new ArrayList<DiaChi>();
				try {
					//1.Tao ket noi den csdl
					Connection con = JDBCUntil.getConnection();
					
					//2.Tao ra doi tuong statement
					Statement st = con.createStatement();		
					//3.run cau lenh SQL
					String sql = "SELECT* FROM QLDiaChi WHERE " + condition ;
					System.out.println("Ban da thuc hien cau lenh " + sql);
					ResultSet rs = st.executeQuery(sql);
					
					//4.
					while(rs.next()) {
						int id = rs.getInt("ID_diachi");
						char so_phong = (char)rs.getInt("so_phong");
						int dien_tich = rs.getInt("dien_tich");
						DiaChi dia_chi = new DiaChi(so_phong, dien_tich);
						dia_chi.setID_diachi(id);
						ketQua.add(dia_chi);
						
					}
				
					//5.
				JDBCUntil.closeConnection(con);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ketQua;
	}
	
	
}
