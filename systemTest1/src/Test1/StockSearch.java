package Test1;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;

public class StockSearch extends JPanel {
	JLabel lab;
	DefaultTableModel firstTabModel;
	JTable firstTab;
	JScrollPane firstSc;
	private JRadioButton[] rdbtn = new JRadioButton[2];
	private JButton btnSearch;
	String[] radioText = { "���庰", "�����" };
	private JLabel lblCode, lblPrice;
	private JTextField txtCode, txtPrice;

	public StockSearch() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// 1
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(p1);
		lab = new JLabel("�����ȸ");
		p1.add(lab);
		lab.setFont(new Font("����", Font.PLAIN, 18));

		// 2
		JPanel p2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) p2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		add(p2);
		
		lblCode = new JLabel("ǰ��");
		p2.add(lblCode);
		txtCode = new JTextField();
		txtCode.setColumns(10);
		p2.add(txtCode);
		txtCode.setText("code");
		
		lblPrice = new JLabel("�ǸŴܰ�");
		p2.add(lblPrice);
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		p2.add(txtPrice);
		txtPrice.setText("price");
		
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
		String firstTabName[] = { "����", "������", "�����ڵ�", "�����", "��ȭ��ȣ", "���" };
		Object firstData[][] = { { "BK", "S", "H0001", "����â��", "031-777-1111", "5" },
				{ "BK", "M", "H0001", "����â��", "031-777-1111", "4" },
				{ "BK", "S", "S3210", "���ھƱ���", "010-8888-8888", "3" } };
		firstTabModel = new DefaultTableModel(firstData, firstTabName);
		firstTab = new JTable(firstTabModel);
		firstSc = new JScrollPane(firstTab);
		add(firstSc);

		// table center align
		DefaultTableCellRenderer tCellRenderer = new DefaultTableCellRenderer();
		tCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		TableColumnModel t1ColModel = firstTab.getColumnModel();

		for (int i = 0; i < t1ColModel.getColumnCount(); i++)
			t1ColModel.getColumn(i).setCellRenderer(tCellRenderer);
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
