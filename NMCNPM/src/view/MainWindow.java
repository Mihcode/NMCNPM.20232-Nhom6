package view;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.LoginController;
import controller.MainController;

public class MainWindow {
	JFrame frame = new JFrame("Main");
	JPanel mainPanel = new JPanel();
	JLabel mainLabel = new JLabel();
	JButton QLDiaChi, QLNhanKhau, QLHoKhau, QLQuanHe, QLKhoanThu, QLNopTien, back, HomeButton;
	final static int WIDTH = 1080;
	final static int HEIGHT = 720;
	public MainWindow() {
		// TODO Auto-generated constructor stub
		
		
		setJButton();
		setmainLabel();
		setmainFrame();
		
		
		
		
	}
	
	public void setmainLabel() {
		mainPanel.setVisible(true);
		mainLabel.setVisible(true);
		mainPanel.setSize(WIDTH, HEIGHT);
		mainLabel.setSize(WIDTH, HEIGHT);
		mainLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("back.jpg")).getScaledInstance(WIDTH, HEIGHT, 0)));
		mainLabel.add(QLDiaChi);
		mainLabel.add(QLHoKhau);
		mainLabel.add(QLKhoanThu);
		mainLabel.add(QLNhanKhau);
		mainLabel.add(QLNopTien);
		mainLabel.add(QLQuanHe);
		mainLabel.add(back);
		mainLabel.add(HomeButton);
	}
	
	public void setJButton() {
		QLDiaChi = new JButton("Quản lý địa chỉ");
		QLDiaChi.setBounds(30, 50, 200, 50);
		QLNhanKhau = new JButton("Quản lý nhân khẩu");
		QLNhanKhau.setBounds(30, 100, 200, 50);
		QLHoKhau = new JButton("Quản lý hộ khẩu");
		QLHoKhau.setBounds(30, 150, 200, 50);
		QLQuanHe = new JButton("Quản lý quan hệ");
		QLQuanHe.setBounds(30,200, 200, 50);
		QLKhoanThu = new JButton("Quản lý khoản thu");
		QLKhoanThu.setBounds(30, 250, 200, 50);
		QLNopTien = new JButton("Quản lý nộp tiền");
		QLNopTien.setBounds(30,300,200,50);
		back = new JButton("Back");
		HomeButton = new JButton("Back to Home");
		HomeButton.setBounds(0, 0, 100, 30);
		
		ActionListener ac = new MainController(this);
		QLDiaChi.addActionListener(ac);
		QLHoKhau.addActionListener(ac);
		QLNhanKhau.addActionListener(ac);
		QLQuanHe.addActionListener(ac);
		QLKhoanThu.addActionListener(ac);
		QLNopTien.addActionListener(ac);
	}
	public void setmainFrame() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		mainPanel.add(mainLabel);
		frame.add(mainPanel);
		frame.repaint();
	}
	public JButton getQLDiaChi() {
		return QLDiaChi;
	}
	public void setQLDiaChi(JButton qLDiaChi) {
		QLDiaChi = qLDiaChi;
	}
	public JButton getQLNhanKhau() {
		return QLNhanKhau;
	}
	public void setQLNhanKhau(JButton qLNhanKhau) {
		QLNhanKhau = qLNhanKhau;
	}
	public JButton getQLHoKhau() {
		return QLHoKhau;
	}
	public void setQLHoKhau(JButton qLHoKhau) {
		QLHoKhau = qLHoKhau;
	}
	public JButton getQLQuanHe() {
		return QLQuanHe;
	}
	public void setQLQuanHe(JButton qLQuanhe) {
		QLQuanHe = qLQuanhe;
	}
	public JButton getQLKhoanThu() {
		return QLKhoanThu;
	}
	public void setQLKhoanThu(JButton qLKhoanThu) {
		QLKhoanThu = qLKhoanThu;
	}
	public JButton getQLNopTien() {
		return QLNopTien;
	}
	public void setQLNopTien(JButton qLNopTien) {
		QLNopTien = qLNopTien;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JPanel getMainPanel() {
		return mainPanel;
	}
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	public JLabel getMainLabel() {
		return mainLabel;
	}
	public void setMainLabel(JLabel mainLabel) {
		this.mainLabel = mainLabel;
	}
	public JButton getBack() {
		return back;
	}
	public void setBack(JButton back) {
		this.back = back;
	}
	
}
