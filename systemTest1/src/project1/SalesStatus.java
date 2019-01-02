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
		lab = new JLabel("판매현황");
		p1.add(lab);
		lab.setFont(new Font("굴림", Font.PLAIN, 18));
		 
		// 2
		JPanel p2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) p2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		add(p2);

		dateLab = new JLabel("기 간");
		dateLab.setBounds(100, 100, 450, 300);
		p2.add(dateLab);

			//* 데이터 있는 월만 가져오기 가능?
		yearComboBox = new JComboBox<String>(year);
		p2.add(yearComboBox);
		yearLabel = new JLabel("년 ");
		p2.add(yearLabel);
		
		monthComboBox = new JComboBox<String>(month);
		p2.add(monthComboBox);
		monthLabel = new JLabel("월 ");
		p2.add(monthLabel);

		btnSearch = new JButton("조회");
		btnSearch.addActionListener(this);
		p2.add(btnSearch);
		
		// 임시버튼
		btnEx = new JButton("ex");
		btnEx.addActionListener(this);
		p2.add(btnEx);

		// 3
		String firstTabName[] = { "일자", "요일", "판매수량", "단가금액", "실판매금액", "누적금액(실판매)" };
		Object firstData[][] = new Object[0][6];
		firstTabModel = new DefaultTableModel(firstData, firstTabName) {
			public boolean isCellEditable(int row, int col) {
				return false; // 테이블 수정 못하게
			}
		};
		firstTab = new JTable(firstTabModel);
		firstTab.getTableHeader().setReorderingAllowed(false); // 테이블 열 고정
		firstSc = new JScrollPane(firstTab);
		add(firstSc);

		// 4		
		JPanel p3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) p3.getLayout();
		flowLayout_1.setHgap(20);
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		add(p3);
		
			//* 누적액 총합계 구하기
		totalLab = new JLabel();
		totalLab.setText("총 실판매금액: " + total);
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
			//행 선택시 해당 일자 판매내역 팝업
			OpenStatus op = new OpenStatus();
		}
	}
}