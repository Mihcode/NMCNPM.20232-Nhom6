package model;

public class KhoanThu {
	private int ID_khoanthu;
	private String ten_khoan_thu;
	private double so_tien;
	private boolean loai_khoan_thu;
	private String date;
	public int getID_khoanthu() {
		return ID_khoanthu;
	}
	public void setID_khoanthu(int iD_khoanthu) {
		ID_khoanthu = iD_khoanthu;
	}
	public String getTen_khoan_thu() {
		return ten_khoan_thu;
	}
	public void setTen_khoan_thu(String ten_khoan_thu) {
		this.ten_khoan_thu = ten_khoan_thu;
	}
	public double getSo_tien() {
		return so_tien;
	}
	public void setSo_tien(double so_tien) {
		this.so_tien = so_tien;
	}
	public boolean isLoai_khoan_thu() {
		return loai_khoan_thu;
	}
	public void setLoai_khoan_thu(boolean loai_khoan_thu) {
		this.loai_khoan_thu = loai_khoan_thu;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
