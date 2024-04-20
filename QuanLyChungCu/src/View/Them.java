import Controler.nhankhauCtrl;
import Model.tbl_nhankhau;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Them {
    private JFrame frame;
    public Them() {
        frame = new JFrame("Thêm nhân khẩu");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        String[] labels = {"ID", "Họ tên", "Giới tính", "Ngày sinh", "CCCD", "SĐT"};
        int y = 20;
        for (String label : labels) {
            JLabel jLabel = new JLabel(label);
            jLabel.setBounds(10, y, 80, 25);
            panel.add(jLabel);
            if (label.equals("Giới tính")) {
                String[] gioiTinhOptions = {"Nam", "Nữ"};
                JComboBox gioiTinhComboBox = new JComboBox(gioiTinhOptions);
                gioiTinhComboBox.setBounds(100, y, 165, 25);
                panel.add(gioiTinhComboBox);
            } else if (label.equals("Ngày sinh")) {
                JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
                JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
                dateSpinner.setEditor(dateEditor);
                dateSpinner.setBounds(100, y, 165, 25);
                panel.add(dateSpinner);
            } else {
                JTextField jTextField = new JTextField(20);
                jTextField.setBounds(100, y, 165, 25);
                panel.add(jTextField);
            }
            y += 30;
        }        JButton addButton = new JButton("Thêm");
        addButton.setBounds(10, y, 80, 25);
        panel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // Lấy dữ liệu từ các trường nhập
            int id = Integer.parseInt(((JTextField) panel.getComponent(1)).getText());
            String hoTen = ((JTextField) panel.getComponent(3)).getText();
            boolean gioiTinh = ((JComboBox) panel.getComponent(5)).getSelectedItem().equals("Nam");
            Date ngaySinh = (Date) ((JSpinner) panel.getComponent(7)).getValue();
            String cccd = ((JTextField) panel.getComponent(9)).getText();
            String sdt = ((JTextField) panel.getComponent(11)).getText();

            nhankhauCtrl nhankhauCtrl = new nhankhauCtrl();

            // Kiểm tra xem ID đã tồn tại hay chưa
            if (nhankhauCtrl.isIdExist(id)) {
                JOptionPane.showMessageDialog(frame, "**ID đã tồn tại. Vui lòng nhập ID khác.**");
            } else {
                // Thêm nhân khẩu mới
                tbl_nhankhau nhanKhau = new tbl_nhankhau(id, hoTen, gioiTinh, new java.sql.Date(ngaySinh.getTime()), cccd, sdt);
                nhankhauCtrl.addNhanKhau(nhanKhau);
                JOptionPane.showMessageDialog(frame, "Đã thêm nhân khẩu mới");
            }
        }

        });
        
    }
}
