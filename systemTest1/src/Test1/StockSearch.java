package Test1;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class StockSearch extends JPanel {
	JLabel lab;
	DefaultTableModel firstTabModel, secTabModel;
	JTable firstTab, secTab;
	JScrollPane firstSc, secSc;
	private JRadioButton[] rdbtn = new JRadioButton[2];
	private JButton btnSearch;
	String[] radioText = {"���庰", "�����"};
	private JRadioButton rdbtnH;
	private JRadioButton rdbtnJj;
	private JRadioButton rdbtnKk;

	public StockSearch() {
		setLayout(new GridLayout(4, 1, 0, 0));
		
		// 1
		JPanel p1 = new JPanel();
		add(p1);
		lab = new JLabel("�����ȸ");
		lab.setBounds(100, 100, 450, 300);
		p1.add(lab);
		
		// 2
		JPanel p2 = new JPanel();
		add(p2);		
			// radio*
		MyItemListener itemlis = new MyItemListener(); // ������ ������
		ButtonGroup g = new ButtonGroup(); // ���� ��ư ���� �׷�

		for (int i = 0; i < rdbtn.length; i++) {
			rdbtn[i] = new JRadioButton(radioText[i]);
			g.add(rdbtn[i]);
			p2.add(rdbtn[i]); // ���� ��ư �׷쿡 ��ư 2�� �����Ͽ� ����

			rdbtn[i].addItemListener(itemlis); // ������ ����
		}
		rdbtn[0].setSelected(true); // �ش� ��ư�� ���õ� ����	
		
			// btn
		btnSearch = new JButton("��ȸ");
		p2.add(btnSearch);
		
		// 3
		String firstTabName[] = { "ǰ ��", "�ǸŴܰ�" };
		Object firstData[][] = { { "181001", "59,000" } };
		firstTabModel = new DefaultTableModel(firstData, firstTabName);
		firstTab = new JTable(firstTabModel);
		firstSc = new JScrollPane(firstTab);
		add(firstSc);
		
		// 4
		String secTabName[] = { "����","������","�����ڵ�","�����","��ȭ��ȣ","���" };
		Object secData[][] = { { "BK", "S", "H0001", "����â��", "031-777-1111", "5" },
				{ "BK", "M", "H0001", "����â��", "031-777-1111", "4" },
				{ "BK", "S", "S3210", "���ھƱ���", "010-8888-8888", "3" }};
		secTabModel = new DefaultTableModel(secData, secTabName);
		secTab = new JTable(secTabModel);
		secSc = new JScrollPane(secTab);
		add(secSc);
	}

	// radio listener
	class MyItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			if (rdbtn[0].isSelected()) {
				// ���庰
			} else {
				// �����
			}
		}
	}
}
