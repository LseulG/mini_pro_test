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
		JLabel lblSalesReg = new JLabel("�Ǹŵ��");
		lblSalesReg.setBounds(12, 40, 53, 15);
		p1.add(lblSalesReg);

		String firstTabName[] = { "�Ǹ�����", "���Ǹűݾ�" };
		Object firstData[][] = { { "2018-11-02", "20,000" } };
		firstTabModel = new DefaultTableModel(firstData, firstTabName);
		firstTab = new JTable(firstTabModel);
		firstSc = new JScrollPane(firstTab);
		firstSc.setBounds(0, 75, 450, 44);
		add(firstSc);
		
		String secTabName[] = { "����","ǰ��","����","������","�ǸŴܰ�","���","����","���Ǹűݾ�","���" };
		Object secData[][] = { { "�Ǹ�","000","����","����","88000","3","1","88000","���" } };
		secTabModel = new DefaultTableModel(secData, secTabName);
		secTab = new JTable(secTabModel);
		secSc = new JScrollPane(secTab);
		secSc.setBounds(0, 129, 450, 44);
		add(secSc);
		
		String thrTabName[] = { "����","ǰ��","����","������","�ǸŴܰ�","����","���Ǹűݾ�","����" };
		Object thrData[][] = { { "�Ǹ�","1","BK","S","5000","1","5000","����" },
				{ "��ǰ","2","WH","M","7000","1","7000","����" },
				{ "�Ǹ�","3","BK","L","6000","1","6000","����" }};
		thrTabModel = new DefaultTableModel(thrData, thrTabName);
		thrTab = new JTable(thrTabModel);
		thrSc = new JScrollPane(thrTab);
		thrSc.setBounds(0, 183, 450, 117);
		add(thrSc);		
	}

}
