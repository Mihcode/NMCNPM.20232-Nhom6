package DaAcOb;
import Model.tbl_nhankhau;
import Model.tbl_noptien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class noptienDAO {
    private Connection conn;

    public noptienDAO() {
        this.conn = DBcn.getConnection();
    }
    // Xem thông tin của noptien có ID khoản thu tương ứng
    public tbl_noptien getNopTienById(int id) {
        tbl_noptien nopTien = null;

        try {
            String sql = "SELECT * FROM tbl_noptien WHERE ID_khoanthu = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Xử lý kết quả
            if (resultSet.next()) {
                nopTien = new tbl_noptien();
                nopTien.setID_khoanthu(resultSet.getInt("ID_khoanthu"));
                nopTien.setID_nhankhau(resultSet.getInt("ID_nhankhau"));
                nopTien.setSo_tien(resultSet.getDouble("so_tien"));
                nopTien.setNgay_nop(resultSet.getDate("ngay_nop"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return nopTien;
    }

    public void addtbl_noptien(tbl_noptien nopTien) {
        try {
            String sql = "INSERT INTO tbl_noptien (ID_khoanthu, ID_nhankhau, so_tien, ngay_nop) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, nopTien.getID_khoanthu());
            preparedStatement.setInt(2, nopTien.getID_nhankhau());
            preparedStatement.setDouble(3, nopTien.getSo_tien());
            preparedStatement.setDate(4, nopTien.getNgay_nop());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatetbl_noptien(tbl_noptien nopTien) {
        try {
            String sql = "UPDATE tbl_noptien SET ID_nhankhau = ?, so_tien = ?, ngay_nop = ? WHERE ID_khoanthu = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, nopTien.getID_nhankhau());
            preparedStatement.setDouble(2, nopTien.getSo_tien());
            preparedStatement.setDate(3, nopTien.getNgay_nop());
            preparedStatement.setInt(4, nopTien.getID_khoanthu());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletetbl_noptien(int id) {
        try {
            String sql = "DELETE FROM tbl_noptien WHERE ID_khoanthu = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // Lấy danh sách nhân khẩu có trùng ID khoản du mà ta truyền vào
    public List<tbl_nhankhau> getNhanKhauByIdKhoanThu(int idKhoanThu) {
    List<tbl_nhankhau> danhSachNhanKhau = new ArrayList<>();

    try {
        String sql = "SELECT * FROM tbl_nhankhau WHERE ID_nhankhau IN (SELECT ID_nhankhau FROM tbl_noptien WHERE ID_khoanthu = ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, idKhoanThu);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Xử lý kết quả
        while (resultSet.next()) {
            tbl_nhankhau nhanKhau = new tbl_nhankhau();
            nhanKhau.setID_nhankhau(resultSet.getInt("ID_nhankhau"));
            nhanKhau.setHo_ten(resultSet.getString("ho_ten"));
            nhanKhau.setGioi_tinh(resultSet.getBoolean("gioi_tinh"));
            nhanKhau.setNgay_sinh(resultSet.getDate("ngay_sinh"));
            nhanKhau.setCccd(resultSet.getString("cccd"));
            nhanKhau.setSdt(resultSet.getString("sdt"));

            danhSachNhanKhau.add(nhanKhau);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return danhSachNhanKhau;
}
    public List<tbl_noptien> getAllNopTien() {
    List<tbl_noptien> danhSachNopTien = new ArrayList<>();

    try {
        String sql = "SELECT * FROM tbl_noptien";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Xử lý kết quả
        while (resultSet.next()) {
            tbl_noptien nopTien = new tbl_noptien();
            nopTien.setID_khoanthu(resultSet.getInt("ID_khoanthu"));
            nopTien.setID_nhankhau(resultSet.getInt("ID_nhankhau"));
            nopTien.setSo_tien(resultSet.getDouble("so_tien"));
            nopTien.setNgay_nop(resultSet.getDate("ngay_nop"));

            danhSachNopTien.add(nopTien);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return danhSachNopTien;
}


}
