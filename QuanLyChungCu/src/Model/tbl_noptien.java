package Model;
import java.sql.Date;

 public class tbl_noptien {
    private int ID_khoanthu;
    private int ID_nhankhau; 
    private double so_tien;
    private Date ngay_nop;

    public tbl_noptien(int ID_khoanthu, int ID_nhankhau, double so_tien, Date ngay_nop) {
        this.ID_khoanthu = ID_khoanthu;
        this.ID_nhankhau = ID_nhankhau;
        this.so_tien = so_tien;
        this.ngay_nop = ngay_nop;
    }

    public tbl_noptien() {
    }

    public int getID_khoanthu() {
        return ID_khoanthu;
    }

    public void setID_khoanthu(int ID_khoanthu) {
        this.ID_khoanthu = ID_khoanthu;
    }

    public int getID_nhankhau() {
        return ID_nhankhau;
    }

    public void setID_nhankhau(int ID_nhankhau) {
        this.ID_nhankhau = ID_nhankhau;
    }

    public double getSo_tien() {
        return so_tien;
    }

    public void setSo_tien(double so_tien) {
        this.so_tien = so_tien;
    }

    public Date getNgay_nop() {
        return ngay_nop;
    }

    public void setNgay_nop(Date ngay_nop) {
        this.ngay_nop = ngay_nop;
    }
     @Override
    public String toString() {
        return "ID khoản thu: " + ID_khoanthu + ", ID nhân khẩu: " + ID_nhankhau + ", Số tiền: " + so_tien + ", Ngày nộp: " + ngay_nop;
    }

       
}



