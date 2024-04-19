package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.UserDAO;
import model.User;
import view.LoginView;
import view.MainWindow;

public class LoginController implements ActionListener, KeyListener {
	private LoginView login;
	public boolean enterPressed = false;
	private boolean LoginAccess = false;
	public LoginController(LoginView login) {
		this.login = login;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sourceObject = e.getActionCommand();
		System.out.println("Ban da nhan nut "  +sourceObject);
		String userName = login.getTextField1().getText();
		String password = login.getTextField2().getText();
		User user = new User(userName, password);
		System.out.println(userName + " " + password);
		boolean check = UserDAO.getInstance().checkExit(user);
		if(e.getSource() == login.getLogin() || enterPressed == true) {
			if(userName.isBlank() || password.isBlank()) {
				JOptionPane.showMessageDialog(login.getFrame().getRootPane(), "Khong duoc de trong", "Warning", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (check == true) {
					if (password.equals(UserDAO.getInstance().selectByusername(user).getPassword())) {
						JOptionPane.showMessageDialog(login.getFrame().getRootPane(), "Dang nhap thanh cong");
						LoginAccess = true;
						if (LoginAccess == true) {
							login.getFrame().setVisible(false);
							new MainWindow();
						}
					}else {
						JOptionPane.showMessageDialog(login.getFrame().getRootPane(), "Sai mat khau");
					}
				}else {
					JOptionPane.showMessageDialog(login.getFrame().getRootPane(), "Chua dang ki username, vui long dang ky");
				}
			}
		}
			else if(e.getSource() == login.getRegister()) {
				if(userName.isBlank() || password.isBlank()) {
					JOptionPane.showMessageDialog(login.getFrame().getRootPane(), "Khong duoc de trong", "Warning", JOptionPane.ERROR_MESSAGE);
				}
				else if(check == false && !userName.isBlank() && !password.isBlank()) {
					JOptionPane.showMessageDialog(login.getFrame().getRootPane(), "Dang ky thanh cong");
					UserDAO.getInstance().insert(user);
					System.out.println(userName);
				}
			}
		
	}
	public LoginView getLogin() {
		return login;
	}
	public void setLogin(LoginView login) {
		this.login = login;
	}
	public boolean isLoginAccess() {
		return LoginAccess;
	}
	public void setLoginAccess(boolean loginAccess) {
		LoginAccess = loginAccess;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = true;
			System.out.println("Da an ENter");
		}
		}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	}
	
