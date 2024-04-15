package test;

import dao.KhoanThuDAO;
import model.KhoanThu;

public class testKhoanThuDAO {
	public static void main(String[] args) {
		KhoanThu k = new KhoanThu("Tien nha", 20000000, 1, "2020-04-15");
//		KhoanThuDAO.getInstance().insert(k);
		KhoanThuDAO.getInstance().selectALL();
		KhoanThuDAO.getInstance().selectByusername(k);
		KhoanThuDAO.getInstance().checkExit(k);
	}
}
