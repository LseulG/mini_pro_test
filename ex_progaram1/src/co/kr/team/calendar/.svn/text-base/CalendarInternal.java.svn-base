package co.kr.team.calendar;

import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarInternal extends JInternalFrame implements ActionListener{

	JPanel panel;
	public JButton btn1;
	public JTextField btnNewButton,btnNewButton_1,btnNewButton_2,btnNewButton_3,btnNewButton_4,btnNewButton_5
	,btnNewButton_6,btnNewButton_7,btnNewButton_8,tf32;
	public JTextArea tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16,tf17,tf18,tf19,tf20,tf21,
	tf22,tf23,tf24,tf25,tf26,tf27,tf28,tf29,tf30,tf31;
	public JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2;
	String b;
	public String month;
	public String day;
	public String m;
	int M;
	String y;
	String d;
	public String dTime;
		
	public static void main(String[] args) {
				CalendarInternal frame = new CalendarInternal();
			}

	public CalendarInternal() {
		init();
	}
	
	public CalendarInternal(String a) {
		this.b = a;
		init();
		for (int i = 1; i < 32; i++) {
			if(i<10) {
			String day = Integer.toString(i);
			String date = "2011-"+month+"-"+("0"+day) ;
			CalendarDto dto = CalendarDao.selectId(date, b);
			setCalendar(dto);
			} else {
				String day = Integer.toString(i);
				String date = "2011-"+month+"-"+day ;
				CalendarDto dto = CalendarDao.selectId(date, b);
				setCalendar(dto);
			}
		}
	}

	public void init() {
		//오늘 날짜 yyyy-MM-dd 형식으로 스트링으로 불러오기
		Date currentTime = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		dTime = formatter.format ( currentTime );
				
		//String[] - split(String regex, int limit)
		//날짜 년,월,일 나누기
		String[] a = dTime.split("-", 3);
		y = a[0]; //년도 4자리
		m = a[1]; //월 2자리
		M = Integer.parseInt(m);
		d = a[2]; //일 2자리
				
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new GridLayout(7, 7));
		
		panel = new JPanel();
		getContentPane().add(panel);
		
		btn1 = new JButton("Before");
		panel.add(btn1);
		btn1.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 25));
		btn1.addActionListener(this);
		
		lblNewLabel_1 = new JLabel( b +" 님의 ");
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("휴먼엑스포", Font.PLAIN, 30));
			
		
		lblNewLabel = new JLabel(m);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("휴먼엑스포", Font.PLAIN, 30));
		month = lblNewLabel.getText();
		
		lblNewLabel_2 = new JLabel(" 월 현황 ");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("휴먼엑스포", Font.PLAIN, 30));
					
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 7, 0, 0));
		
		btnNewButton_2 = new JTextField("일");
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setEditable(false);
		btnNewButton_2.setForeground(new Color(220, 20, 60));
		btnNewButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 30));
		
		btnNewButton_3 = new JTextField("월");
		panel_1.add(btnNewButton_3);
		btnNewButton_3.setEditable(false);
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_3.setFont(new Font("굴림", Font.PLAIN, 30));
		
		btnNewButton_4 = new JTextField("화");
		panel_1.add(btnNewButton_4);
		btnNewButton_4.setEditable(false);
		btnNewButton_4.setForeground(new Color(0, 0,0));
		btnNewButton_4.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_4.setFont(new Font("굴림", Font.PLAIN, 30));
		
		btnNewButton_5 = new JTextField("수");
		panel_1.add(btnNewButton_5);
		btnNewButton_5.setEditable(false);
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_5.setFont(new Font("굴림", Font.PLAIN, 30));
		
		btnNewButton_6 = new JTextField("목");
		panel_1.add(btnNewButton_6);
		btnNewButton_6.setEditable(false);
		btnNewButton_6.setForeground(new Color(0, 0, 0));
		btnNewButton_6.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_6.setFont(new Font("굴림", Font.PLAIN, 30));
		
		btnNewButton_7 = new JTextField("금");
		panel_1.add(btnNewButton_7);
		btnNewButton_7.setEditable(false);
		btnNewButton_7.setForeground(new Color(0, 0, 0));
		btnNewButton_7.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_7.setFont(new Font("굴림", Font.PLAIN, 30));
		
		btnNewButton_8 = new JTextField("토");
		panel_1.add(btnNewButton_8);
		btnNewButton_8.setEditable(false);
		btnNewButton_8.setForeground(new Color(0, 0, 225));
		btnNewButton_8.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_8.setFont(new Font("굴림", Font.PLAIN, 30));
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(1, 7, 0, 0));
		
		tf1 = new JTextArea("01");
		panel_2.add(tf1);
		tf1.setBackground(new Color(204, 255, 255));
		tf1.setEditable(false);
				
		tf2 = new JTextArea("02");
		panel_2.add(tf2);
		tf2.setBackground(new Color(204, 255, 255));
		tf2.setEditable(false);
		
		tf3 = new JTextArea("03");
		panel_2.add(tf3);
		tf3.setBackground(new Color(204, 255, 255));
		tf3.setEditable(false);
		
		tf4 = new JTextArea("04");
		panel_2.add(tf4);
		tf4.setBackground(new Color(204, 255, 255));
		tf4.setEditable(false);
		
		tf5 = new JTextArea("05");
		panel_2.add(tf5);
		tf5.setBackground(new Color(204, 255, 255));
		tf5.setEditable(false);
		
		tf6 = new JTextArea("06");
		panel_2.add(tf6);
		tf6.setBackground(new Color(204, 255, 255));
		tf6.setEditable(false);
		
		tf7 = new JTextArea("07");
		panel_2.add(tf7);
		tf7.setBackground(new Color(204, 255, 255));
		tf7.setEditable(false);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(1, 7, 0, 0));
		
		tf8 = new JTextArea("08");
		panel_3.add(tf8);
		tf8.setBackground(new Color(204, 255, 255));
		tf8.setEditable(false);
		
		tf9 = new JTextArea("09");
		panel_3.add(tf9);
		tf9.setBackground(new Color(204, 255, 255));
		tf9.setEditable(false);
				
		tf10 = new JTextArea("10");
		panel_3.add(tf10);
		tf10.setBackground(new Color(204, 255, 255));
		tf10.setEditable(false);
				
		tf11 = new JTextArea("11");
		panel_3.add(tf11);
		tf11.setBackground(new Color(204, 255, 255));
		tf11.setEditable(false);
		
		tf12 = new JTextArea("12");
		panel_3.add(tf12);
		tf12.setBackground(new Color(204, 255, 255));
		tf12.setEditable(false);
		
		tf13 = new JTextArea("13");
		panel_3.add(tf13);
		tf13.setBackground(new Color(204, 255, 255));
		tf13.setEditable(false);
		
		tf14 = new JTextArea("14");
		panel_3.add(tf14);
		tf14.setBackground(new Color(204, 255, 255));
		tf14.setEditable(false);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(1, 7, 0, 0));
		
		tf15 = new JTextArea("15");
		panel_4.add(tf15);
		tf15.setBackground(new Color(204, 255, 255));
		tf15.setEditable(false);
		
		tf16 = new JTextArea("16");
		panel_4.add(tf16);
		tf16.setBackground(new Color(204, 255, 255));
		tf16.setEditable(false);
		
		tf17 = new JTextArea("17");
		panel_4.add(tf17);
		tf17.setBackground(new Color(204, 255, 255));
		tf17.setEditable(false);
		
		tf18 = new JTextArea("18");
		panel_4.add(tf18);
		tf18.setBackground(new Color(204, 255, 255));
		tf18.setEditable(false);
		
		tf19 = new JTextArea("19");
		panel_4.add(tf19);
		tf19.setBackground(new Color(204, 255, 255));
		tf19.setEditable(false);
		
		tf20 = new JTextArea("20");
		panel_4.add(tf20);
		tf20.setBackground(new Color(204, 255, 255));
		tf20.setEditable(false);
		
		tf21 = new JTextArea("21");
		panel_4.add(tf21);
		tf21.setBackground(new Color(204, 255, 255));
		tf21.setEditable(false);
		
		JPanel panel_5 = new JPanel();
		getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(1, 7, 0, 0));
		
		tf22 = new JTextArea("22");
		panel_5.add(tf22);
		tf22.setBackground(new Color(204, 255, 255));
		tf22.setEditable(false);
		
		tf23 = new JTextArea("23");
		panel_5.add(tf23);
		tf23.setBackground(new Color(204, 255, 255));
		tf23.setEditable(false);
		
		tf24 = new JTextArea("24");
		panel_5.add(tf24);
		tf24.setBackground(new Color(204, 255, 255));
		tf24.setEditable(false);
		
		tf25 = new JTextArea("25");
		panel_5.add(tf25);
		tf25.setBackground(new Color(204, 255, 255));
		tf25.setEditable(false);
		
		tf26 = new JTextArea("26");
		panel_5.add(tf26);
		tf26.setBackground(new Color(204, 255, 255));
		tf26.setEditable(false);
		
		tf27 = new JTextArea("27");
		panel_5.add(tf27);
		tf27.setBackground(new Color(204, 255, 255));
		tf27.setEditable(false);
		
		tf28 = new JTextArea("28");
		panel_5.add(tf28);
		tf28.setBackground(new Color(204, 255, 255));
		tf28.setEditable(false);
		
		JPanel panel_6 = new JPanel();
		getContentPane().add(panel_6);
		panel_6.setLayout(new GridLayout(1, 7, 0, 0));
		
		tf29 = new JTextArea("29");
		panel_6.add(tf29);
		tf29.setBackground(new Color(204, 255, 255));
		tf29.setEditable(false);
		
		tf30 = new JTextArea("30");
		panel_6.add(tf30);
		tf30.setBackground(new Color(204, 255, 255));
		tf30.setEditable(false);
		
		tf31 = new JTextArea("31");
		panel_6.add(tf31);
		tf31.setBackground(new Color(204, 255, 255));
		tf31.setEditable(false);
		
		tf32 = new JTextField("");
		panel_6.add(tf32);
				
		JTextField btnNewButton_39 = new JTextField("");
		panel_6.add(btnNewButton_39);
		
		JTextField btnNewButton_38 = new JTextField("");
		panel_6.add(btnNewButton_38);
		
		JTextField btnNewButton_37 = new JTextField("");
		panel_6.add(btnNewButton_37);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//before 버튼을 누르면 이전 달의 데이터 가져오기
		if(e.getSource()==btn1) {
			m = Integer.toString(M - 1);
			lblNewLabel.setText(m);
			for (int i = 1; i < 32; i++) {
				//1~9일을 01~09일로 바꿔줌
				if(i <10) {
				String g = y+"-"+m+"-"+ "0"+Integer.toString(i);
				CalendarDto dto = CalendarDao.selectMonth(g,b);
				setCalendar(dto);
				} else {
					String g = y+"-"+m+"-"+ Integer.toString(i);
					CalendarDto dto = CalendarDao.selectMonth(g,b);
					setCalendar(dto);	
				}
				}
				} 
		}

	public void setCalendar(CalendarDto dto){
		if(dto==null) {
		   tf32.setText("");
		} else if(dto.getH_day().equals("2011-"+m+"-01")) {
			tf1.setText( tf1.getText() +"일/" + "\n" +"몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
		+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
		+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-02")) {
			tf2.setText( tf2.getText() +"일/ "+ "\n" +"몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-03")) {
			tf3.setText( tf3.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-04")) {
			tf4.setText( tf4.getText() +"일/ " + "\n"+ "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-05")) {
			tf5.setText( tf5.getText() +"일/ " + "\n"+ "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-06")) {
			tf6.setText( tf6.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-07")) {
			tf7.setText( tf7.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-08")) {
			tf8.setText( tf8.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-09")) {
			tf9.setText( tf9.getText() +"일/ "+ "\n" +"몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-10")) {
			tf10.setText( tf10.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-11")) {
			tf11.setText( tf11.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-12")) {
			tf12.setText( tf12.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-13")) {
			tf13.setText( tf13.getText() +"일/ "+ "\n" +"몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-14")) {
			tf14.setText( tf14.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-15")) {
			tf15.setText( tf15.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-16")) {
			tf16.setText( tf16.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-17")) {
			tf17.setText( tf17.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-18")) {
			tf18.setText( tf18.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-19")) {
			tf19.setText( tf19.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-20")) {
			tf20.setText( tf20.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-21")) {
			tf21.setText( tf21.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-22")) {
			tf22.setText( tf22.getText() +"일/ "+ "\n"+ "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-23")) {
			tf23.setText( tf23.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-24")) {
			tf24.setText( tf24.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-25")) {
			tf25.setText( tf25.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-26")) {
			tf26.setText( tf26.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-27")) {
			tf27.setText( tf27.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-28")) {
			tf28.setText( tf28.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-29")) {
			tf29.setText( tf29.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-30")) {
			tf30.setText( tf30.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else if(dto.getH_day().equals("2011-"+m+"-31")) {
			tf31.setText( tf31.getText() +"일/ "+ "\n" + "몸무게 : "+ Double.toString(dto.getWeight_e()) +"kg"+"\n" 
					+"섭취량 : " + Double.toString(dto.getFood()) + "Kcal" + "\n" +"운동량 : "+ Double.toString(dto.getSport()) + "Kcal"
					+ "\n"+ "비만도 : " + Double.toString(dto.getBiman_e()) +" " +dto.getBiman_r());
		} else {
			}
		}
	}
		
