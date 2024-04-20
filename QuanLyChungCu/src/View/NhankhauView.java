import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class NhankhauView {
    private JFrame frame;

    public NhankhauView() {
        frame = new JFrame("Nhân khẩu");
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

        JButton themButton = new JButton("Thêm");
        themButton.setBounds(35, 100, 95, 75); 
        panel.add(themButton);

        JButton xemButton = new JButton("Xem");
        xemButton.setBounds(140, 100, 95, 75); 
        panel.add(xemButton);

        JButton suaButton = new JButton("Sửa");
        suaButton.setBounds(245, 100, 95, 75); 
        panel.add(suaButton);

        JButton xoaButton = new JButton("Xóa");
        xoaButton.setBounds(350, 100, 95, 75); 
        panel.add(xoaButton);


        themButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Them();
            }
        });

        xemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Xem();
            }
        });
        
         suaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Sua();
            }
        });
         
          xoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Xoa();
            }
        });

    }
}
