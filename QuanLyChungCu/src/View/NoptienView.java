import Controler.noptienCtrl;
import Model.tbl_noptien;
import Model.tbl_nhankhau;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

public class NoptienView {
    private JFrame frame;
    private noptienCtrl noptienCtrl;

    public NoptienView() {
        frame = new JFrame("Nộp tiền");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        noptienCtrl = new noptienCtrl();
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton themButton = new JButton("Thêm");
        themButton.setBounds(10, 10, 80, 25);
        panel.add(themButton);

        JButton xoaButton = new JButton("Xóa");
        xoaButton.setBounds(100, 10, 80, 25);
        panel.add(xoaButton);

        JButton timCapNhatButton = new JButton("Tìm/Cập nhật");
        timCapNhatButton.setBounds(190, 10, 150, 25);
        panel.add(timCapNhatButton);

        JButton truyXuatButton = new JButton("Truy xuất");
        truyXuatButton.setBounds(350, 10, 100, 25);
        panel.add(truyXuatButton);

        themButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog(frame, "Thêm khoản tiền", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(5, 2));

        JLabel idKhoanThuLabel = new JLabel("ID khoản thu:");
        JTextField idKhoanThuField = new JTextField();
        JLabel idNhanKhauLabel = new JLabel("ID nhân khẩu:");
        JTextField idNhanKhauField = new JTextField();
        JLabel soTienLabel = new JLabel("Số tiền:");
        JTextField soTienField = new JTextField();
        JLabel ngayNopLabel = new JLabel("Ngày nộp (yyyy-mm-dd):");
        JTextField ngayNopField = new JTextField();

            JButton themButton = new JButton("Thêm");
            themButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lấy thông tin từ form và tạo một đối tượng tbl_noptien mới
                    int idKhoanThu = Integer.parseInt(idKhoanThuField.getText());
                    int idNhanKhau = Integer.parseInt(idNhanKhauField.getText());
                    double soTien = Double.parseDouble(soTienField.getText());
                    Date ngayNop = Date.valueOf(ngayNopField.getText());
                    tbl_noptien nopTien = new tbl_noptien(idKhoanThu, idNhanKhau, soTien, ngayNop);

                    // Thêm khoản tiền này vào cơ sở dữ liệu
                    noptienCtrl.themKhoanTien(nopTien);

                    dialog.dispose();
                }
            });

            dialog.add(idKhoanThuLabel);
            dialog.add(idKhoanThuField);
            dialog.add(idNhanKhauLabel);
            dialog.add(idNhanKhauField);
            dialog.add(soTienLabel);
            dialog.add(soTienField);
            dialog.add(ngayNopLabel);
            dialog.add(ngayNopField);
            dialog.add(themButton);

            dialog.setVisible(true);
        }
    });


        xoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(frame, "Xóa khoản tiền", true);
                dialog.setSize(300, 200);
                dialog.setLayout(new BorderLayout());

                    List<tbl_noptien> danhSachNopTien = noptienCtrl.getAllNopTien();
                JList<tbl_noptien> list = new JList<>(danhSachNopTien.toArray(new tbl_noptien[0]));
                dialog.add(new JScrollPane(list), BorderLayout.CENTER);

                JButton xoaButton = new JButton("Xóa");
                xoaButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tbl_noptien nopTien = list.getSelectedValue();

                        if (nopTien != null) {
                            noptienCtrl.xoaKhoanTien(nopTien.getID_khoanthu());

                            danhSachNopTien.remove(nopTien);
                            list.setListData(danhSachNopTien.toArray(new tbl_noptien[0]));
                        }
                    }
                });
                dialog.add(xoaButton, BorderLayout.SOUTH);

                dialog.setVisible(true);
            }
        });

        // Xem danh sách noptien và có thể sửa nếu muốn
       timCapNhatButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        List<tbl_noptien> danhSachNopTien = noptienCtrl.getAllNopTien();

        // Tạo một mảng các chuỗi, mỗi chuỗi đại diện cho một khoản tiền
        String[] arrNopTien = new String[danhSachNopTien.size()];
        for (int i = 0; i < danhSachNopTien.size(); i++) {
            tbl_noptien nopTien = danhSachNopTien.get(i);
            arrNopTien[i] = "ID khoản thu: " + nopTien.getID_khoanthu() + ", ID nhân khẩu: " + nopTien.getID_nhankhau() + ", Số tiền: " + nopTien.getSo_tien() + ", Ngày nộp: " + nopTien.getNgay_nop();
        }

        // Hiển thị dialog chứa danh sách các khoản tiền
        String selectedNopTien = (String) JOptionPane.showInputDialog(frame, "Chọn một khoản tiền để chỉnh sửa:", "Chỉnh sửa khoản tiền", JOptionPane.PLAIN_MESSAGE, null, arrNopTien, arrNopTien[0]);

        // Nếu người dùng đã chọn một khoản tiền
        if (selectedNopTien != null) {
            // Tách chuỗi để lấy ID của khoản thu
            String[] parts = selectedNopTien.split(", ");
            int idKhoanThu = Integer.parseInt(parts[0].split(": ")[1]);

            // Tìm khoản tiền trong danh sách dựa trên ID
            tbl_noptien nopTien = danhSachNopTien.stream().filter(n -> n.getID_khoanthu() == idKhoanThu).findFirst().orElse(null);

            // Hiển thị dialog để người dùng nhập thông tin mới cho khoản tiền
            String soTienString = JOptionPane.showInputDialog(frame, "Nhập số tiền mới:");
            double soTien = Double.parseDouble(soTienString);
            String ngayNopString = JOptionPane.showInputDialog(frame, "Nhập ngày nộp mới (yyyy-mm-dd):");
            Date ngayNop = Date.valueOf(ngayNopString);

            // Cập nhật thông tin khoản tiền
            nopTien.setSo_tien(soTien);
            nopTien.setNgay_nop(ngayNop);
            noptienCtrl.capNhatKhoanTien(nopTien);
        }
    }
});

    // Xem danh sách những nhân khẩu có cùng ID khoản thu
    truyXuatButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Hiển thị dialog để người dùng nhập ID khoản thu
        String idKhoanThuString = JOptionPane.showInputDialog(frame, "Nhập ID khoản thu:");
        int idKhoanThu = Integer.parseInt(idKhoanThuString);

        // Lấy danh sách nhân khẩu theo ID khoản thu
        List<tbl_nhankhau> danhSachNhanKhau = noptienCtrl.getNhanKhauByIdKhoanThu(idKhoanThu);

        DefaultListModel<String> model = new DefaultListModel<>();
        for (tbl_nhankhau nhanKhau : danhSachNhanKhau) {
            model.addElement("ID: " + nhanKhau.getID_nhankhau() + ", Họ tên: " + nhanKhau.getHo_ten() + ", ...");
        }

        JList<String> listNhanKhau = new JList<>();
        listNhanKhau.setModel(model);
        JScrollPane scrollPane = new JScrollPane(listNhanKhau);
        scrollPane.setBounds(10, 70, 450, 90);
        panel.add(scrollPane);

        panel.revalidate();
        panel.repaint();
    }
});



}
}
