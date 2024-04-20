package DaAcOb;
import Model.tbl_nhankhau;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class nhankhauDAO {
        private Connection conn;

    public nhankhauDAO() {
        this.conn = DBcn.getConnection();
    }
                // trả về đối tượng nhân khẩu có Id truyền vào
                public tbl_nhankhau getNhanKhauById(int id) {
                tbl_nhankhau nhanKhau = null;

                try {
                    String sql = "SELECT * FROM tbl_nhankhau WHERE ID_nhankhau = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    // Xử lý kết quả
                    if (resultSet.next()) {
                        nhanKhau = new tbl_nhankhau();
                        nhanKhau.setID_nhankhau(resultSet.getInt("ID_nhankhau"));
                        nhanKhau.setHo_ten(resultSet.getString("ho_ten"));
                        nhanKhau.setGioi_tinh(resultSet.getBoolean("gioi_tinh"));
                        nhanKhau.setNgay_sinh(resultSet.getDate("ngay_sinh"));
                        nhanKhau.setCccd(resultSet.getString("cccd"));
                        nhanKhau.setSdt(resultSet.getString("sdt"));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                return nhanKhau;
            }
                
                // Thêm nhân khẩu vào cơ sở dữ liệu
                public void addtbl_nhankhau(tbl_nhankhau nhanKhau) {
                try {
                    String sql = "INSERT INTO tbl_nhankhau (ID_nhankhau, ho_ten, gioi_tinh, ngay_sinh, cccd, sdt) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setInt(1, nhanKhau.getID_nhankhau());
                    preparedStatement.setString(2, nhanKhau.getHo_ten());
                    preparedStatement.setBoolean(3, nhanKhau.isGioi_tinh());
                    preparedStatement.setDate(4, nhanKhau.getNgay_sinh());
                    preparedStatement.setString(5, nhanKhau.getCccd());
                    preparedStatement.setString(6, nhanKhau.getSdt());
                    preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

                //Chỉnh sửa thông tin nhân khẩu
                public void updatetbl_nhankhau(tbl_nhankhau nhanKhau) {
                try {
                    String sql = "UPDATE tbl_nhankhau SET ho_ten = ?, gioi_tinh = ?, ngay_sinh = ?, cccd = ?, sdt = ? WHERE ID_nhankhau = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, nhanKhau.getHo_ten());
                    preparedStatement.setBoolean(2, nhanKhau.isGioi_tinh());
                    preparedStatement.setDate(3, nhanKhau.getNgay_sinh());
                    preparedStatement.setString(4, nhanKhau.getCccd());
                    preparedStatement.setString(5, nhanKhau.getSdt());
                    preparedStatement.setInt(6, nhanKhau.getID_nhankhau());
                    preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

                //Xóa nhân khẩu
                public void deletetbl_nhankhau(int id) {
                try {
                    String sql = "DELETE FROM tbl_nhankhau WHERE ID_nhankhau = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setInt(1, id);
                    preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
                //Lấy danh sách nhân khẩu
                public List<tbl_nhankhau> getDanhSachNhanKhau() {
                List<tbl_nhankhau> danhSachNhanKhau = new ArrayList<>();

                try {
                    String sql = "SELECT * FROM tbl_nhankhau";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
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



}
