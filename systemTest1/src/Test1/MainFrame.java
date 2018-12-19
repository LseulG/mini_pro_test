package Test1;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener{
	
	CardLayout card = new CardLayout();
	JPanel contentPane;
	JMenuItem mLogout, mNewProdReg, mProdInfoModify, mAccount, mSalesReg, mSalesStatus, mStock;
	private JTextField txtMainPage;
	
	public MainFrame() {
					
		initMenu(); // �޴��� ��������
		

		//
		
		
		setVisible(true);
	}
	
	public void initMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(card); 

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// action_1
		JMenu mMenu = new JMenu("�޴�");
		menuBar.add(mMenu);
		
		mLogout.addActionListener(this);
		mLogout = new JMenuItem("�α׾ƿ�");
		mMenu.add(mLogout);
		
		JSeparator separator = new JSeparator();
		mMenu.add(separator);
		
		mNewProdReg.addActionListener(this);
		mNewProdReg = new JMenuItem("�Ż�ǰ ���");
		mMenu.add(mNewProdReg);
		
		mProdInfoModify.addActionListener(this);
		mProdInfoModify = new JMenuItem("��ǰ���� ����");
		mMenu.add(mProdInfoModify);
		
		mAccount.addActionListener(this);
		mAccount = new JMenuItem("���� ��ȸ/����");
		mMenu.add(mAccount);
		
		// action_2
		JMenu mSalesmenu = new JMenu("�ǸŰ���");
		menuBar.add(mSalesmenu);
		
		mSalesReg.addActionListener(this);
		mSalesReg = new JMenuItem("�Ǹŵ��");
		mSalesmenu.add(mSalesReg);
		
		mSalesStatus.addActionListener(this);
		mSalesStatus = new JMenuItem("�Ǹ���Ȳ");
		mSalesmenu.add(mSalesStatus);
		
		// action_3
		JMenu mStockmenu = new JMenu("�������");
		menuBar.add(mStockmenu);
		
		mStock.addActionListener(this);
		mStock = new JMenuItem("�����ȸ");
		mStockmenu.add(mStock);
		
		contentPane.add("mSalesReg", new SalesReg());
		
		add(contentPane);
		setVisible(true);
				
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == mLogout) {
			int result;
			String[] option = {"��", "�ƴϿ�"};
			result = JOptionPane.showOptionDialog(this, "�α׾ƿ� �Ͻðڽ��ϱ�?", "logout", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
					null, option, option[1]);
			
			if(result == 0) {
				// ��
				// �α��� ȭ������ �̵�
				dispose();
			} else {
				// �ƴϿ�
			}			
		} // logout end
		
		if(e.getSource() == mSalesReg) {
			card.show(contentPane, "mSalesReg");
		} else if (e.getSource() == mSalesStatus) {
			card.show(contentPane, "mSalesStatus");
		}
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
}