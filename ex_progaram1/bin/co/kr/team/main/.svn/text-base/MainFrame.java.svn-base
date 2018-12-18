package co.kr.team.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import co.kr.team.bimando.Bimando;
import co.kr.team.calendar.CalendarInternal;
import co.kr.team.food.KcalMain;
import co.kr.team.sports.SportsMain;

public class MainFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	JButton btnNewButton,btnNewButton_1,btnNewButton_2,btnNewButton_3, btnNewButton_4; 
	JInternalFrame internalFrame, internalFrame1,internalFrame2,internalFrame3,internalFrame4;
	JLabel hi;
	LoginDiet ld;
	Bimando pi;
	SportsMain sm;
	CalendarInternal cf;
	KcalMain km; 
	JButton idname;
	JMenuItem mntmNewMenuItem_1;
	JMenuItem mntmNewMenuItem;
	JMenuItem mntmNewMenuItem_2;
	JMenuItem mntmNewMenuItem_3;
	JMenuItem mntmNewMenuItem_4;
	static JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("다이어트 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("회 원");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem_1 = new JMenuItem("회원 가입");
		mntmNewMenuItem_1.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem = new JMenuItem("회원 정보");
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("정 보");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_2 = new JMenuItem("만든 사람들");
		mntmNewMenuItem_2.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("도움말");
		mntmNewMenuItem_3.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("종 료");
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_4 = new JMenuItem("종 료");
		mntmNewMenuItem_4.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_4);
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnNewButton = new JButton(" Login", new ImageIcon("./image/5.gif"));
		toolBar.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnNewButton_1 = new JButton("Food", new ImageIcon("./image/4.gif"));
		toolBar.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		//btnNewButton_1.setEnabled(false);
		
		btnNewButton_2 = new JButton("Sports",new ImageIcon("./image/3.gif"));
		toolBar.add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);
		//btnNewButton_2.setEnabled(false);
		
	    btnNewButton_3 = new JButton("Manage",new ImageIcon("./image/2.gif"));
		toolBar.add(btnNewButton_3);
		btnNewButton_3.addActionListener(this);
		//btnNewButton_3.setEnabled(true);
		
		btnNewButton_4 = new JButton("Calendar",new ImageIcon("./image/1.gif"));
		toolBar.add(btnNewButton_4);
		btnNewButton_4.addActionListener(this);
		//btnNewButton_4.setEnabled(false);
		
		textField_1 = new JTextField();
		toolBar.add(textField_1);
		textField_1.setColumns(5);
		textField_1.setEditable(false);
		
		hi = new JLabel(" 님 로그인 하셨습니다.                                   ");
		toolBar.add(hi);
				
		//internalFrame 첫번째
		internalFrame = new JInternalFrame("Login");
		ld = new LoginDiet(this);
		contentPane.add(ld, BorderLayout.CENTER);
		ld.setVisible(true);
		ld.setClosable(true);
	
	}
   
	@Override
	public void actionPerformed(ActionEvent e) {
		 //toolbar 로그인 버튼
		if(e.getSource() == btnNewButton) {
			ld.setVisible(true);
			cf.dispose();
		  //toolbar 음식칼로리 버튼	 
		  }else if(e.getSource() == btnNewButton_1) {
			  openFood();
		//toolbar 운동량칼로리 버튼 
		  }else if(e.getSource() == btnNewButton_2) {
			  openSports();
	     //toolbar 비만도 버튼	  
		  }else if(e.getSource() == btnNewButton_3) {
			  openBimando();
		//toolbar 캘린더 버튼
		  }else if(e.getSource() == btnNewButton_4) {
			  openCalendar();
		  }
		if(e.getSource()==mntmNewMenuItem) {
			new MemberInfo();
		}
		if(e.getSource()==mntmNewMenuItem_1) {
			new JoinDiet();
		}
		if(e.getSource()==mntmNewMenuItem_2) {
			new MakePeople();
		}
		if(e.getSource()==mntmNewMenuItem_3) {
			new Help();
		}
		if(e.getSource()==mntmNewMenuItem_4) {
			JOptionPane.showMessageDialog(this, "프로그램을 종료합니다.^^");
			dispose();
		}
		}

	public boolean openCalendar() {
		//System.out.println(ld.isClosable());
		internalFrame3 = new JInternalFrame("Calendar");
		String a =  textField_1.getText();
		cf = new CalendarInternal(a);
		contentPane.add(cf, BorderLayout.CENTER);
		cf.setVisible(true);
		cf.setClosable(true);
		//System.out.println(km.isEnabled());
	   //km창이 열리지 않은 상황에서는 km.dispose()를 실행하지 않음
		if(pi != null) {
	    	if(pi.isClosable()) {
	    		pi.dispose();
	    	} else if(sm.isClosable()) {
	    		sm.dispose();
	    	} else if(km.isClosable()) {
	    		km.dispose();
	    	}
	    } 
	    /*else  if(sm != null & sm.isClosable()) {
	    	sm.dispose();
	    } else if(pi != null & pi.isClosable()) {
	    	pi.dispose();
	    } 
	    */
	    	return true;
	      	   }


	public boolean openFood() {
		internalFrame4 = new JInternalFrame("Food");
		String a = textField_1.getText();
		km = new KcalMain(a);
		contentPane.add(km, BorderLayout.CENTER);
		km.setVisible(true);
		km.setClosable(true);
		//km창이 열리지 않은 상황에서는 km.dispose()를 실행하지 않음
				if(cf != null) {
			    	if(cf.isClosable()) {
			    		cf.dispose();
			    	} else if(sm.isClosable()) {
			    		sm.dispose();
			    	} else if(pi.isClosable()) {
			    		pi.dispose();
			    	}
			    } 
		  return true;
	}

	public boolean openSports() {
		System.out.println(km.isClosable());
		internalFrame2 = new JInternalFrame("Sports");
		String a = textField_1.getText();
		sm = new SportsMain(a);
		contentPane.add(sm, BorderLayout.CENTER);
		sm.setVisible(true);
		sm.setClosable(true);
		//km창이 열리지 않은 상황에서는 km.dispose()를 실행하지 않음
				if(km != null) {
			    	if(km.isClosable()) {
			    		km.dispose();
			    	} else if(cf.isClosable()) {
			    		cf.dispose();
			    	} else if(pi.isClosable()) {
			    		pi.dispose();
			    	}
			    } 
		  return true;
	}

	public boolean openBimando() {
		internalFrame1 = new JInternalFrame("Manage");
		String a = textField_1.getText();
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		String date = formatter.format ( currentTime );
		pi = new Bimando(date,a);
		contentPane.add(pi, BorderLayout.CENTER);
		pi.setClosable(true);
		//km창이 열리지 않은 상황에서는 km.dispose()를 실행하지 않음
		//System.out.println(sm.isEnabled());
				if(sm != null ) {
			    	if(sm.isClosable()) {
			    		sm.dispose();
			    	} else if(km.isClosable()) {
			    		km.dispose();
			   	 	} else if(cf.isClosable()) {
			    		cf.dispose();
			    	}
			    } 
		  return true;
	}
	
}
