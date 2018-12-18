package ex2;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class BookInfo_panel extends JPanel {
	
	JLabel lb_text;
	
	public BookInfo_panel() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		lb_text = new JLabel("책 정보 패널");
		lb_text.setForeground(Color.WHITE);
		lb_text.setBounds(150, 150, 100, 30);
		
		add(lb_text);
	}
}

public class BookInfoFrame extends JFrame {
	
	public BookInfoFrame() {
		setTitle("책 정보");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new BookInfo_panel());
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BookInfoFrame();
	}
}
