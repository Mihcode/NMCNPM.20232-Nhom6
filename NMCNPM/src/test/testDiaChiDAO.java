package test;

import dao.DiaChiDAO;
import model.DiaChi;

public class testDiaChiDAO {
	public static void main(String[] args) {
		DiaChi diachi = new DiaChi("203", 5);
		DiaChiDAO.getInstance().insert(diachi);
		DiaChi diaChi2 = new DiaChi("100", 3);
		
		DiaChi dia = DiaChiDAO.getInstance().selectByusername(diaChi2);
		diaChi2.setID_diachi(dia.getID_diachi());
		System.out.println(dia.getDien_tich());
		System.out.println(dia.getID_diachi());
		DiaChiDAO.getInstance().update(diaChi2);
	}
}
