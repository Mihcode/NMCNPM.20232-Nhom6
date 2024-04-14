package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.IllegalFormatWidthException;

import javax.swing.ImageIcon;
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
	private DiaChiController diaChiController;
	private MainWindow mainWindow;
    public ArrayList<DiaChi> list;
    public DefaultTableModel table;
    JButton ThemDiaChi, XoaDiaChi, TimDiaChi;
    JTable jtable = new JTable();
    JLabel buttonLabel;
    int id, dientich;
    char sophong;
    DefaultTableModel tableModel = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {
           return false;
        }
    };


    public DiaChiView(DiaChiController diaChiController) {
    	this.diaChiController = diaChiController;
    	this.mainWindow = diaChiController.getMainController().getMainWindown();
        list = DiaChiDAO.getInstance().selectALL();
        jtable.setModel(tableModel);
        table = (DefaultTableModel) jtable.getModel();
        table.setColumnIdentifiers(new Object[] {
            "ID Địa chỉ", "Số phòng", "Diện tích"
        });
        showTable(list);
        
        JLabel mainLabel = mainWindow.getMainLabel();
        mainLabel.removeAll();
		mainLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("back.jpg")).getScaledInstance(WIDTH, HEIGHT, 0)));
		mainLabel.setLayout(null);
		JLabel QLDiaChiLabel = new JLabel("Quản lý địa chỉ");
		Font font = new Font("Arial",Font.BOLD, 30);
		
		QLDiaChiLabel.setBounds(100, 30, 400, 50);
		QLDiaChiLabel.setFont(font);
		QLDiaChiLabel.setForeground(Color.GREEN);
		JButton back = diaChiController.getMainController().getMainWindown().getBack();
		back.setBounds(400,550,100,30);
		
		
		mainLabel.add(QLDiaChiLabel);
        JScrollPane jScrollPane = new JScrollPane(jtable);
        mainLabel.setLayout(new BorderLayout());
        mainLabel.add(jScrollPane, BorderLayout.EAST); 
        
        
        buttonLabel = new JLabel(); 
        buttonLabel.setPreferredSize(new Dimension(720, 50));
        buttonLabel.setLayout(null);
        ThemDiaChi = new JButton("Them dia chi");
        ThemDiaChi.setBounds(100, 100, 200, 50);
        
        
        XoaDiaChi = new JButton("Xoa dia chi");
        XoaDiaChi.setBounds(100, 150, 200, 50);;
        
        TimDiaChi = new JButton("Tim dia chi");
        TimDiaChi.setBounds(100, 200, 200, 50);
        
        
        ActionListener ac = new DiaChiController(this);
        ThemDiaChi.addActionListener(ac);
        XoaDiaChi.addActionListener(ac);
        TimDiaChi.addActionListener(ac);
        back.addActionListener(ac);
        
        buttonLabel.add(ThemDiaChi);
        buttonLabel.add(TimDiaChi);
        buttonLabel.add(XoaDiaChi);
        buttonLabel.add(back);
        mainLabel.add(buttonLabel);
        mainLabel.revalidate(); 
        mainLabel.repaint(); 
    }

    public void showTable(ArrayList<DiaChi> list) {
        // TODO Auto-generated method stub
        for (DiaChi d : list) {
            table.addRow(new Object[] {
                d.getID_diachi(), d.getSo_phong(), d.getDien_tich()
            });
        }
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

	

	public JLabel getButtonLabel() {
		return buttonLabel;
	}

	public void setButtonLabel(JLabel buttonLabel) {
		this.buttonLabel = buttonLabel;
	}

	public DiaChiController getDiaChiController() {
		return diaChiController;
	}

	public void setDiaChiController(DiaChiController diaChiController) {
		this.diaChiController = diaChiController;
	}

	public ArrayList<DiaChi> getList() {
		return list;
	}

	public void setList(ArrayList<DiaChi> list) {
		this.list = list;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
    
}
