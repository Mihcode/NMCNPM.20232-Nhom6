package view;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

import dao.UserDAO;

public class login extends JFrame{
//	public login(){
//		JPanel panel1, panel2;
//		JButton button1, button2;
//		JTextField textField1, textField2;
//		JLabel label1, label2, label3, labelBack;
//		JMenu menu, subMenu;
//		JMenuItem i1, i2, i3, i4;
//		JMenuBar menuBar;
//		
//		panel1 = new JPanel();
//		panel2 = new JPanel();
//		panel1.setBounds(0, 0, 240, 300);	
//		panel2.setBounds(240, 0, 480, 300);
//		panel2.setBackground(Color.gray);
//	
//		button1 = new JButton("Login");
//		button1.setBounds(180, 200, 100, 30);
//		button2 = new JButton("Register");
//		button2.setBounds(300, 200, 100, 30);
//		
//		label1 = new JLabel();
//		label2 = new JLabel();
//		label3 = new JLabel();
//		labelBack = new JLabel();
//		labelBack.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("listnhac.png")).getScaledInstance(300, 350, DO_NOTHING_ON_CLOSE)));;
//		
//		label3.setText("Login");
//		label1.setText("User Name:");
//		label2.setText("Password:");
//		label1.setBounds(10, 100, 70, 30);
//		label2.setBounds(10, 150, 70, 30);
//		label3.setBounds(10, 30, 70, 30);
//		labelBack.setBounds(0, 0, 240, 300);
//		
//		textField1 = new JTextField();
//		textField2 = new JTextField();
//		textField1.setBounds(80, 100, 300, 30);
//		textField2.setBounds(80, 150, 300, 30);
//		
//		menu = new JMenu("File");
//		subMenu = new JMenu("Open");
//		menuBar = new JMenuBar();
//		menuBar.setBounds(0, 0, 50, 20);
//		i1 = new JMenuItem("Save");
//		i1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("save.png")).getScaledInstance(30, 30, DO_NOTHING_ON_CLOSE)));;
//		i2 = new JMenuItem("Save as");
//		i2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("saveas.png")).getScaledInstance(30, 30, DO_NOTHING_ON_CLOSE)));
//		i3 = new JMenuItem("Open file");
//		i3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("openfile.png")).getScaledInstance(30, 30, DO_NOTHING_ON_CLOSE)));
//		i4 = new JMenuItem("Open by select");
//		i4.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("opense.png")).getScaledInstance(30, 30, DO_NOTHING_ON_CLOSE)));
//		
//		menuBar.add(menu);
//		menu.add(i1);
//		menu.add(i2);
//		subMenu.add(i3);
//		subMenu.add(i4);
//		menu.add(subMenu);
//		
//		panel2.setLayout(null);
//		panel2.add(button1);
//		panel2.add(button2);
//		panel2.add(label1);
//		panel2.add(label2);
//		panel2.add(label3);
//		panel2.add(textField1);
//		panel2.add(textField2);
//		add(menuBar);
//		panel1.setLayout(null);
//		panel1.add(labelBack);
//		
//	
//	
//		//login
//		button1.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				String userName = textField1.getText();
//				String password = textField2.getText();
//				User user = new User(userName, password);
//				System.out.println(userName + password);
//				boolean check = UserDAO.getInstance().checkExitsUserName(user);
//
//				if(e.getSource() == button1) {
//						if(userName.isBlank() || password.isBlank()) {
//							JOptionPane.showMessageDialog(rootPane, "Khong duoc de trong", "Warning", JOptionPane.ERROR_MESSAGE);
//						}
//						else {
//							if (check == true) {
//								if (password.equals(UserDAO.getInstance().selectByusername(user).getPassword())) {
//									JOptionPane.showMessageDialog(rootPane, "Dang nhap thanh cong");
//								}else {
//									JOptionPane.showMessageDialog(rootPane, "Sai mat khau");
//								}
//							}else {
//								JOptionPane.showMessageDialog(rootPane, "Chua dang ki username, vui long dang ky");
//							}
//						}
//						System.out.println(check);
//					
//				}
//			
//			}});
//			
//		button2.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				String userName = textField1.getText();
//				String password = textField2.getText();
//				User user = new User(userName, password);
//				boolean check = UserDAO.getInstance().checkExitsUserName(user);
//				if(e.getSource() == button2) {
//						if(userName.isBlank() || password.isBlank()) {
//							JOptionPane.showMessageDialog(rootPane, "Khong duoc de trong", "Warning", JOptionPane.ERROR_MESSAGE);
//						}
//						else if(check == false && !userName.isBlank() && !password.isBlank()) {
//							JOptionPane.showMessageDialog(rootPane, "Dang ky thanh cong");
//							UserDAO.getInstance().insert(user);
//							System.out.println(userName);
//						}
//					}
//			}
//		});
//		add(panel1);
//		add(panel2);
//		setLayout(null);
//		setSize(720, 300);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setTitle("Login");
//		//set Icon
//		URL urlIcon = login.class.getResource("phone-icon.png");
//		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon);
//		setIconImage(img);
//	}
}
