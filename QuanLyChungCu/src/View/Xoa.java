import Controler.nhankhauCtrl;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Xoa {
    private JFrame frame;

    public Xoa() {
        frame = new JFrame("Xóa nhân khẩu");
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

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(10, 20, 80, 25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(100, 20, 165, 25);
        panel.add(idText);

        JButton xoaButton = new JButton("Xóa");
        xoaButton.setBounds(10, 80, 80, 25);
        panel.add(xoaButton);

        xoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idText.getText());
                nhankhauCtrl nhankhauCtrl = new nhankhauCtrl();
                if (!nhankhauCtrl.isIdExist(id)) {
                JOptionPane.showMessageDialog(frame, "**ID không tồn tại. Vui lòng nhập ID khác.**");
                }
                else{
                int result = JOptionPane.showConfirmDialog(frame, "Bạn có chắc chắn muốn xóa nhân khẩu với ID: " + id + "?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    nhankhauCtrl.deleteNhanKhau(id);
                    JOptionPane.showMessageDialog(frame, "Đã xóa nhân khẩu với ID: " + id);
                }
                }
            }
        });
    }
}
