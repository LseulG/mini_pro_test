package co.kr.team.main;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.*;

public class MakePeople extends JFrame {
	JTextArea ta;
	JPanel p;
	JButton b;
	
	public MakePeople(){
		
		setTitle("Make People");
		
		p = new JPanel(new FlowLayout());
		ta = new JTextArea();
		
		add(p);
		b = new JButton(new ImageIcon("./image/11.jpg"));
		p.add(b);

		
		ta.append("\n\n        <Diet Management Program>          "+
					"\n           MES Java Project Group 1.          " +
					"\n\n\tKang Sang Wook" +
					"\n\tSeo Hyung Sug" +
					"\n\tKim Hyung Jin" +
					"\n\tKim Min Guan" +
					"\n\tLee Da Hye\n\n");
		p.add(ta);
		ta.setEditable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(330, 270);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MakePeople m = new MakePeople();
	}


}
