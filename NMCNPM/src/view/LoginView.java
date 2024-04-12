package view;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

import controller.LoginController;
import dao.UserDAO;
import model.User;

public class LoginView extends JFrame{
	JPanel panel1, panel2;
	JButton Login, Register;
	JTextField textField1, textField2;
	JLabel label1, label2, label3, labelBack;
	JMenu menu, subMenu;
	JMenuItem i1, i2, i3, i4;
	JMenuBar menuBar;
	JFrame frame = this;
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JButton getLogin() {
		return Login;
	}

	public void setLogin(JButton login) {
		Login = login;
	}

	public JButton getRegister() {
		return Register;
	}

	public void setRegister(JButton register) {
		Register = register;
	}

	public JTextField getTextField1() {
		return textField1;
	}

	public void setTextField1(JTextField textField1) {
		this.textField1 = textField1;
	}

	public JTextField getTextField2() {
		return textField2;
	}

	public void setTextField2(JTextField textField2) {
		this.textField2 = textField2;
	}

	public JLabel getLabel1() {
		return label1;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	public JLabel getLabel2() {
		return label2;
	}

	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}

	public JLabel getLabel3() {
		return label3;
	}

	public void setLabel3(JLabel label3) {
		this.label3 = label3;
	}

	public JLabel getLabelBack() {
		return labelBack;
	}

	public void setLabelBack(JLabel labelBack) {
		this.labelBack = labelBack;
	}

	public JMenu getMenu() {
		return menu;
	}

	public void setMenu(JMenu menu) {
		this.menu = menu;
	}

	public JMenu getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(JMenu subMenu) {
		this.subMenu = subMenu;
	}

	public JMenuItem getI1() {
		return i1;
	}

	public void setI1(JMenuItem i1) {
		this.i1 = i1;
	}

	public JMenuItem getI2() {
		return i2;
	}

	public void setI2(JMenuItem i2) {
		this.i2 = i2;
	}

	public JMenuItem getI3() {
		return i3;
	}

	public void setI3(JMenuItem i3) {
		this.i3 = i3;
	}

	public JMenuItem getI4() {
		return i4;
	}

	public void setI4(JMenuItem i4) {
		this.i4 = i4;
	}

	public LoginView(){
		
		setBounds(200, 120, 720, 360);
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setBounds(0, 0, 240, 300);	
		panel2.setBounds(240, 0, 480, 300);
		panel2.setBackground(Color.gray);
	
		Login = new JButton("Login");
		Login.setBounds(180, 200, 100, 30);
		Register = new JButton("Register");
		Register.setBounds(300, 200, 100, 30);
		
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		labelBack = new JLabel();
		labelBack.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("listnhac.png")).getScaledInstance(300, 350, DO_NOTHING_ON_CLOSE)));;
		
		label3.setText("Login");
		label1.setText("User Name:");
		label2.setText("Password:");
		label1.setBounds(10, 100, 70, 30);
		label2.setBounds(10, 150, 70, 30);
		label3.setBounds(10, 30, 70, 30);
		labelBack.setBounds(0, 0, 240, 300);
		
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField1.setBounds(80, 100, 300, 30);
		textField2.setBounds(80, 150, 300, 30);
		
		menu = new JMenu("File");
		subMenu = new JMenu("Open");
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 50, 20);
		i1 = new JMenuItem("Save");
		i1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("save.png")).getScaledInstance(30, 30, DO_NOTHING_ON_CLOSE)));;
		i2 = new JMenuItem("Save as");
		i2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("saveas.png")).getScaledInstance(30, 30, DO_NOTHING_ON_CLOSE)));
		i3 = new JMenuItem("Open file");
		i3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("openfile.png")).getScaledInstance(30, 30, DO_NOTHING_ON_CLOSE)));
		i4 = new JMenuItem("Open by select");
		i4.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("opense.png")).getScaledInstance(30, 30, DO_NOTHING_ON_CLOSE)));
		
		menuBar.add(menu);
		menu.add(i1);
		menu.add(i2);
		subMenu.add(i3);
		subMenu.add(i4);
		menu.add(subMenu);
		
		panel2.setLayout(null);
		panel2.add(Login);
		panel2.add(Register);
		panel2.add(label1);
		panel2.add(label2);
		panel2.add(label3);
		panel2.add(textField1);
		panel2.add(textField2);
		add(menuBar);
		panel1.setLayout(null);
		panel1.add(labelBack);
		
		ActionListener ac = new LoginController(this);
		Login.addActionListener(ac);
		Register.addActionListener(ac);
	
		add(panel1);
		add(panel2);
		setLayout(null);
		setLocationRelativeTo(null);
		setSize(720, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login");
		//set Icon
		URL urlIcon = login.class.getResource("phone-icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
		setIconImage(img);
	}
	
}
