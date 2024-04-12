package test;

import dao.DiaChiDAO;
import model.DiaChi;

public class testDiaChiDAO {
	public static void main(String[] args) {
		DiaChi diachi = new DiaChi(21,'7', 50);
		DiaChiDAO.getInstance().insert(diachi);
		DiaChiDAO.getInstance().selectByCondition("ID_diachi = 20");
	}
}
