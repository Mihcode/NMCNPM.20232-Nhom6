package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DiaChiDAO;
import model.DiaChi;
import view.DiaChiView;
import view.MainWindow;

public class DiaChiController implements ActionListener{
	private DiaChiView diaChiView;
	private MainController mainController;
	boolean checkClick = false;
	 DefaultTableModel tableModel = new DefaultTableModel() {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	           //all cells false
	           return false;
	        }
	    };
	public DiaChiController(MainController mainController) {
		// TODO Auto-generated constructor stub
		
		this.mainController = mainController;
		diaChiView = new DiaChiView(this);
		
		
	}
	public DiaChiController(DiaChiView diaChiView) {
		this.diaChiView = diaChiView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		MainWindow mainWindow = diaChiView.getMainWindow();
		JRootPane  rootPane = mainWindow.getFrame().getRootPane();
		
		JButton ThemDiaChi = diaChiView.getThemDiaChi();
		JButton XoaDiaChi = diaChiView.getXoaDiaChi();
		JButton TimDiaChi = diaChiView.getTimDiaChi();
		
		JButton back = mainWindow.getBack();
		JLabel buttonLabel = diaChiView.getButtonLabel();
		JLabel mainLabel = mainWindow.getMainLabel();

		JTextField soPhong = new JTextField();
		JTextField dienTich = new JTextField();
		JLabel labelsoPhong = new JLabel("So Phong");
		JLabel labeldienTich = new JLabel("Dien tich");
		
		soPhong.setBounds(80, 180, 200, 30);
		dienTich.setBounds(80, 240, 200, 30);
		labelsoPhong.setBounds(0, 180, 80, 30);
		labeldienTich.setBounds(0, 240, 80, 30);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == back) {
					buttonLabel.removeAll();
					mainLabel.remove(buttonLabel);
					buttonLabel.add(TimDiaChi);
					buttonLabel.add(XoaDiaChi);
					buttonLabel.add(ThemDiaChi);
					buttonLabel.add(back);
					mainLabel.add(buttonLabel);
					mainLabel.repaint();
				}
			}
		});
		if (e.getSource() == ThemDiaChi) {
			buttonLabel.removeAll();
			mainLabel.remove(buttonLabel);
			buttonLabel.add(soPhong);
			buttonLabel.add(dienTich);
			buttonLabel.add(labeldienTich);
			buttonLabel.add(labelsoPhong);
			buttonLabel.setLayout(null);
			JButton them = new JButton("Them");
			them.setBounds(100, 550, 200, 30);
			buttonLabel.add(them);
			buttonLabel.add(back);
			
			
			them.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String sophongText = soPhong.getText();
					String dientichText = dienTich.getText();
					String sophong = sophongText;
					int dientich = Integer.parseInt(dientichText);
					// TODO Auto-generated method stub
					if(e.getSource() == them) {
						DiaChi diachi = new DiaChi(sophong, dientich);
						if (DiaChiDAO.getInstance().checkExit(diachi) == true) {
							JOptionPane.showMessageDialog(rootPane, "Da co phong " + diachi.getSo_phong(),"Alert", JOptionPane.ERROR_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(rootPane, "Them thanh cong ");
							DiaChiDAO.getInstance().insert(diachi);
							diaChiView.list = DiaChiDAO.getInstance().selectALL();
							diaChiView.table.setRowCount(0);
							diaChiView.showTable(diaChiView.getList());
							soPhong.setText("");
							dienTich.setText("");
						}
						mainLabel.repaint();
					}
				}
			});

		}
						
		if (e.getSource() == XoaDiaChi) {
			buttonLabel.removeAll();
			buttonLabel.add(soPhong);
			buttonLabel.add(labelsoPhong);
			buttonLabel.setLayout(null);
			JButton xoa = new JButton("Xoa");
			xoa.setBounds(100, 550, 200, 30);
			buttonLabel.add(xoa);
			buttonLabel.add(back);
			
			xoa.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String sophongText = soPhong.getText();
						String sophong = sophongText;
						// TODO Auto-generated method stub
						if(e.getSource() == xoa) {
							DiaChi diachi = new DiaChi(sophong, 0);
							if (DiaChiDAO.getInstance().checkExit(diachi) == true) {
								JOptionPane.showMessageDialog(rootPane, "Da xoa phong " + diachi.getSo_phong(),"", JOptionPane.ERROR_MESSAGE);
								DiaChiDAO.getInstance().delete(diachi);
								diaChiView.list = DiaChiDAO.getInstance().selectALL();
								diaChiView.table.setRowCount(0);
								diaChiView.showTable(diaChiView.getList());
							}else {
								JOptionPane.showMessageDialog(rootPane, "Khong co phong " + diachi.getSo_phong());
								
							}
							mainLabel.repaint();
						}
							}
						});		
					}
		if (e.getSource() == TimDiaChi) {
			buttonLabel.removeAll();
			buttonLabel.add(soPhong);
			buttonLabel.add(labelsoPhong);
			buttonLabel.setLayout(null);
			JButton tim = new JButton("Tim");
			tim.setBounds(100, 550, 200, 30);
			buttonLabel.add(tim);
			buttonLabel.add(back);
			tim.addActionListener(new ActionListener() {
							
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String sophongText = soPhong.getText();
						String sophong = sophongText;
						// TODO Auto-generated method stub
						if(e.getSource() == tim) {
							DiaChi diachi = new DiaChi(sophong, -1);
							if (DiaChiDAO.getInstance().checkExit(diachi) == true) {
								JOptionPane.showMessageDialog(rootPane, "Da tim thay phong " + diachi.getSo_phong());
								ArrayList<DiaChi> temp = new ArrayList<DiaChi>();
								temp.add(DiaChiDAO.getInstance().selectByusername(diachi));
								diaChiView.table.setRowCount(0);
								diaChiView.showTable(temp);
							}else {
								JOptionPane.showMessageDialog(rootPane, "Khong tim thay phong " + diachi.getSo_phong());
								
							}
							mainLabel.repaint();
						}
						
					}
			});
					}
		mainLabel.add(buttonLabel);
		mainLabel.repaint();
	}
	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
}


