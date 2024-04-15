package view;

import static view.MainWindow.HEIGHT;
import static view.MainWindow.WIDTH;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.KhoanThuController;
import controller.KhoanThuController;
import dao.KhoanThuDAO;
import model.KhoanThu;
import model.KhoanThu;

public class KhoanThuView {
	private KhoanThuController khoanThuController;
	private MainWindow mainWindow;
	public ArrayList<KhoanThu> list;
	public DefaultTableModel table;
	JButton ThemKhoanThu, XoaKhoanThu, TimKhoanThu;
	JTable jtable = new JTable();
	JLabel buttonLabel;
	DefaultTableModel tableModel = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {
           return false;
        }
    };
    public KhoanThuView(KhoanThuController khoanThuController) {
    	this.khoanThuController = khoanThuController;
    	this.mainWindow = khoanThuController.getMainController().getMainWindown();
    	list = KhoanThuDAO.getInstance().selectALL();
    	jtable.setModel(tableModel);
    	table = (DefaultTableModel) jtable.getModel();
    	table.setColumnIdentifiers(new Object[] {
    			"ID Khoản thu", " Tên khoản thu", "Số tiền", "Loại khoản thu"
, "Đợt thu"    	});
    	showTable(list);
    	
    	JLabel mainLabel = mainWindow.getMainLabel();
        mainLabel.removeAll();
		mainLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(login.class.getResource("back.jpg")).getScaledInstance(WIDTH, HEIGHT, 0)));
		mainLabel.setLayout(null);
		JLabel QLKhoanThuLabel = new JLabel("Quản lý khoản thu");
		Font font = new Font("Arial",Font.BOLD, 30);
		
		QLKhoanThuLabel.setBounds(100, 30, 400, 50);
		QLKhoanThuLabel.setFont(font);
		QLKhoanThuLabel.setForeground(Color.GREEN);
		JButton back = khoanThuController.getMainController().getMainWindown().getBack();
		back.setBounds(400,550,100,30);
		
		
		mainLabel.add(QLKhoanThuLabel);
        JScrollPane jScrollPane = new JScrollPane(jtable);
        mainLabel.setLayout(new BorderLayout());
        mainLabel.add(jScrollPane, BorderLayout.EAST); 
        
        
        buttonLabel = new JLabel(); 
        buttonLabel.setPreferredSize(new Dimension(720, 50));
        buttonLabel.setLayout(null);
        ThemKhoanThu = new JButton("Thêm khoản thu");
        ThemKhoanThu.setBounds(100, 100, 200, 50);
        
        
        XoaKhoanThu = new JButton("Xóa khoản thu");
        XoaKhoanThu.setBounds(100, 150, 200, 50);;
        
        TimKhoanThu = new JButton("Tìm khoản thu");
        TimKhoanThu.setBounds(100, 200, 200, 50);
        
        
        ActionListener ac = new KhoanThuController(this);
        ThemKhoanThu.addActionListener(ac);
        XoaKhoanThu.addActionListener(ac);
        TimKhoanThu.addActionListener(ac);
        back.addActionListener(ac);
        
        buttonLabel.add(ThemKhoanThu);
        buttonLabel.add(TimKhoanThu);
        buttonLabel.add(XoaKhoanThu);
        buttonLabel.add(back);
        mainLabel.add(buttonLabel);
        mainLabel.revalidate(); 
        mainLabel.repaint(); 
    }
    public void showTable(ArrayList<KhoanThu> list) {
        // TODO Auto-generated method stub
        for (KhoanThu k : list) {
            table.addRow(new Object[] {
                k.getID_khoanthu(), k.getTen_khoan_thu(), k.getSo_tien(), k.getLoai_khoan_thu(), k.getDate()
            });
        }
    }
	public KhoanThuController getKhoanThuController() {
		return khoanThuController;
	}
	public void setKhoanThuController(KhoanThuController khoanThuController) {
		this.khoanThuController = khoanThuController;
	}
	public MainWindow getMainWindow() {
		return mainWindow;
	}
	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	public ArrayList<KhoanThu> getList() {
		return list;
	}
	public void setList(ArrayList<KhoanThu> list) {
		this.list = list;
	}
	public DefaultTableModel getTable() {
		return table;
	}
	public void setTable(DefaultTableModel table) {
		this.table = table;
	}
	public JButton getThemKhoanThu() {
		return ThemKhoanThu;
	}
	public void setThemKhoanThu(JButton themKhoanThu) {
		ThemKhoanThu = themKhoanThu;
	}
	public JButton getXoaKhoanThu() {
		return XoaKhoanThu;
	}
	public void setXoaKhoanThu(JButton xoaKhoanThu) {
		XoaKhoanThu = xoaKhoanThu;
	}
	public JButton getTimKhoanThu() {
		return TimKhoanThu;
	}
	public void setTimKhoanThu(JButton timKhoanThu) {
		TimKhoanThu = timKhoanThu;
	}
	public JTable getJtable() {
		return jtable;
	}
	public void setJtable(JTable jtable) {
		this.jtable = jtable;
	}
	public JLabel getButtonLabel() {
		return buttonLabel;
	}
	public void setButtonLabel(JLabel buttonLabel) {
		this.buttonLabel = buttonLabel;
	}
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
    
}
