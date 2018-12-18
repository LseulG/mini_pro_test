package ex2;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Test extends JFrame implements ActionListener {
	
	CardLayout card = new CardLayout();

	JPanel main_panel; // 버튼을 붙여질 메인 패널 선언

	JMenuBar mb_bookManager;
	JMenu mn_bookManager, mn_userManager, mn_exit;
	JMenuItem mni_LoansCurrently, mni_bookInfo, mni_userRegister, mni_userDelete;

	public Test() {
		setTitle("JMenuItem 예제"); // 프레임 타이틀바 텍스트 지정
		setSize(400, 400); // 프레임 크기 조정(픽셀)
		// 프레임바 우측상단에 X버튼에 대한 강제종료 기능 지정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main_panel = new JPanel(); // 패널 객체화
		main_panel.setLayout(card);

		mb_bookManager = new JMenuBar();

		mn_bookManager = new JMenu("책관리");
		mn_userManager = new JMenu(" 사용자관리");
		mn_exit = new JMenu("종료");
		mn_exit.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// 종료 메뉴 클릭시 프로그램 종료
				System.exit(1);
			}
		});

		mni_LoansCurrently = new JMenuItem("대출현황");
		mni_bookInfo = new JMenuItem("책정보");
		//                                //
		mni_userRegister = new JMenuItem("사용자등록");
		mni_userDelete = new JMenuItem("사용자제거");

		mn_bookManager.add(mni_LoansCurrently);
		mn_bookManager.add(mni_bookInfo);
		mn_userManager.add(mni_userRegister);
		mn_userManager.add(mni_userDelete);

		mb_bookManager.add(mn_bookManager);
		mb_bookManager.add(mn_userManager);
		mb_bookManager.add(mn_exit);

		setJMenuBar(mb_bookManager);
		
		/////////////////////////////////////////////////
		
		main_panel.add("loansCurrentlyPan", new LoansCurrently_panel());
		main_panel.add("bookInfoPan", new BookInfo_panel());
		
		////////////////////////////////////////////////
		
		add(main_panel);
		
		////////////////////////////////////////////////
		
		mni_LoansCurrently.addActionListener(this);
		mni_bookInfo.addActionListener(this);

		setVisible(true); // 프레임 보이게 하기
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mni_LoansCurrently) {
			card.show(main_panel, "loansCurrentlyPan");
		} else if(e.getSource() == mni_bookInfo) {
			card.show(main_panel, "bookInfoPan");
		}
	}

	public static void main(String[] args) {
		new Test();
	}
}
