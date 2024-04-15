package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUntil;
import model.DiaChi;
import model.KhoanThu;

public class KhoanThuDAO implements DAOInterface<KhoanThu>{
	public static KhoanThuDAO getInstance() {
		return new KhoanThuDAO();
	}
	@Override
	public int insert(KhoanThu t) {
		// TODO Auto-generated method stub
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = "INSERT INTO tbl_khoanthu (ten_khoan_thu, so_tien, loai_khoan_thu, dot_thu) " +
						"VALUES (" + "'" + t.getTen_khoan_thu() + "'" + " , " + t.getSo_tien()+ "," + t.getLoai_khoan_thu() + ", '" +t.getDate() + "')";
		
		int thongbao = st.executeUpdate(sql);
			
			//4.
		System.out.println("Ban da thuc hien cau lenh" + sql);
		System.out.println("Co " + thongbao +" dong bi thay doi");
		
		
		
			//5.
		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(KhoanThu t) {
		// TODO Auto-generated method stub
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = "UPDATE tbl_khoanthu" +
						" SET" + 
						"ten_khoan_thu = '" + t.getTen_khoan_thu()+"'"+
						",so_tien = '" + t.getSo_tien()+"'" +
						",loai_khoan_thu = " + t.getLoai_khoan_thu() +
						",dot_thu = '" + t.getDate() + "'" + 
						"WHERE ID_khoanthu = " + t.getID_khoanthu()  ;
		
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
	public int delete(KhoanThu t) {
		// TODO Auto-generated method stub
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = "DELETE FROM tbl_khoanthu" +
						" WHERE ten_khoan_thu ='" +t.getTen_khoan_thu() +"'" ;
		
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
	public ArrayList<KhoanThu> selectALL() {
		// TODO Auto-generated method stub
		ArrayList<KhoanThu> ketQua = new ArrayList<KhoanThu>();
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = 	"SELECT "
							+"[ID_khoanthu]"
						    + ",[ten_khoan_thu]"
						    +",[so_tien]"
						    +",[loai_khoan_thu]"
						    +",CONVERT(varchar, [dot_thu], 103) as dot_thu"
						    + " FROM tbl_khoanthu" ;
		
			ResultSet rs = st.executeQuery(sql);
			
			//4.
		System.out.println("Ban da thuc hien cau lenh " + sql);
		System.out.println("Co " + ketQua +" dong bi thay doi");
		while(rs.next()) {
			int id = rs.getInt("ID_khoanthu");
			String tenkhoanthu = rs.getString("ten_khoan_thu");
			double sotien = rs.getDouble("so_tien");
			int loaikhoanthu = rs.getInt("loai_khoan_thu");
			String dotthu = rs.getString("dot_thu");
			KhoanThu khoanthu = new KhoanThu(tenkhoanthu, sotien, loaikhoanthu, dotthu);
			khoanthu.setID_khoanthu(id);
			ketQua.add(khoanthu);
		}
			//5.
		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(KhoanThu k : ketQua) {
			System.out.println("Id :" + k.getID_khoanthu() + " " + k.getTen_khoan_thu() + " " + k.getSo_tien() + " " + k.getLoai_khoan_thu() + " " + k.getDate());
		}
		return ketQua;
	}

	@Override
	public KhoanThu selectByusername(KhoanThu t) {
		// TODO Auto-generated method stub
		KhoanThu ketQua = null;
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = 	"SELECT "
							+"[ID_khoanthu]"
						    + ",[ten_khoan_thu]"
						    +",[so_tien]"
						    +",[loai_khoan_thu]"
						    +",CONVERT(varchar, [dot_thu], 103) as dot_thu"
						    + " FROM tbl_khoanthu"
						    +" WHERE ten_khoan_thu = " + "'" + t.getTen_khoan_thu() + "'";
		
			ResultSet rs = st.executeQuery(sql);
			
			//4.
		System.out.println("Ban da thuc hien cau lenh " + sql);
		System.out.println("Co " + ketQua +" dong bi thay doi");
		while(rs.next()) {
			int id = rs.getInt("ID_khoanthu");
			String tenkhoanthu = rs.getString("ten_khoan_thu");
			double sotien = rs.getDouble("so_tien");
			int loaikhoanthu = rs.getInt("loai_khoan_thu");
			String dotthu = rs.getString("dot_thu");
			KhoanThu khoanthu = new KhoanThu(tenkhoanthu, sotien, loaikhoanthu, dotthu);
			khoanthu.setID_khoanthu(id);
			ketQua = khoanthu;
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
	public ArrayList<KhoanThu> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<KhoanThu> ketQua = new ArrayList<KhoanThu>();
		try {
			//1.Tao ket noi den csdl
			Connection con = JDBCUntil.getConnection();
			
			//2.Tao ra doi tuong statement
			Statement st = con.createStatement();		
			//3.run cau lenh SQL
			String sql = 	"SELECT "
					+"[ID_khoanthu]"
				    + ",[ten_khoan_thu]"
				    +",[so_tien]"
				    +",[loai_khoan_thu]"
				    +",CONVERT(varchar, [dot_thu], 103) as dot_thu"
				    + " FROM tbl_khoanthu"
				    +" WHERE ten_khoan_thu = " + condition;
			ResultSet rs = st.executeQuery(sql);
			
			//4.
		System.out.println("Ban da thuc hien cau lenh " + sql);
		System.out.println("Co " + ketQua +" dong bi thay doi");
		while(rs.next()) {
			int id = rs.getInt("ID_khoanthu");
			String tenkhoanthu = rs.getString("ten_khoan_thu");
			double sotien = rs.getDouble("so_tien");
			int loaikhoanthu = rs.getInt("loai_khoan_thu");
			String dotthu = rs.getString("dot_thu");
			KhoanThu khoanthu = new KhoanThu(tenkhoanthu, sotien, loaikhoanthu, dotthu);
			khoanthu.setID_khoanthu(id);
			ketQua.add(khoanthu);
		}
			//5.
		JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(KhoanThu k : ketQua) {
			System.out.println("Id :" + k.getID_khoanthu() + " " + k.getTen_khoan_thu() + " " + k.getSo_tien() + " " + k.getLoai_khoan_thu() + " " + k.getDate());
		}
		return ketQua;
		}

	@Override
	public boolean checkExit(KhoanThu t) {
		// TODO Auto-generated method stub
		KhoanThu khoanthu = KhoanThuDAO.getInstance().selectByusername(t);
		if (khoanthu != null) {
			return true;
		}
		return false;
	}

}
