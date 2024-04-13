package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.DiaChiView;
import view.MainWindow;

public class MainController implements ActionListener {
	private MainWindow mainWindown;
	public MainController(MainWindow mainWindow) {
		this.mainWindown = mainWindow;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String src = e.getActionCommand();
		if (e.getSource() == mainWindown.getQLDiaChi()) {
			System.out.println("Dang vao " + src);
			new DiaChiController(this);
		} else if (e.getSource() == mainWindown.getQLHoKhau()) {
			System.out.println("Dang vao " + src);

		}else if (e.getSource() == mainWindown.getQLKhoanThu()) {
			System.out.println("Dang vao " + src);

		}else if (e.getSource() == mainWindown.getQLNhanKhau()) {
			System.out.println("Dang vao " + src);

		}else if (e.getSource() == mainWindown.getQLNopTien()) {
			System.out.println("Dang vao " + src);

		}else if (e.getSource() == mainWindown.getQLQuanHe()) {
			System.out.println("Dang vao " + src);

		}
	}
	public MainWindow getMainWindown() {
		return mainWindown;
	}
	public void setMainWindown(MainWindow mainWindown) {
		this.mainWindown = mainWindown;
	}
	
}
