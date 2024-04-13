package model;

public class NhanKhau {
	private int ID_nhankhau;
	private String ho_ten;
	private boolean gioi_tinh;
	private String date;
	private String cccd;
	private String sdt;
	public int getID_nhankhau() {
		return ID_nhankhau;
	}
	public void setID_nhankhau(int iD_nhankhau) {
		ID_nhankhau = iD_nhankhau;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
