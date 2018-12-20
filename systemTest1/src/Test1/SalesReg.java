package Test1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SalesReg extends JPanel {
	JLabel lab;
	DefaultTableModel firstTabModel, secTabModel, thrTabModel;
	JTable firstTab, secTab, thrTab;
	JScrollPane firstSc, secSc, thrSc;

	public SalesReg() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// 1
		JPanel p1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p1.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(p1);
		lab = new JLabel("�Ǹŵ��");
		lab.setFont(new Font("����", Font.PLAIN, 18));

		p1.add(lab);

		// 2
		String firstTabName[] = { "�Ǹ�����", "���Ǹűݾ�" };
		Object firstData[][] = { { "2018-11-02", "20,000" } };
		firstTabModel = new DefaultTableModel(firstData, firstTabName);
		firstTab = new JTable(firstTabModel);
		firstSc = new JScrollPane(firstTab);
		firstSc.setPreferredSize(new Dimension(450, 100));
		add(firstSc);

		// 3
		String secTabName[] = { "����", "ǰ��", "����", "������", "�ǸŴܰ�", "���", "����", "���Ǹűݾ�", "���" };
		Object secData[][] = { { "�Ǹ�", "000", "����", "����", "88000", "3", "1", "88000", "���" } };
		secTabModel = new DefaultTableModel(secData, secTabName);
		secTab = new JTable(secTabModel);
		secSc = new JScrollPane(secTab);
		secSc.setPreferredSize(new Dimension(450, 100));
		add(secSc);

		// 4
		String thrTabName[] = { "����", "ǰ��", "����", "������", "�ǸŴܰ�", "����", "���Ǹűݾ�", "����" };
		Object thrData[][] = { { "�Ǹ�", "1", "BK", "S", "5000", "1", "5000", "����" },
				{ "��ǰ", "2", "WH", "M", "7000", "1", "7000", "����" },
				{ "�Ǹ�", "3", "BK", "L", "6000", "1", "6000", "����" } };
		thrTabModel = new DefaultTableModel(thrData, thrTabName);
		thrTab = new JTable(thrTabModel);
		thrSc = new JScrollPane(thrTab);
		add(thrSc);
		
		// table center align
		DefaultTableCellRenderer tCellRenderer = new DefaultTableCellRenderer();
		tCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		TableColumnModel t1ColModel = firstTab.getColumnModel();
		TableColumnModel t2ColModel = secTab.getColumnModel();
		TableColumnModel t3ColModel = thrTab.getColumnModel();

		for (int i = 0; i < t1ColModel.getColumnCount(); i++)
			t1ColModel.getColumn(i).setCellRenderer(tCellRenderer);

		for (int i = 0; i < t2ColModel.getColumnCount(); i++)
			t2ColModel.getColumn(i).setCellRenderer(tCellRenderer);

		for (int i = 0; i < t3ColModel.getColumnCount(); i++)
			t3ColModel.getColumn(i).setCellRenderer(tCellRenderer);

	}
}
