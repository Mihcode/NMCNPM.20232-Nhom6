package Controler;
import Model.tbl_noptien;
import Model.tbl_nhankhau;
import DaAcOb.noptienDAO;
import java.util.List;

public class noptienCtrl {
    private noptienDAO noptienDAO;

    public noptienCtrl() {
        noptienDAO = new noptienDAO();
    }

    public void themKhoanTien(tbl_noptien noptien) {
        noptienDAO.addtbl_noptien(noptien);
    }

    public void xoaKhoanTien(int ID_khoanthu) {
        noptienDAO.deletetbl_noptien(ID_khoanthu);
    }

    public tbl_noptien timKhoanTien(int ID_khoanthu) {
        return noptienDAO.getNopTienById(ID_khoanthu);
    }

    public void capNhatKhoanTien(tbl_noptien noptien) {
        noptienDAO.updatetbl_noptien(noptien);
    }
    public List<tbl_nhankhau> getNhanKhauByIdKhoanThu(int idKhoanThu) {
        return noptienDAO.getNhanKhauByIdKhoanThu(idKhoanThu);
    }
    public List<tbl_noptien> getAllNopTien() {
        return noptienDAO.getAllNopTien();
    }
}
