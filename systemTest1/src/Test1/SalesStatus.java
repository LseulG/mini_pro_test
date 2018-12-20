package Test1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class SalesStatus extends JPanel {
	JLabel lab,dateLab,totalLab;
	DefaultTableModel firstTabModel;
	JTable firstTab;
	JScrollPane firstSc;
	private JComboBox<String> dateComboBox;
	private JButton btnSearch;
	
	String date[] = { "2018-09","2018-10","2018-11","2018-12" };
	
	public SalesStatus() {
		setLayout(new GridLayout(4, 1, 0, 0));

		// 1
		JPanel p1 = new JPanel();
		add(p1);
		lab = new JLabel("�Ǹ���Ȳ");
		lab.setBounds(100, 100, 450, 300);
		p1.add(lab);
		
		// 2
		JPanel p2 = new JPanel();
		add(p2);
		
		dateLab = new JLabel("�� ��");
		dateLab.setBounds(100, 100, 450, 300);
		p2.add(dateLab);
		
		dateComboBox = new JComboBox(date);
		p2.add(dateComboBox);
		
		btnSearch = new JButton("��ȸ");
		p2.add(btnSearch);
		
		// 3
		String firstTabName[] = { "����", "����", "����", "�ܰ��ݾ�", "���Ǹűݾ�", "�����ݾ�(���Ǹ�)" };
		Object firstData[][] = { { "2018-09-01", "��", "30", "748,600", "748,600", "748,600" },
				{ "2018-09-02", "��", "25", "668,500", "657,500", "1,406,100" }};
		firstTabModel = new DefaultTableModel(firstData, firstTabName) {
			public boolean isCellEditable(int row, int col) {
				return false; // ���̺� ���� ���ϰ�
			}
		};
		firstTab = new JTable(firstTabModel);
		firstTab.getTableHeader().setReorderingAllowed(false); // �� �̵� �Ұ�
		firstSc = new JScrollPane(firstTab);
		add(firstSc);
		
		// 4
		String te = "1,406,100";
		JPanel p3 = new JPanel();
		add(p3);
		totalLab = new JLabel("�� �� : ");
		totalLab.setText("�� ��: " + te);
		p3.add(totalLab);		
		
	}
}
