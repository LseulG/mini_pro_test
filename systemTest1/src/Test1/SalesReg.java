package Test1;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SalesReg extends JFrame implements ActionListener {

	public static void main(String[] args) {
		new SalesReg();
	}
	
	public SalesReg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		add(new SalesReg_p());
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

class SalesReg_p extends JPanel{
	
	private JTable firstTab, secTab, thrTab;
	DefaultTableModel firstTabModel, secTabModel, thrTabModel;
	
	public SalesReg_p() {
		setLayout(new GridLayout(4, 1, 0, 0));		
		
		JPanel p1 = new JPanel();
		add(p1);
		p1.setLayout(null);
		JLabel lblSalesReg = new JLabel("판매등록");
		lblSalesReg.setBounds(12, 40, 53, 15);
		p1.add(lblSalesReg);		
		JButton btnNewButton = new JButton("등록");
		btnNewButton.setBounds(123, 36, 97, 23);
		p1.add(btnNewButton);
		
		String firstTabName[] = { "판매일자", "총판매금액" };
		Object firstData[][] = {{"2018-11-02", "20,000"}};
		firstTabModel = new DefaultTableModel(firstData,firstTabName);
		firstTab = new JTable(firstTabModel);
		JScrollPane firstSc = new JScrollPane(firstTab);
		add(firstSc);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);		
		String secTabName[] = { "판매일자", "총판매금액" };
		Object secData[][] = {{"2018-11-02", "20,000"}};
		secTabModel = new DefaultTableModel(secData,secTabName);
		secTab = new JTable(secTabModel);
		scrollPane.setViewportView(secTab);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1);
		String thrTabName[] = { "판매일자", "총판매금액" };
		Object thrData[][] = {{"2018-11-02", "20,000"}};
		thrTabModel = new DefaultTableModel(thrData,thrTabName);
		thrTab = new JTable(thrTabModel);
		scrollPane_1.setViewportView(thrTab);
	}
}
