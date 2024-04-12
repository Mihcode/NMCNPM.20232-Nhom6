package model;

public class DiaChi {
	private int ID_diachi;
	private char so_phong;
	private int dien_tich;
	public int getID_diachi() {
		return ID_diachi;
	}
	public void setID_diachi(int iD_diachi) {
		ID_diachi = iD_diachi;
	}
	public char getSo_phong() {
		return so_phong;
	}
	public void setSo_phong(char so_phong) {
		this.so_phong = so_phong;
	}
	public int getDien_tich() {
		return dien_tich;
	}
	public void setDien_tich(int dien_tich) {
		this.dien_tich = dien_tich;
	}
	public DiaChi(int iD_diachi, char so_phong, int dien_tich) {
		this.ID_diachi = iD_diachi;
		this.so_phong = so_phong;
		this.dien_tich = dien_tich;
	}
	public DiaChi(char so_phong, int dien_tich) {
		this.so_phong = so_phong;
		this.dien_tich = dien_tich;
	}
}
