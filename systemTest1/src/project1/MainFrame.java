package project1;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{

	private DBcon myDBcon;
	
	JPanel contentPane;
	JMenu mSalesmenu, mStockmenu,mAdmMenu,mLogoutMenu;
	JMenuItem mSalesReg, mSalesStatus,mStock, mLogout,mNewProdReg,mProdInfoModify,mAccount;
	CardLayout card = new CardLayout();
	
	public MainFrame(DBcon dbcon) {
		setDBcon(dbcon);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				int dialogResult = JOptionPane.showConfirmDialog(contentPane, "���� �Ͻðڽ��ϱ�?", "exit", 
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(dialogResult == 0) { // ��  
					myDBcon.disconn();
					System.exit(0);
				}
			}
		});
		
		setBounds(100, 100, 650, 450);

		contentPane = new JPanel();
		contentPane.setLayout(card);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// menu_1
		mSalesmenu = new JMenu("�ǸŰ���");
		menuBar.add(mSalesmenu);

		mSalesReg = new JMenuItem("�Ǹŵ��");
		mSalesmenu.add(mSalesReg);

		mSalesStatus = new JMenuItem("�Ǹ���Ȳ");
		mSalesmenu.add(mSalesStatus);

		// menu_2
		mStockmenu = new JMenu("������");
		menuBar.add(mStockmenu);
		
		mStock = new JMenuItem("�����ȸ");
		mStockmenu.add(mStock);		
		
		// menu_3
		mAdmMenu = new JMenu("�����ڸ޴�");
		menuBar.add(mAdmMenu);

		mNewProdReg = new JMenuItem("�Ż�ǰ ���");
		mAdmMenu.add(mNewProdReg);
		
		mProdInfoModify = new JMenuItem("��ǰ���� ����");
		mAdmMenu.add(mProdInfoModify);
		
		mAccount = new JMenuItem("���� ����/��ȸ");
		mAdmMenu.add(mAccount);
		
		// menu_4
		mLogoutMenu = new JMenu("�α׾ƿ�");
		menuBar.add(mLogoutMenu);

		mLogout = new JMenuItem("�α׾ƿ�");
		mLogoutMenu.add(mLogout);


		// contentPane.add("�гκ���", new �г�());
		contentPane.add("SalesReg", new SalesReg(myDBcon)); //�Ǹŵ��
		contentPane.add("SalesStatus", new SalesStatus(myDBcon)); //�Ǹ���Ȳ
		contentPane.add("Stock", new StockSearch(myDBcon)); //�����ȸ
		contentPane.add("NewProdReg", new NewProReg(myDBcon)); //�Ż�ǰ���
		contentPane.add("ProdInfoModify", new ProdInfoModify(myDBcon)); // ��ǰ���� ���� 
		contentPane.add("Account", new AccountLookupCreate(myDBcon)); // �������� �� ����

		add(contentPane);

		mSalesReg.addActionListener(this);
		mSalesStatus.addActionListener(this);
		mStock.addActionListener(this);
		mNewProdReg.addActionListener(this);
		mProdInfoModify.addActionListener(this);
		mAccount.addActionListener(this);
		mLogout.addActionListener(this);

		setVisible(true);
	}
	
	private void setDBcon(DBcon dbcon) {
		myDBcon = dbcon;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() ==mSalesReg) {
			card.show(contentPane, "SalesReg");
		} else if (e.getSource() == mSalesStatus) {
			card.show(contentPane, "SalesStatus");
		} else if (e.getSource() == mStock) {
			card.show(contentPane, "Stock");
		} else if (e.getSource() == mNewProdReg) {
			card.show(contentPane, "NewProdReg");
		} else if(e.getSource() == mProdInfoModify) {
			card.show(contentPane, "ProdInfoModify");
		} else if (e.getSource() == mAccount) {
			card.show(contentPane, "Account");
		}
		else if (e.getSource() == mLogout) {
			int dialogResult = JOptionPane.showConfirmDialog(this, "�α׾ƿ� �Ͻðڽ��ϱ�?", "logout", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(dialogResult == 0) { // ��  
				// +)�α��� ȭ������ �̵�
				myDBcon.disconn();
				dispose();
			} 			
		}
	}

}