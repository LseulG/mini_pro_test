package ex2;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class LoansCurrently_panel extends JPanel {
	
	JLabel lb_text;
	
	public LoansCurrently_panel() {
		setLayout(null);
		setBackground(Color.BLACK);
		
		lb_text = new JLabel("대출현황 패널");
		lb_text.setForeground(Color.WHITE);
		lb_text.setBounds(150, 150, 100, 30);
		
		add(lb_text);
	}
}

public class LoansCurrentlyFrame extends JFrame {
	
	public LoansCurrentlyFrame() {
		setTitle("대출현황");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new LoansCurrently_panel());
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LoansCurrentlyFrame();
	}
}



