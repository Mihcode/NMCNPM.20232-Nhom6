package model;

public class KhoanThu {
	private int ID_khoanthu;
	private String ten_khoan_thu;
	private double so_tien;
	private	int loai_khoan_thu;
	private String date; //YYYY-MM-DD
	public KhoanThu(String t, double so_tien, int loai_khoan_thu, String date){
		this.ten_khoan_thu = t;
		this.so_tien = so_tien;
		this.loai_khoan_thu = loai_khoan_thu;
		this.date = date;
	}
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
	
	public int getLoai_khoan_thu() {
		return loai_khoan_thu;
	}
	public void setLoai_khoan_thu(int loai_khoan_thu) {
		this.loai_khoan_thu = loai_khoan_thu;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
