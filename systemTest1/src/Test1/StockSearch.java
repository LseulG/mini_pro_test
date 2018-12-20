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
	String[] radioText = {"매장별", "사이즈별"};
	private JRadioButton rdbtnH;
	private JRadioButton rdbtnJj;
	private JRadioButton rdbtnKk;

	public StockSearch() {
		setLayout(new GridLayout(4, 1, 0, 0));
		
		// 1
		JPanel p1 = new JPanel();
		add(p1);
		lab = new JLabel("재고조회");
		lab.setBounds(100, 100, 450, 300);
		p1.add(lab);
		
		// 2
		JPanel p2 = new JPanel();
		add(p2);		
			// radio*
		MyItemListener itemlis = new MyItemListener(); // 아이템 감시자
		ButtonGroup g = new ButtonGroup(); // 라디오 버튼 묶을 그룹

		for (int i = 0; i < rdbtn.length; i++) {
			rdbtn[i] = new JRadioButton(radioText[i]);
			g.add(rdbtn[i]);
			p2.add(rdbtn[i]); // 라디오 버튼 그룹에 버튼 2개 생성하여 부착

			rdbtn[i].addItemListener(itemlis); // 감시자 부착
		}
		rdbtn[0].setSelected(true); // 해당 버튼이 선택된 상태	
		
			// btn
		btnSearch = new JButton("조회");
		p2.add(btnSearch);
		
		// 3
		String firstTabName[] = { "품 번", "판매단가" };
		Object firstData[][] = { { "181001", "59,000" } };
		firstTabModel = new DefaultTableModel(firstData, firstTabName);
		firstTab = new JTable(firstTabModel);
		firstSc = new JScrollPane(firstTab);
		add(firstSc);
		
		// 4
		String secTabName[] = { "색상","사이즈","매장코드","매장명","전화번호","재고" };
		Object secData[][] = { { "BK", "S", "H0001", "본사창고", "031-777-1111", "5" },
				{ "BK", "M", "H0001", "본사창고", "031-777-1111", "4" },
				{ "BK", "S", "S3210", "뉴코아광명", "010-8888-8888", "3" }};
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
				// 매장별
			} else {
				// 사이즈별
			}
		}
	}
}
