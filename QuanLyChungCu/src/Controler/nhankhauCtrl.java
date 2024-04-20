package Controler;
import DaAcOb.nhankhauDAO;
import Model.tbl_nhankhau;
import java.util.*;
public class nhankhauCtrl {
    private nhankhauDAO nhankhauDAO;

    public nhankhauCtrl() {
        nhankhauDAO = new nhankhauDAO();
    }
    // Kiểm tra xem id có tồn tại hay không
    public boolean isIdExist(int id) {
        tbl_nhankhau nhanKhau = nhankhauDAO.getNhanKhauById(id);
        return nhanKhau != null;
    }
    public tbl_nhankhau getNhanKhauById(int id) {
        return nhankhauDAO.getNhanKhauById(id);
    }
    public List<tbl_nhankhau> getDanhSachNhanKhau() {
        return nhankhauDAO.getDanhSachNhanKhau();
    }
    public void addNhanKhau(tbl_nhankhau nhanKhau) {
        nhankhauDAO.addtbl_nhankhau(nhanKhau);
    }

    public void updateNhanKhau(tbl_nhankhau nhanKhau) {
        nhankhauDAO.updatetbl_nhankhau(nhanKhau);
    }

    public void deleteNhanKhau(int id) {
        nhankhauDAO.deletetbl_nhankhau(id);
    }

}
