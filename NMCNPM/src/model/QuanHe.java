package model;

public class QuanHe {
	private int ID_nhakhau;
	private int ID_hokhau;
	private String quan_he;
	private boolean tam_tru;
	private boolean tam_vang;
	public int getID_nhakhau() {
		return ID_nhakhau;
	}
	public void setID_nhakhau(int iD_nhakhau) {
		ID_nhakhau = iD_nhakhau;
	}
	public int getID_hokhau() {
		return ID_hokhau;
	}
	public void setID_hokhau(int iD_hokhau) {
		ID_hokhau = iD_hokhau;
	}
	public String getQuan_he() {
		return quan_he;
	}
	public void setQuan_he(String quan_he) {
		this.quan_he = quan_he;
	}
	public boolean isTam_tru() {
		return tam_tru;
	}
	public void setTam_tru(boolean tam_tru) {
		this.tam_tru = tam_tru;
	}
	public boolean isTam_vang() {
		return tam_vang;
	}
	public void setTam_vang(boolean tam_vang) {
		this.tam_vang = tam_vang;
	}
	
}
