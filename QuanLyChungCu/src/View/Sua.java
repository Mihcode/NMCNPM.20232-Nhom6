import Controler.nhankhauCtrl;
import Model.tbl_nhankhau;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sua {
    private JFrame frame;

    public Sua() {
        frame = new JFrame("Sửa nhân khẩu");
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
        }

        JButton suaButton = new JButton("Sửa");
        suaButton.setBounds(10, y, 80, 25);
        panel.add(suaButton);

        suaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy dữ liệu từ các trường nhập và sửa nhân khẩu
                int id = Integer.parseInt(((JTextField) panel.getComponent(1)).getText());
                String hoTen = ((JTextField) panel.getComponent(3)).getText();
                boolean gioiTinh = ((JComboBox) panel.getComponent(5)).getSelectedItem().equals("Nam");
                Date ngaySinh = (Date) ((JSpinner) panel.getComponent(7)).getValue();
                String cccd = ((JTextField) panel.getComponent(9)).getText();
                String sdt = ((JTextField) panel.getComponent(11)).getText();

                tbl_nhankhau nhanKhau = new tbl_nhankhau(id, hoTen, gioiTinh, new java.sql.Date(ngaySinh.getTime()), cccd, sdt);
                nhankhauCtrl nhankhauCtrl = new nhankhauCtrl();
                nhankhauCtrl.updateNhanKhau(nhanKhau);

                JOptionPane.showMessageDialog(frame, "Đã cập nhật thông tin nhân khẩu");
            }
        });
    }
}


