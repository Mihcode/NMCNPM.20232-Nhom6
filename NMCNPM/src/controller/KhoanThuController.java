package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import dao.KhoanThuDAO;
import model.KhoanThu;
import view.KhoanThuView;
import view.MainWindow;
import java.lang.Double;

public class KhoanThuController implements ActionListener{
	private MainController mainController;
	private KhoanThuView khoanThuView;
	public KhoanThuController(MainController mainController) {
		// TODO Auto-generated constructor stub
		this.mainController = mainController;
		khoanThuView = new KhoanThuView(this);
	}
	public KhoanThuController(KhoanThuView khoanThuView) {
		this.khoanThuView = khoanThuView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		MainWindow mainWindow = khoanThuView.getMainWindow();
		JRootPane  rootPane = mainWindow.getFrame().getRootPane();
		
		JButton ThemkhoanThu = khoanThuView.getThemKhoanThu();
		JButton XoakhoanThu = khoanThuView.getXoaKhoanThu();
		JButton TimkhoanThu = khoanThuView.getTimKhoanThu();
		
		JButton back = mainWindow.getBack();
		JLabel buttonLabel = khoanThuView.getButtonLabel();
		JLabel mainLabel = mainWindow.getMainLabel();

		JTextField TEXTFIELDtenkhoanthu = new JTextField();
		JTextField TEXTFIELDsotien = new JTextField();
		JTextField TEXTFIELDdotthu = new JTextField();
		String loaikhoanthutype[] = {"Bắt buộc", "Tự nguyện"};
		JComboBox COMBOBOXloaikhoanthu = new JComboBox(loaikhoanthutype);
		
		JLabel LABELtenkhoanthu = new JLabel("Tên khoản thu");
		JLabel LABELsotien = new JLabel("Số tiền");
		JLabel LABELloaikhoanthu = new JLabel("Loại khoản thu");
		JLabel LABELdotthu = new JLabel("Đợt thu");
		
		TEXTFIELDtenkhoanthu.setBounds(80, 180, 200, 30);
		TEXTFIELDsotien.setBounds(80, 240, 200, 30);
		COMBOBOXloaikhoanthu.setBounds(80, 320, 200, 30);
		TEXTFIELDdotthu.setBounds(80, 400, 200, 30);
		LABELtenkhoanthu.setBounds(0, 180, 80, 30);
		LABELsotien.setBounds(0, 240, 80, 30);
		LABELloaikhoanthu.setBounds(0, 320, 80, 30);
		LABELdotthu.setBounds(0, 400, 80, 30);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == back) {
					buttonLabel.removeAll();
					mainLabel.remove(buttonLabel);
					buttonLabel.add(TimkhoanThu);
					buttonLabel.add(XoakhoanThu);
					buttonLabel.add(ThemkhoanThu);
					buttonLabel.add(back);
					mainLabel.add(buttonLabel);
					mainLabel.repaint();
				}
			}
		});
		if (e.getSource() == ThemkhoanThu) {
			buttonLabel.removeAll();
			mainLabel.remove(buttonLabel);
			buttonLabel.add(TEXTFIELDtenkhoanthu);
			buttonLabel.add(TEXTFIELDsotien);
			buttonLabel.add(TEXTFIELDdotthu);
			buttonLabel.add(COMBOBOXloaikhoanthu);
			buttonLabel.add(LABELdotthu);
			buttonLabel.add(LABELloaikhoanthu);
			buttonLabel.add(LABELsotien);
			buttonLabel.add(LABELtenkhoanthu);
			buttonLabel.setLayout(null);
			JButton them = new JButton("Them");
			them.setBounds(100, 550, 200, 30);
			buttonLabel.add(them);
			buttonLabel.add(back);
			
			
			them.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String TEXTtenkhoanthu = TEXTFIELDtenkhoanthu.getText();
					String TEXTsotien = TEXTFIELDsotien.getText();
					String TEXTdotthu = TEXTFIELDdotthu.getText();
					String TEXTloaikhoanthu =  "" + COMBOBOXloaikhoanthu.getItemAt(COMBOBOXloaikhoanthu.getSelectedIndex());
					
					double sotien = Double.parseDouble(TEXTsotien);
					int khoanthu;
					if(TEXTloaikhoanthu == "Tự nguyện") {
						khoanthu = 0;
					}else {
						khoanthu = 1;
					}
					// TODO Auto-generated method stub
					if(e.getSource() == them) {
						KhoanThu khoanThu = new KhoanThu(TEXTtenkhoanthu, sotien, khoanthu, TEXTdotthu);
						if (KhoanThuDAO.getInstance().checkExit(khoanThu) == true) {
							JOptionPane.showMessageDialog(rootPane, "Da co phong " + khoanThu.getTen_khoan_thu(),"Alert", JOptionPane.ERROR_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(rootPane, "Them thanh cong ");
							KhoanThuDAO.getInstance().insert(khoanThu);
							khoanThuView.list = KhoanThuDAO.getInstance().selectALL();
							khoanThuView.table.setRowCount(0);
							khoanThuView.showTable(khoanThuView.getList());
							TEXTFIELDsotien.setText("");
							TEXTFIELDdotthu.setText("");
							TEXTFIELDtenkhoanthu.setText("");
						}
						mainLabel.repaint();
					}
				}
			});

		}
						
		if (e.getSource() == XoakhoanThu) {
			buttonLabel.removeAll();
			buttonLabel.add(TEXTFIELDtenkhoanthu);
			buttonLabel.add(LABELtenkhoanthu);
			buttonLabel.setLayout(null);
			JButton xoa = new JButton("Xoa");
			xoa.setBounds(100, 550, 200, 30);
			buttonLabel.add(xoa);
			buttonLabel.add(back);
			
			xoa.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String TEXTtenkhoanthu = TEXTFIELDtenkhoanthu.getText();
					
					// TODO Auto-generated method stub
					if(e.getSource() == xoa) {
						KhoanThu khoanThu = new KhoanThu(TEXTtenkhoanthu, -1, -1, "-1");
						if (KhoanThuDAO.getInstance().checkExit(khoanThu) == true) {
							JOptionPane.showMessageDialog(rootPane, "Xoa Thanh Cong  ");
							KhoanThuDAO.getInstance().delete(khoanThu);
							khoanThuView.list = KhoanThuDAO.getInstance().selectALL();
							khoanThuView.table.setRowCount(0);
							khoanThuView.showTable(khoanThuView.getList());
							TEXTFIELDtenkhoanthu.setText("");
						}else {
							
							JOptionPane.showMessageDialog(rootPane, "Khong co khoan thu " + khoanThu.getTen_khoan_thu(),"Alert", JOptionPane.ERROR_MESSAGE);
						}
						mainLabel.repaint();
					}
				}
			});
					}
		if (e.getSource() == TimkhoanThu) {
			buttonLabel.removeAll();
			buttonLabel.add(TEXTFIELDtenkhoanthu);
			buttonLabel.add(LABELtenkhoanthu);
			buttonLabel.setLayout(null);
			JButton tim = new JButton("Tim");
			tim.setBounds(100, 550, 200, 30);
			buttonLabel.add(tim);
			buttonLabel.add(back);
			tim.addActionListener(new ActionListener() {
							
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String TEXTtenkhoanthu = TEXTFIELDtenkhoanthu.getText();
						// TODO Auto-generated method stub
						if(e.getSource() == tim) {
							KhoanThu khoanThu = new KhoanThu(TEXTtenkhoanthu, -1, -1, "-1");
							if (KhoanThuDAO.getInstance().checkExit(khoanThu) == true) {
								JOptionPane.showMessageDialog(rootPane, "Da tim thay khoan thu " + khoanThu.getTen_khoan_thu());
								ArrayList<KhoanThu> temp = new ArrayList<KhoanThu>();
								temp.add(KhoanThuDAO.getInstance().selectByusername(khoanThu));
								khoanThuView.table.setRowCount(0);
								khoanThuView.showTable(temp);
							}else {
								JOptionPane.showMessageDialog(rootPane, "Khong tim thay khoan thu " + khoanThu.getTen_khoan_thu());
								
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
	public KhoanThuView getKhoanThuView() {
		return khoanThuView;
	}
	public void setKhoanThuView(KhoanThuView khoanThuView) {
		this.khoanThuView = khoanThuView;
	}
}
