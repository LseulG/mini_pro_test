package Test1;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SalesReg extends JPanel {
	DefaultTableModel firstTabModel,secTabModel,thrTabModel;
	JTable firstTab, secTab, thrTab;
	JScrollPane firstSc,secSc,thrSc;
	

	public SalesReg() {
		setLayout(null);

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 450, 75);
		add(p1);
		JLabel lblSalesReg = new JLabel("판매등록");
		lblSalesReg.setBounds(12, 40, 53, 15);
		p1.add(lblSalesReg);

		String firstTabName[] = { "판매일자", "총판매금액" };
		Object firstData[][] = { { "2018-11-02", "20,000" } };
		firstTabModel = new DefaultTableModel(firstData, firstTabName);
		firstTab = new JTable(firstTabModel);
		firstSc = new JScrollPane(firstTab);
		firstSc.setBounds(0, 75, 450, 44);
		add(firstSc);
		
		String secTabName[] = { "구분","품번","색상","사이즈","판매단가","재고","수량","실판매금액","등록" };
		Object secData[][] = { { "판매","000","선택","선택","88000","3","1","88000","등록" } };
		secTabModel = new DefaultTableModel(secData, secTabName);
		secTab = new JTable(secTabModel);
		secSc = new JScrollPane(secTab);
		secSc.setBounds(0, 129, 450, 44);
		add(secSc);
		
		String thrTabName[] = { "구분","품번","색상","사이즈","판매단가","수량","실판매금액","삭제" };
		Object thrData[][] = { { "판매","1","BK","S","5000","1","5000","삭제" },
				{ "반품","2","WH","M","7000","1","7000","삭제" },
				{ "판매","3","BK","L","6000","1","6000","삭제" }};
		thrTabModel = new DefaultTableModel(thrData, thrTabName);
		thrTab = new JTable(thrTabModel);
		thrSc = new JScrollPane(thrTab);
		thrSc.setBounds(0, 183, 450, 117);
		add(thrSc);		
	}

}
