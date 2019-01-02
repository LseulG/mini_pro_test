package project1;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SalesStatus extends JPanel implements ActionListener{
	private JLabel lab, dateLab, yearLabel, monthLabel, totalLab;
	private DefaultTableModel firstTabModel;
	private JTable firstTab;
	private JScrollPane firstSc;
	private JComboBox<String> yearComboBox, monthComboBox;
	private JButton btnSearch, btnEx;
	
	private DBcon myDBcon;

	String year[] = { "2018", "2019" };
	String month[] = { "01","02","03","04","05","06","07","08","09","10","11","12"};
	
	String total = "1,406,100";
	
	private void setDBcon(DBcon dbcon) {
		myDBcon = dbcon;
	}
	
	public SalesStatus(DBcon dbcon) {
		setDBcon(dbcon);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// 1
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(p1);
		lab = new JLabel("�Ǹ���Ȳ");
		p1.add(lab);
		lab.setFont(new Font("����", Font.PLAIN, 18));
		 
		// 2
		JPanel p2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) p2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		add(p2);

		dateLab = new JLabel("�� ��");
		dateLab.setBounds(100, 100, 450, 300);
		p2.add(dateLab);

			//* ������ �ִ� ���� �������� ����?
		yearComboBox = new JComboBox<String>(year);
		p2.add(yearComboBox);
		yearLabel = new JLabel("�� ");
		p2.add(yearLabel);
		
		monthComboBox = new JComboBox<String>(month);
		p2.add(monthComboBox);
		monthLabel = new JLabel("�� ");
		p2.add(monthLabel);

		btnSearch = new JButton("��ȸ");
		btnSearch.addActionListener(this);
		p2.add(btnSearch);
		
		// �ӽù�ư
		btnEx = new JButton("ex");
		btnEx.addActionListener(this);
		p2.add(btnEx);

		// 3
		String firstTabName[] = { "����", "����", "�Ǹż���", "�ܰ��ݾ�", "���Ǹűݾ�", "�����ݾ�(���Ǹ�)" };
		Object firstData[][] = new Object[0][6];
		firstTabModel = new DefaultTableModel(firstData, firstTabName) {
			public boolean isCellEditable(int row, int col) {
				return false; // ���̺� ���� ���ϰ�
			}
		};
		firstTab = new JTable(firstTabModel);
		firstTab.getTableHeader().setReorderingAllowed(false); // ���̺� �� ����
		firstSc = new JScrollPane(firstTab);
		add(firstSc);

		// 4		
		JPanel p3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) p3.getLayout();
		flowLayout_1.setHgap(20);
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		add(p3);
		
			//* ������ ���հ� ���ϱ�
		totalLab = new JLabel();
		totalLab.setText("�� ���Ǹűݾ�: " + total);
		p3.add(totalLab);

		// table center align
		DefaultTableCellRenderer tCellRenderer = new DefaultTableCellRenderer();
		tCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		TableColumnModel t1ColModel = firstTab.getColumnModel();

		for (int i = 0; i < t1ColModel.getColumnCount(); i++)
			t1ColModel.getColumn(i).setCellRenderer(tCellRenderer);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String year = (String)yearComboBox.getSelectedItem();
		String month = (String)monthComboBox.getSelectedItem();
		String date = year.substring(2) + month;
		
		if(e.getSource() == btnSearch) {
			myDBcon.clear(firstTab);
			myDBcon.searchStatus(firstTab, date);
		}
		if(e.getSource() == btnEx) {
			//�� ���ý� �ش� ���� �Ǹų��� �˾�
			OpenStatus op = new OpenStatus();
		}
	}
}