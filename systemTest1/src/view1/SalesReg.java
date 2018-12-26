package view1;

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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridLayout;

public class SalesReg extends JPanel {
	DefaultTableModel firstTabModel, secTabModel;
	JTable firstTab, secTab;
	JScrollPane firstSc, secSc;
	private JLabel lab, lblDiv, lblCode, lblColor, lblSize, lblPrice, lblQty, lblSqty, lblSprice;
	private JTextField txtCode, txtPrice, txtQty, txtSqty, txtSprice;
	private JButton btnSearch, btnReg, btnDelete;
	private JComboBox divCB, colorCB, sizeCB;
	
	String divS[] = {"�Ǹ�","��ǰ"};
	String colorS[] = {"����","BK","WH","NV","CR"};
	String sizeS[] = {"����","S","M","L","XL"};	

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
		firstSc.setPreferredSize(new Dimension(450, 80));
		add(firstSc);
		
		// 3 ����
		JPanel panel = new JPanel();	add(panel);
		
		JPanel p2 = new JPanel();
		panel.add(p2);
		p2.setLayout(new GridLayout(2, 9, 0, 5));
			
			// 1��
		lblDiv = new JLabel(" ����");		p2.add(lblDiv);		
		divCB = new JComboBox(divS);
		p2.add(divCB);
		
		lblCode = new JLabel(" ǰ��");	p2.add(lblCode);		
		txtCode = new JTextField();
		txtCode.setText("code");
		p2.add(txtCode);
		
		lblColor = new JLabel(" ����"); 	p2.add(lblColor);		
		colorCB = new JComboBox(colorS);
		p2.add(colorCB);
		
		lblSize = new JLabel(" ������");	p2.add(lblSize);		
		sizeCB = new JComboBox(sizeS);
		p2.add(sizeCB);
		
		btnSearch = new JButton("��ȸ");
		p2.add(btnSearch);
		
			// 2��
		lblPrice = new JLabel(" �ǸŴܰ�");	p2.add(lblPrice);		
		txtPrice = new JTextField();
		txtPrice.setText("price");
		p2.add(txtPrice);
		
		lblQty = new JLabel(" ���");	p2.add(lblQty);		
		txtQty = new JTextField();
		txtQty.setText("qty");
		p2.add(txtQty);
		
		lblSqty = new JLabel(" ����");	p2.add(lblSqty);		
		txtSqty = new JTextField();
		txtSqty.setText("s_qty");
		p2.add(txtSqty);
		
		lblSprice = new JLabel(" ���Ǹűݾ�");	p2.add(lblSprice);		
		txtSprice = new JTextField();
		txtSprice.setText("s_price");
		p2.add(txtSprice);
		
		btnReg = new JButton("���");
		p2.add(btnReg);
				
		// 4		
		String secTabName[] = { "����", "ǰ��", "����", "������", "�ǸŴܰ�", "����", "���Ǹűݾ�"};
		Object secData[][] = { { "�Ǹ�", "1", "BK", "S", "5000", "1", "5000" },
				{ "��ǰ", "2", "WH", "M", "7000", "1", "7000" },
				{ "�Ǹ�", "3", "BK", "L", "6000", "1", "6000" } };
		secTabModel = new DefaultTableModel(secData, secTabName);
		secTab = new JTable(secTabModel);
		secSc = new JScrollPane(secTab);
		add(secSc);
		
		JPanel p3 = new JPanel();
		add(p3);		
		btnDelete = new JButton("����");
		p3.add(btnDelete);

		// table center align
		DefaultTableCellRenderer tCellRenderer = new DefaultTableCellRenderer();
		tCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		TableColumnModel t1ColModel = firstTab.getColumnModel();
		TableColumnModel t2ColModel = secTab.getColumnModel();

		for (int i = 0; i < t1ColModel.getColumnCount(); i++)
			t1ColModel.getColumn(i).setCellRenderer(tCellRenderer);

		for (int i = 0; i < t2ColModel.getColumnCount(); i++)
			t2ColModel.getColumn(i).setCellRenderer(tCellRenderer);
	}
}
