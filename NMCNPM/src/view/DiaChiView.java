package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.IllegalFormatWidthException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DiaChiController;
import controller.MainController;
import dao.DiaChiDAO;
import model.DiaChi;
import static view.MainWindow.*;
public class DiaChiView {
	private MainController mainController;
	private MainWindow mainWindow;
    private ArrayList<DiaChi> list;
    DefaultTableModel table;
    JButton ThemDiaChi, XoaDiaChi, TimDiaChi;
    JTable jtable = new JTable();
    JPanel buttonPanel;
    int id = -1, dientich = -1;
	char sophong = 'k';
    DefaultTableModel tableModel = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {
           return false;
        }
    };

    private int i = 1;

    public DiaChiView(MainController mainController) {
        this.mainController = mainController;
        list = new DiaChiDAO().getInstance().selectALL();
        jtable.setModel(tableModel);
        table = (DefaultTableModel) jtable.getModel();
        table.setColumnIdentifiers(new Object[] {
            "STT","ID Địa chỉ", "Số phòng", "Diện tích"
        });
        showTable();
        
        JLabel mainLabel = mainController.getMainWindown().getMainLabel();
        JScrollPane jScrollPane = new JScrollPane(jtable);
        mainLabel.setLayout(new BorderLayout());
        mainLabel.add(jScrollPane, BorderLayout.EAST); 
        
        
        buttonPanel = new JPanel(); 
        buttonPanel.setPreferredSize(new Dimension(720, 50));
        buttonPanel.setLayout(null);
        ThemDiaChi = new JButton("Them dia chi");
        ThemDiaChi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JLabel mainLabel = mainController.getMainWindown().getMainLabel();
				
				
				
				if (e.getSource() == ThemDiaChi) {
					JTable sideTable = new JTable();
					sideTable.setModel(tableModel);
					JTextField IDDiaChi = new JTextField();
					JTextField soPhong = new JTextField();
					JTextField dienTich = new JTextField();
					JLabel labelID = new JLabel("Id");
					JLabel labelsoPhong = new JLabel("So Phong");
					JLabel labeldienTich = new JLabel("Dien tich");
					JPanel sidePanel = new JPanel();
					IDDiaChi.setBounds(80, 120, 200, 30);
					soPhong.setBounds(80, 180, 200, 30);
					dienTich.setBounds(80, 240, 200, 30);
					labelID.setBounds(0, 120, 80, 30);
					labelsoPhong.setBounds(0, 180, 80, 30);
					labeldienTich.setBounds(0, 240, 80, 30);
					sidePanel.setBounds(0, 100, 400, 400);
					sidePanel.add(IDDiaChi);
					sidePanel.add(soPhong);
					sidePanel.add(dienTich);
					sidePanel.add(labeldienTich);
					sidePanel.add(labelID);
					sidePanel.add(labelsoPhong);
					sidePanel.setLayout(null);
					JButton them = new JButton("Them");
					them.setBounds(100, 550, 200, 30);
					buttonPanel.add(them);
					buttonPanel.add(sidePanel);
					buttonPanel.remove(XoaDiaChi);
					buttonPanel.remove(TimDiaChi);
					buttonPanel.remove(ThemDiaChi);
					
					them.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							String idText = IDDiaChi.getText();
							String sophongText = soPhong.getText();
							String dientichText = dienTich.getText();
							System.out.println("idteee" + idText +sophongText + dientichText);
							mainLabel.repaint();
							id = Integer.parseInt(idText);
							sophong = sophongText.charAt(0);
							dientich = Integer.parseInt(dientichText);
							// TODO Auto-generated method stub
							if(e.getSource() == them) {
								
								System.out.println(id + sophong + dientich);
								DiaChi diachi = new DiaChi(id, sophong, dientich);
								DiaChiDAO.getInstance().insert(diachi);
								System.out.println("them thanh cong");
								list.add(DiaChiDAO.getInstance().selectByusername(diachi));
								table.setRowCount(0);
								i = 1;
								showTable();
							}
						}
					});
					mainLabel.repaint();
				}
			}
		});
        ThemDiaChi.setBounds(100, 100, 200, 50);
        
        
        XoaDiaChi = new JButton("Xoa dia chi");
        XoaDiaChi.setBounds(100, 150, 200, 50);;
        
        TimDiaChi = new JButton("Tim dia chi");
        TimDiaChi.setBounds(100, 200, 200, 50);
        
        buttonPanel.add(ThemDiaChi);
        buttonPanel.add(TimDiaChi);
        buttonPanel.add(XoaDiaChi);
        mainLabel.add(buttonPanel, BorderLayout.WEST);
        mainLabel.revalidate(); 
        mainLabel.repaint(); 
    }

    private void showTable() {
        // TODO Auto-generated method stub
        for (DiaChi d : list) {
            table.addRow(new Object[] {
                i++,d.getID_diachi(), d.getSo_phong(), d.getDien_tich()
            });
        }
    }
    private void updateTable() {
    	for (int j = 0; j < 4; j++) {
    		table.removeRow(j);
    	}
    	showTable();
    }

	public JButton getThemDiaChi() {
		return ThemDiaChi;
	}

	public void setThemDiaChi(JButton themDiaChi) {
		ThemDiaChi = themDiaChi;
	}

	public JButton getXoaDiaChi() {
		return XoaDiaChi;
	}

	public void setXoaDiaChi(JButton xoaDiaChi) {
		XoaDiaChi = xoaDiaChi;
	}

	public JButton getTimDiaChi() {
		return TimDiaChi;
	}

	public void setTimDiaChi(JButton timDiaChi) {
		TimDiaChi = timDiaChi;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}
    
}
