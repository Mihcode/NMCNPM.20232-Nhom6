package model;

public class NopTien {
	private int ID_khoanthu;
	private int ID_nhankhau;
	private double so_tien;
	private String ngay_nop;
	public int getID_khoanthu() {
		return ID_khoanthu;
	}
	public void setID_khoanthu(int iD_khoanthu) {
		ID_khoanthu = iD_khoanthu;
	}
	public int getID_nhankhau() {
		return ID_nhankhau;
	}
	public void setID_nhankhau(int iD_nhankhau) {
		ID_nhankhau = iD_nhankhau;
	}
	public double getSo_tien() {
		return so_tien;
	}
	public void setSo_tien(double so_tien) {
		this.so_tien = so_tien;
	}
	public String getNgay_nop() {
		return ngay_nop;
	}
	public void setNgay_nop(String ngay_nop) {
		this.ngay_nop = ngay_nop;
	}
}
