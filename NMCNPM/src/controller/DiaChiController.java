package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import view.DiaChiView;
import view.MainWindow;

public class DiaChiController implements ActionListener{
	public DiaChiView diaChiView;
	private MainController mainController;
	 DefaultTableModel tableModel = new DefaultTableModel() {

	        @Override
	        public boolean isCellEditable(int row, int column) {
	           //all cells false
	           return false;
	        }
	    };
	public DiaChiController( MainController mainController) {
		// TODO Auto-generated constructor stub

		this.mainController = mainController;
		
		mainController.getMainWindown().getMainLabel().removeAll();
		JLabel QLDiaChiLabel = new JLabel("Quản lý địa chỉ");
		Font font = new Font("Arial",Font.BOLD, 30);
		QLDiaChiLabel.setBounds(100, 30, 400, 50);
		QLDiaChiLabel.setFont(font);
		QLDiaChiLabel.setForeground(Color.GREEN);
		mainController.getMainWindown().getMainLabel().add(QLDiaChiLabel);
		DiaChiView diaChiView = new DiaChiView(mainController);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
