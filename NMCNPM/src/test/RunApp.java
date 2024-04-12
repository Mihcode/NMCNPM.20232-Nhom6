package test;
import javax.swing.*;

import controller.LoginController;
import view.LoginView;
import view.MainWindow;
import view.login;

public class RunApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		LoginView loginView = new LoginView();
		LoginController loginController = new LoginController(loginView);
	}
}
