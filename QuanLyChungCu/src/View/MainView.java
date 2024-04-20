import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {
    private JFrame frame;

    public MainView() {
        frame = new JFrame("Chung cư BlueMoon");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton nhanKhauButton = new JButton("Nhân khẩu");
        nhanKhauButton.setBounds(50, 50, 200, 25);
        panel.add(nhanKhauButton);

        JButton nopTienButton = new JButton("Nộp tiền");
        nopTienButton.setBounds(50, 100, 200, 25);
        panel.add(nopTienButton);

        nhanKhauButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mở cửa sổ mới khi nhấn vào tùy chọn Nhân khẩu
                new NhankhauView();
            }
        });

        nopTienButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mở cửa sổ mới khi nhấn vào tùy chọn Nộp tiền
                 new NoptienView();
            }
        });
    }

    public static void main(String[] args) {
        new MainView();
    }
}
