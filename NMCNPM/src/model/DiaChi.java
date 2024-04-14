package model;

public class DiaChi {
	private int ID_diachi;
	private String so_phong;
	private int dien_tich;
	public int getID_diachi() {
		return ID_diachi;
	}
	public void setID_diachi(int iD_diachi) {
		ID_diachi = iD_diachi;
	}
	public String getSo_phong() {
		return so_phong;
	}
	public void setSo_phong(String so_phong) {
		this.so_phong = so_phong;
	}
	public int getDien_tich() {
		return dien_tich;
	}
	public void setDien_tich(int dien_tich) {
		this.dien_tich = dien_tich;
	}
	public DiaChi(String so_phong, int dien_tich) {
		this.so_phong = so_phong;
		this.dien_tich = dien_tich;
	}
}
