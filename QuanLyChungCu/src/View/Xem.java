import Controler.nhankhauCtrl;
import Model.tbl_nhankhau;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class Xem {
    private JFrame frame;

    public Xem() {
        frame = new JFrame("Xem nhân khẩu");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 10, 280, 150);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 10, 280, 150);
        panel.add(scrollPane);

        nhankhauCtrl nhankhauCtrl = new nhankhauCtrl();
        List<tbl_nhankhau> danhSachNhanKhau = nhankhauCtrl.getDanhSachNhanKhau();

        String thongTinNhanKhau = "";
        for (tbl_nhankhau nhanKhau : danhSachNhanKhau) {
            thongTinNhanKhau += "ID: " + nhanKhau.getID_nhankhau()+ "\nHọ tên: " + nhanKhau.getHo_ten() + "\nGiới tính: " + (nhanKhau.isGioi_tinh() ? "Nam" : "Nữ") + "\nNgày sinh: " + nhanKhau.getNgay_sinh() + "\nCCCD: " + nhanKhau.getCccd() + "\nSĐT: " + nhanKhau.getSdt() + "\n\n";
        }
        textArea.setText(thongTinNhanKhau);
    }
}

