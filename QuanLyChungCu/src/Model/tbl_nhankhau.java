package Model;
import java.sql.Date;

public class tbl_nhankhau {
     private int ID_nhankhau;
    private String ho_ten;
    private boolean gioi_tinh;
    private Date ngay_sinh;
    private String cccd;
    private String sdt;    

    public tbl_nhankhau(int ID_nhankhau, String ho_ten, boolean gioi_tinh, Date ngay_sinh, String cccd, String sdt) {
        this.ID_nhankhau = ID_nhankhau;
        this.ho_ten = ho_ten;
        this.gioi_tinh = gioi_tinh;
        this.ngay_sinh = ngay_sinh;
        this.cccd = cccd;
        this.sdt = sdt;
    }
    public tbl_nhankhau(){}
    
    public int getID_nhankhau() {
        return ID_nhankhau;
    }

    public void setID_nhankhau(int ID_nhankhau) {
        this.ID_nhankhau = ID_nhankhau;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public boolean isGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

        
}
