package co.kr.team.sports;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;


public class SportsMain extends JInternalFrame implements ItemListener, ActionListener {
	private JTextField Time01;
	private JTextField Kcal01;
	private JTextField Time02;
	private JTextField Kcal02;
	private JTextField SumKcal01;
	private JTextField Time03;
	private JTextField Kcal03;
	private JTextField Time04;
	private JTextField Kcal04;
	private JTextField SumKcal02;
	private JTextField Time05;
	private JTextField Kcal05;
	private JTextField Time06;
	private JTextField Kcal06;
	private JTextField SumKcal03;
	public JTextField TtalKcal;
	
	private JComboBox Line1_cbBox;
	private JComboBox Line2_cbBox;
	private JComboBox Line4_cbBox;
	private JComboBox Line5_cbBox;
	private JComboBox Line7_cbBox;
	private JComboBox Line8_cbBox;
	
	private JButton Line1_Input;
	private JButton Line2_Input;
	private JButton Line4_Input;
	private JButton Line5_Input;
	private JButton Line7_Input;
	private JButton Line8_Input;
	private JButton Line3_Save;
	private JButton Line6_Save;
	private JButton Line9_Save;
	private JButton Line10_TotalSave;
	String b;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
						SportsMain frame = new SportsMain();
				}//main

	/**
	 * Create the frame.
	 */
	public SportsMain() {
		init();
		
	}//SportsMain
	
	public SportsMain(String a) {
		this.b = a;
		
		init();
		
	}

	public void init() {
		setBounds(100, 100, 800, 500);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(18, 1, 0, 0));
		
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblBbbb = new JLabel("운동관리");
		panel_1.add(lblBbbb);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel label = new JLabel("_______________________________________________________________________________________________________________________________________________________");
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblAaa = new JLabel("일상생활");
		panel_3.add(lblAaa);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);

		Vector v1 = SportsDao.selsportsList();
		Line1_cbBox = new JComboBox(v1);
		Line1_cbBox.addItemListener(this);
		panel_4.add(Line1_cbBox);
		
		
		JLabel lblAa = new JLabel("운동시간(분)");
		panel_4.add(lblAa);
		
		Time01 = new JTextField();
		panel_4.add(Time01);
		Time01.setColumns(10);
		
		Line1_Input = new JButton("계산");
		Line1_Input.addActionListener(this);//리스너 등록
		Line1_Input.getSelectedObjects();
		panel_4.add(Line1_Input);
		
		JLabel lblAa_1 = new JLabel("소비 칼로리 : ");
		panel_4.add(lblAa_1);
		
		Kcal01 = new JTextField();
		panel_4.add(Kcal01);
		Kcal01.setColumns(10);
		Kcal01.setEditable(false);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		
		Vector v2 = SportsDao.selsportsList();
        Line2_cbBox = new JComboBox(v2);
		Line2_cbBox.addItemListener(this);
		panel_5.add(Line2_cbBox);
		
		JLabel label_1 = new JLabel("운동시간(분)");
		panel_5.add(label_1);
		
		Time02 = new JTextField();
		panel_5.add(Time02);
		Time02.setColumns(10);
		
		Line2_Input = new JButton("계산");
		Line2_Input.addActionListener(this);//리스너 등록
		panel_5.add(Line2_Input);
		
		JLabel lblNewLabel = new JLabel("소비 칼로리 : ");
		panel_5.add(lblNewLabel);
		
		Kcal02 = new JTextField();
		panel_5.add(Kcal02);
		Kcal02.setColumns(10);
		Kcal02.setEditable(false);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JLabel lblA = new JLabel("소비 칼로리 합 : ");
		panel_6.add(lblA);
		
		SumKcal01 = new JTextField();
		panel_6.add(SumKcal01);
		SumKcal01.setColumns(10);
		SumKcal01.setEditable(false);
		
		Line3_Save = new JButton("총 합계 추가");
		Line3_Save.addActionListener(this);//리스너 등록
		panel_6.add(Line3_Save);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		JLabel lblNewLabel_1 = new JLabel("_______________________________________________________________________________________________________________________________________________________");
		panel_7.add(lblNewLabel_1);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		JLabel lblNewLabel_2 = new JLabel("스포츠");
		panel_8.add(lblNewLabel_2);
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		
		Vector v3 = SportsDao.selsportsList2();
		Line4_cbBox = new JComboBox(v3);
		Line4_cbBox.addItemListener(this);
		panel_9.add(Line4_cbBox);
		
		
		JLabel lblNewLabel_3 = new JLabel("운동시간(분)");
		panel_9.add(lblNewLabel_3);
		
		Time03 = new JTextField();
		panel_9.add(Time03);
		Time03.setColumns(10);
		
		Line4_Input = new JButton("계산");
		Line4_Input.addActionListener(this);//리스너 등록
		panel_9.add(Line4_Input);
		
		JLabel lblNewLabel_4 = new JLabel("소비 칼로리 : ");
		panel_9.add(lblNewLabel_4);
		
		Kcal03 = new JTextField();
		panel_9.add(Kcal03);
		Kcal03.setColumns(10);
		Kcal03.setEditable(false);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		Vector v4 = SportsDao.selsportsList2();
		Line5_cbBox = new JComboBox(v4);
		Line5_cbBox.addItemListener(this);
		panel_10.add(Line5_cbBox);
		
		JLabel lblNewLabel_5 = new JLabel("운동시간(분)");
		panel_10.add(lblNewLabel_5);
		
		Time04 = new JTextField();
		panel_10.add(Time04);
		Time04.setColumns(10);
		
		Line5_Input = new JButton("계산");
		Line5_Input.addActionListener(this);//리스너 등록
		panel_10.add(Line5_Input);
		
		JLabel lblNewLabel_6 = new JLabel("소비 칼로리 : ");
		panel_10.add(lblNewLabel_6);
		
		Kcal04 = new JTextField();
		panel_10.add(Kcal04);
		Kcal04.setColumns(10);
		Kcal04.setEditable(false);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		
		JLabel lblNewLabel_7 = new JLabel("소비 칼로리 합 : ");
		panel_11.add(lblNewLabel_7);
		
		SumKcal02 = new JTextField();
		panel_11.add(SumKcal02);
		SumKcal02.setColumns(10);
		SumKcal02.setEditable(false);
		
		
		Line6_Save = new JButton("총 합계 추가");
		Line6_Save.addActionListener(this);//리스너 등록
		panel_11.add(Line6_Save);
		
		JPanel panel_12 = new JPanel();
		panel.add(panel_12);
		
		JLabel lblNewLabel_8 = new JLabel("_______________________________________________________________________________________________________________________________________________________");
		panel_12.add(lblNewLabel_8);
		
		JPanel panel_13 = new JPanel();
		panel.add(panel_13);
		
		JLabel lblNewLabel_9 = new JLabel("운동");
		panel_13.add(lblNewLabel_9);
		
		JPanel panel_14 = new JPanel();
		panel.add(panel_14);
		
		Vector v5 = SportsDao.selsportsList3();
		Line7_cbBox = new JComboBox(v5);
		Line7_cbBox.addItemListener(this);
		panel_14.add(Line7_cbBox);
		
		JLabel lblNewLabel_10 = new JLabel("운동시간(분)");
		panel_14.add(lblNewLabel_10);
		
		Time05 = new JTextField();
		panel_14.add(Time05);
		Time05.setColumns(10);
		
		Line7_Input = new JButton("계산");
		Line7_Input.addActionListener(this);//리스너 등록
		panel_14.add(Line7_Input);
		
		JLabel lblNewLabel_11 = new JLabel("소비 칼로리 : ");
		panel_14.add(lblNewLabel_11);
		
		Kcal05 = new JTextField();
		panel_14.add(Kcal05);
		Kcal05.setColumns(10);
		Kcal05.setEditable(false);
		
		JPanel panel_15 = new JPanel();
		panel.add(panel_15);
		
		Vector v6 = SportsDao.selsportsList3();
		Line8_cbBox = new JComboBox(v6);
		Line8_cbBox.addItemListener(this);
		panel_15.add(Line8_cbBox);
		
		JLabel lblNewLabel_12 = new JLabel("운동시간(분)");
		panel_15.add(lblNewLabel_12);
		
		Time06 = new JTextField();
		panel_15.add(Time06);
		Time06.setColumns(10);
		
		Line8_Input = new JButton("계산");
		Line8_Input.addActionListener(this);//리스너 등록
		panel_15.add(Line8_Input);
		
		JLabel lblNewLabel_13 = new JLabel("소비 칼로리 : ");
		panel_15.add(lblNewLabel_13);
		
		Kcal06 = new JTextField();
		panel_15.add(Kcal06);
		Kcal06.setColumns(10);
		Kcal06.setEditable(false);
		
		JPanel panel_16 = new JPanel();
		panel.add(panel_16);
				
		JLabel lblNewLabel_14 = new JLabel("소비 칼로리 합 : ");
		panel_16.add(lblNewLabel_14);
		
		SumKcal03 = new JTextField();
		panel_16.add(SumKcal03);
		SumKcal03.setColumns(10);
		SumKcal03.setEditable(false);
		
		Line9_Save = new JButton("총 합계 추가");
		Line9_Save.addActionListener(this);//리스너 등록
		panel_16.add(Line9_Save);
		
		JPanel panel_17 = new JPanel();
		panel.add(panel_17);
		
		JLabel lblNewLabel_15 = new JLabel("_______________________________________________________________________________________________________________________________________________________");
		panel_17.add(lblNewLabel_15);
		
		
		JPanel panel_18 = new JPanel();
		panel.add(panel_18);
		
		JLabel lblNewLabel_16 = new JLabel("소모 칼로리 총 합 : ") ;
		panel_18.add(lblNewLabel_16);
		
		TtalKcal = new JTextField();
		panel_18.add(TtalKcal);
		TtalKcal.setColumns(10);
		TtalKcal.setEditable(false);
		
		Line10_TotalSave = new JButton("저장");
		Line10_TotalSave.addActionListener(this);//리스너 등록
		panel_18.add(Line10_TotalSave);
		setVisible(true);
	}
	
	private SportsDto2 getDto() {
		//System.out.println("버튼 클릭");
		//화면에서 값들을 가지고 온다.
		
		String id = b;
		Double sports = Double.parseDouble(TtalKcal.getText());
		
		Date currentTime = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		String dTime = formatter.format ( currentTime );
		
		SportsDto2 dto = new SportsDto2();
		dto.setH_day(dTime);
		dto.setId(id);
		dto.setSports(sports);
		return dto;
	}//getDto

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== Line1_Input) {
			double dble1 = 0;
			String strtm1 = Time01.getText();
			Double tme1 = (double)0;
			if (strtm1.length() == 0) {
				JOptionPane.showMessageDialog(this, "시간을 입력해 주세요!");
				Time01.requestFocus(); // 아이디에 커서를 둔다
				return;
			}else if(strtm1.length() > 4) {
				JOptionPane.showMessageDialog(this, "하루는 24시간입니다. 범위내에서 입력해 주세요");
				return;
			}
			try {
				tme1 = Double.parseDouble(strtm1); // 숫자로 바꾼다.
			} catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "시간은 숫자로 입력하세요!");
				Time01.setText("");
				Time01.requestFocus();
				return;
			}
			double Time01 =Double.parseDouble(strtm1);
			Vector v = (Vector) Line1_cbBox.getSelectedItem();
			String motion = (String) v.get(0);
			SportsDto dto = SportsDao.selectVal(motion);
			double firstval = dto.getFirstval();
			double upval = dto.getUpval();
			dble1 = firstval + upval*22*Time01;
			Kcal01.setText(Double.toString(Double.parseDouble(String.format(
					"%.2f", dble1))));
			SumKcal01.setText(String.format("%.2f",dble1));
			/*String dble2 = Kcal02.getText();
			if(dble2.length() == 0) {
				SumKcal01.setText(String.format("%.2f",dble1));
			}else {
				double result = dble1 +Double.parseDouble(dble2)  ;
				SumKcal01.setText(String.format("%.2f", dble1+dble2));
			}
			System.out.println("dble2 = "+dble2);*/
		}//Line1_Input
		
			if(e.getSource()== Line2_Input) {
				String strtm2 = Time02.getText();
				Double tme2 = (double)0;
				if (strtm2.length() == 0) {
					JOptionPane.showMessageDialog(this, "시간을 입력해 주세요!");
					Time02.requestFocus(); // 아이디에 커서를 둔다
					return ;
					
				}else if(strtm2.length() > 4) {
					JOptionPane.showMessageDialog(this, "하루는 24시간입니다. 범위내에서 입력해 주세요");
					return;
				}
				try {
					tme2 = Double.parseDouble(strtm2); // 숫자로 바꾼다.
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(this, "시간은 숫자로 입력하세요!");
					Time02.setText("");
					Time02.requestFocus();
					return;
				}
				Double Time02 = (double) Integer.parseInt(strtm2);
				Vector v = (Vector) Line2_cbBox.getSelectedItem();
				String motion = (String) v.get(0);
				SportsDto dto = SportsDao.selectVal(motion);
				double firstval = dto.getFirstval();
				double upval = dto.getUpval();
				double dble = firstval + upval*22*Time02;
				Kcal02.setText(Double.toString(Double.parseDouble(String.format("%,2f",dble))));
				double result = Double.parseDouble(Kcal01.getText()) + dble;
				SumKcal01.	setText(Double.toString(Double.parseDouble(String.format("%,2f",result))));
		}//Line2_Input
		
			if(e.getSource()== Line4_Input) {
				double dble3 = 0;
				String strtm3 = Time03.getText();
				Double tme3 = (double)0;
				if (strtm3.length() == 0) {
					JOptionPane.showMessageDialog(this, "시간을 입력해 주세요!");
					Time03.requestFocus(); // 아이디에 커서를 둔다
					return ;
				}else if(strtm3.length() > 4) {
					JOptionPane.showMessageDialog(this, "하루는 24시간입니다. 범위내에서 입력해 주세요");
					return;
				}
				try {
					tme3 = Double.parseDouble(strtm3); // 숫자로 바꾼다.
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(this, "시간은 숫자로 입력하세요!");
					Time03.setText("");
					Time03.requestFocus();
					return;
				}
				Double Time03 = (double) Integer.parseInt(strtm3);
				Vector v = (Vector) Line4_cbBox.getSelectedItem();
				String motion = (String) v.get(0);
				SportsDto dto = SportsDao.selectVal(motion);
				double firstval = dto.getFirstval();
				double upval = dto.getUpval();
				dble3 = firstval + upval*22*Time03;
				Kcal03.setText(Double.toString(Double.parseDouble(String.format("%.2f", dble3))));
				SumKcal02.setText(Double.toString(Double.parseDouble(String.format("%.2f", dble3))));
			
		}//Line4_Input
		
		if(e.getSource()==Line5_Input) {
			double dble = 0;
			String strtm = Time04.getText();
			Double tme2 = (double)0;
			if (strtm.length() == 0) {
				JOptionPane.showMessageDialog(this, "시간을 입력해 주세요!");
				Time04.requestFocus(); // 아이디에 커서를 둔다
				return ;
			}else if(strtm.length() > 4) {
				JOptionPane.showMessageDialog(this, "하루는 24시간입니다. 범위내에서 입력해 주세요");
				return;
			}
			try {
				tme2 = Double.parseDouble(strtm); // 숫자로 바꾼다.
			} catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "시간은 숫자로 입력하세요!");
				Time04.setText("");
				Time04.requestFocus();
				return;
			}
			Double Time04 = Double.parseDouble(strtm);
			Vector v = (Vector) Line5_cbBox.getSelectedItem();
			String motion = (String) v.get(0);
			SportsDto dto = SportsDao.selectVal(motion);
			double firstval = dto.getFirstval();
			double upval = dto.getUpval();
			dble = firstval + upval*22*Time04;
			Kcal04.setText(Double.toString(Double.parseDouble(String.format(
					"%.2f", dble))));
			double result = Double.parseDouble(Kcal03.getText()) + dble;
			SumKcal02.	setText(String.format("%.2f", result));
				
		}//Line5_Input
		
		if(e.getSource()==Line7_Input) {
			double dble = 0;
			String strtm = Time05.getText();
			Double tme2 = (double)0;
			if (strtm.length() == 0) {
				JOptionPane.showMessageDialog(this, "시간을 입력해 주세요!");
				Time05.requestFocus(); // 아이디에 커서를 둔다
				return ;
			}else if(strtm.length() > 4) {
				JOptionPane.showMessageDialog(this, "하루는 24시간입니다. 범위내에서 입력해 주세요");
				return;
			}
			try {
				tme2 = Double.parseDouble(strtm); // 숫자로 바꾼다.
			} catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "시간은 숫자로 입력하세요!");
				Time05.setText("");
				Time05.requestFocus();
				return;
			}
			Double Time05 = (double) Integer.parseInt(strtm);
			Vector v = (Vector) Line7_cbBox.getSelectedItem();
			String motion = (String) v.get(0);
			SportsDto dto = SportsDao.selectVal(motion);
			double firstval = dto.getFirstval();
			double upval = dto.getUpval();
			dble = firstval + upval*22*Time05;
			Kcal05.setText(Double.toString(Double.parseDouble(String.format("%.2f", dble))));
			//SumKcal03.	setText(String.format("%.2f", result));
			SumKcal03.	setText(String.format("%.2f", dble));
		}//Line7_Input
		
		if(e.getSource()==Line8_Input) {
			double dble = 0;
			String strtm = Time06.getText();
			Double tme2 = (double)0;
			if (strtm.length() == 0) {
				JOptionPane.showMessageDialog(this, "시간을 입력해 주세요!");
				Time06.requestFocus(); // 아이디에 커서를 둔다
				return ;
			}else if(strtm.length() > 4) {
				JOptionPane.showMessageDialog(this, "하루는 24시간입니다. 범위내에서 입력해 주세요");
				return;
			}
			try {
				tme2 = Double.parseDouble(strtm); // 숫자로 바꾼다.
			} catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "시간은 숫자로 입력하세요!");
				Time06.setText("");
				Time06.requestFocus();
				return;
			}
			Double Time06 = (double) Integer.parseInt(strtm);
			Vector v = (Vector) Line8_cbBox.getSelectedItem();
			String motion = (String) v.get(0);
			SportsDto dto = SportsDao.selectVal(motion);
			double firstval = dto.getFirstval();
			double upval = dto.getUpval();
			dble = firstval + upval*22*Time06;
			Kcal06.setText(Double.toString(Double.parseDouble(String.format("%.2f", dble))));
			double result = Double.parseDouble(Kcal05.getText()) + dble;
			SumKcal03.	setText(String.format("%.2f", result));
		}//Line8_Input
		
		if(e.getSource()==Line3_Save) {
			String ta01 = SumKcal01.getText();
			if(ta01.length() == 0) {
				JOptionPane.showMessageDialog(this, "운동시간 입력후 시도하세요!");
				return;
			}
			Double tol =   Double.parseDouble(ta01);
			int ClickA = JOptionPane.showConfirmDialog(this, "추가하시겠습니까?");
			if(ClickA == JOptionPane.YES_OPTION) {
				TtalKcal.setText(String.format(	"%.2f", tol));
			}
			
		}//Line3_Save
		if(e.getSource()==Line6_Save) {
			String ta01 = SumKcal02.getText();
			if(ta01.length() == 0) {
				JOptionPane.showMessageDialog(this, "운동시간 입력후 시도하세요!");
				return;
			}
			int ClickA = JOptionPane.showConfirmDialog(this, "추가하시겠습니까?");
			
			if(ClickA == JOptionPane.YES_OPTION) {
				Double tol2 =   Double.parseDouble(ta01);
				double result = Double.parseDouble(SumKcal01.getText()) + tol2;
				TtalKcal.setText(Double.toString(tol2));
				TtalKcal.	setText(String.format("%.2f", result));
				return;
				
			} 
			
		}//Lime6_Save
		if(e.getSource()==Line9_Save) {
			String ta01 = SumKcal03.getText();
			if(ta01.length() == 0) {
				JOptionPane.showMessageDialog(this, "운동시간 입력후 시도하세요!");
				return;
			}
			int ClickA = JOptionPane.showConfirmDialog(this, "추가하시겠습니까?");
			if(ClickA == JOptionPane.YES_OPTION) {
				Double tol3 =   Double.parseDouble(ta01);
				double result = Double.parseDouble(SumKcal01.getText()) +
				Double.parseDouble(SumKcal02.getText())+ tol3;
				TtalKcal.setText(Double.toString(tol3));
				TtalKcal.	setText(String.format("%.2f", result));
				
			}
		}//Line9_Save
		
			if (e.getSource() == Line10_TotalSave) {
				String ta01 = TtalKcal.getText();
				if(ta01.length() == 0) {
					JOptionPane.showMessageDialog(this, "운동량을 입력후 시도하세요!");
					return;
				}
				int ClickA = JOptionPane.showConfirmDialog(this, "저장하시겠습니까? 하루에 한번밖에 저장되지 않습니다");
				if(ClickA == JOptionPane.YES_OPTION) {
					SportsDto2 dto = getDto();
					boolean ok = SportsDao.insertVal(dto);
					if (ok) {
						JOptionPane.showMessageDialog(this, "저장되었습니다.");
					} else {
						JOptionPane.showMessageDialog(this, "저장은 하루에 한번!");
				}
			}
		}
	}//actionPerformed

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == e.SELECTED) {
			if(e.getSource() == Line1_cbBox)  {
				Vector v = (Vector) Line1_cbBox.getSelectedItem();
				String motion = (String) v.get(0);
				SportsDto dto = SportsDao.selectVal(motion);
				double firstval = dto.getFirstval();
				double upval = dto.getUpval();
			}//Line1_cbBox
			
			if(e.getSource() == Line2_cbBox)  {
				Vector v2 = (Vector) Line2_cbBox.getSelectedItem();
				String motion = (String) v2.get(0);
				SportsDto dto = SportsDao.selectVal(motion);
				double firstval = dto.getFirstval();
				double upval = dto.getUpval();
			}//Line2_cbBox
			
			if(e.getSource() == Line4_cbBox)  {
				Vector v3 = (Vector) Line4_cbBox.getSelectedItem();
				String motion = (String) v3.get(0);
				SportsDto dto = SportsDao.selectVal(motion);
				double firstval = dto.getFirstval();
				double upval = dto.getUpval();
			}//Line4_cbBox
			
			if(e.getSource() == Line5_cbBox)  {
				Vector v4 = (Vector) Line5_cbBox.getSelectedItem();
				String motion = (String) v4.get(0);
				SportsDto dto = SportsDao.selectVal(motion);
				double firstval = dto.getFirstval();
				double upval = dto.getUpval();
			}//Line5_cbBox
			
			if(e.getSource() == Line7_cbBox)  {
				Vector v5 = (Vector) Line7_cbBox.getSelectedItem();
				String motion = (String) v5.get(0);
				SportsDto dto = SportsDao.selectVal(motion);
				System.out.println(dto);
				double firstval = dto.getFirstval();
				double upval = dto.getUpval();
			}//Line7_cbBox
			if(e.getSource() == Line8_cbBox)  {
				Vector v6 = (Vector) Line8_cbBox.getSelectedItem();
				String motion = (String) v6.get(0);
				SportsDto dto = SportsDao.selectVal(motion);
				double firstval = dto.getFirstval();
				double upval = dto.getUpval();
			}//Line8_cbBox
		}//SELECTED
	}//itemStateChanged
}//end
