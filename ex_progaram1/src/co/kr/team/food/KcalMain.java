package co.kr.team.food;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.kr.team.bimando.PiDao;
import co.kr.team.bimando.PiDto;
import co.kr.team.sports.SportsDto2;

public class KcalMain extends JInternalFrame implements ActionListener {
	JPanel p;
	JPanel p0,p1, p2, p3, p4, p5, p6, p7,p8, p9;
	JTextField tfNo;
	JTextField tfFname;
	JTextField tfKcal;
	JTextField tfTotalKcal;
	JTextField tfMName;
	JTextField tfMKcal;
	JTextField tfLName;
	JTextField tfLKcal;
	JTextField tfEName;
	JTextField tfEKcal;
	JTextField tfTKcal;
	JTextField tfdate;
	JButton btnSearch;
	JButton btnSview;
	JButton btnSelect;
	JButton btnSave;
	JButton btnProkcal;
	String b;
	public KcalMain() {
		init();
	}//생성자

	public KcalMain(String a) {
		this.b = a;
		init();
		
		
	}

	

	private void init() {
	p = new JPanel(new GridLayout(10, 2));
	add(p);
	p0 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	p3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	p4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	p5 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	p6 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	p7 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	p8 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	p9 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
	p.add(p0);
	p.add(p1);
	p.add(p2);
	p.add(p3);
	p.add(p4);
	p.add(p5);
	p.add(p6);
	p.add(p7);
	p.add(p8);
	p.add(p9);
	// 첫번째 p1에 내용 표시
		
	  		p0.add(new JLabel("음식No : "));
			p0.add(tfNo = new JTextField(3));
	
			p1.add(new JLabel("오늘의 섭취음식 : "));
			p1.add(tfFname = new JTextField(20));
			btnSearch = new JButton("검색");
			btnSview = new JButton("목록보기");
			p1.add(btnSearch);
			p1.add(btnSview);
			btnSearch.addActionListener(this);
			btnSview.addActionListener(this);
			// 두번째 p2에 내용표시
			
			p2.add(new JLabel("음식 칼로리 : "));
			p2.add(tfKcal = new JTextField(20));
			tfKcal.setEditable(false);
			btnSelect = new JButton("선택");
			btnSelect.addActionListener(this);
			p2.add(btnSelect);
			
			// 세번쨰 p3에 내용표시
			
			p3.add(new JLabel("오늘 섭취 칼로리 :"));
			p3.add(tfTotalKcal = new JTextField(10));		
			tfTotalKcal.setEditable(false);
			// 네번째 p4에 내용표시
			btnSave = new JButton("저장");
			btnSave.addActionListener(this);
			p3.add(btnSave);
			
			
			p4.add(new JLabel("추천 식단표"));
			btnProkcal = new JButton("식단보기");
			btnProkcal.addActionListener(this);
			p4.add(btnProkcal);
			
			p5.add(new JLabel("아침식단"));
			p5.add(tfMName = new JTextField(50)); 
			p5.add(tfMKcal = new JTextField(10));
			p5.add(new JLabel("Kcal"));
			tfMName.setText("");
			
			
			p6.add(new JLabel("점심식단"));
			p6.add(tfLName = new JTextField(50)); 
			p6.add(tfLKcal = new JTextField(10));
			p6.add(new JLabel("Kcal"));
			p7.add(new JLabel("저녁식단"));
			p7.add(tfEName = new JTextField(50)); 
			p7.add(tfEKcal = new JTextField(10));
			p7.add(new JLabel("Kcal"));
			p8.add(new JLabel("종합 추천 Kcal"));
			p8.add(tfTKcal = new JTextField(10));
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(800, 600);
			setVisible(true);
	}

	public static void main(String[] args) {
		new KcalMain();
	}
	private KcalDto getDto2() {
		
		String id = b;
		int food = Integer.parseInt(tfTotalKcal.getText());
		
		Date currentTime = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		String dTime = formatter.format ( currentTime );
		
		KcalDto dto2 = new KcalDto();
		dto2.setH_day(dTime);
		dto2.setId(id);
		dto2.setTotalkcal(food);
		return dto2;
		
	}//getDto
	public void actionPerformed(ActionEvent e) {
			
		if(e.getSource()==btnSearch) {
			searchFood();
		}
		if(e.getSource()==btnSelect) {
			selectFood();
		}
		if(e.getSource() == btnSave) {
			saveFood();
		}
		if(e.getSource()==btnProkcal) {
			prokcalFood();
		}
		if(e.getSource()==btnSview) {
			 Sview();
		}
		

	}
	private void Sview( ) {
		new KcalList();
	}
	private void saveFood() {
		String searchName = tfTotalKcal.getText();
		if(searchName.length() == 0) {
			JOptionPane.showMessageDialog(this, "검색후 선택을 하여주세요!");
			tfTotalKcal.requestFocus();
			return; // 아래로 계속 진행하지말고 끝
		}
		KcalDto  dto = getDto2();
		boolean ok = KcalDao.insertTno(dto); // 저장(insert)
		if(ok) {
			JOptionPane.showMessageDialog(this, "저장되었습니다.");
			claerView();
		} else {
			JOptionPane.showMessageDialog(this, "저장은 하루 한번만 가능합니다.!");
			claerView2();
		}
		return;
									
		}
		
	private void claerView() {
		tfFname.setText("");
		tfKcal.setText("");
	}
	private void claerView2() {
		tfFname.setText("");
		tfKcal.setText("");
		tfTotalKcal.setText("");
	}
	
	
			
	private void prokcalFood() {
		Random r = new Random();
		for (int i = 0; i < 1; i++) { 
			TreeSet ts= new TreeSet();
			while(ts.size() < 1){
			int x = r.nextInt(7) +1;
			ts.add(x);
			TodayDto dto = TodayDao.selectTno(x);
			viewSetData2(dto);
			}//while
			}			
		}
	int total = 0;
	int tokcal1 = 0;
	private void selectFood() {
		String searchName = tfKcal.getText();
		if(searchName.length() == 0) {
			JOptionPane.showMessageDialog(this, "먼저 음식을 검색하여 주세요.");
			claerView();
			tfKcal.requestFocus();
			return; // 아래로 계속 진행하지말고 끝
		}
		
		KcalDto dto = new KcalDto(); 
		String kcal = tfKcal.getText();
		int Tkcal = Integer.parseInt(kcal);
		int tokcal = Tkcal + tokcal1 ;
		tfTotalKcal.setText(Integer.toString(tokcal));
		tokcal1 = tokcal;
		
		Date currentTime = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		String dTime = formatter.format ( currentTime );
		
			
		
		return;
		
		
	}

	private void searchFood() {
		String searchName = tfFname.getText();
		if(searchName.length()==0) {
			
			JOptionPane.showMessageDialog(this, "음식명을 입력하세요");
			return;
									
		}
		boolean food = foodCh(searchName);
		if(!food) {
			JOptionPane.showMessageDialog(this, "검색하신 음식명은 존재하지 않습니다.");
			return;
		}
		new KcalList(this);
	}
	


	private void viewSetData(KcalDto dto) {
		int No = dto.getNo();
		tfNo.setText("" + No);
		int Kcal = dto.getKcal();
		tfKcal.setText("" + Kcal);
		tfFname.setText(dto.getFname());
	}
	private void viewSetData2(TodayDto dto) {
		
		 int mkcal = dto.getMKcal();
		 tfMKcal.setText("" + mkcal);
		 tfMName.setText(dto.getMname());
		 int lkcal = dto.getLKcal();
		 tfLKcal.setText("" + lkcal);
		 tfLName.setText(dto.getLname());
		 int ekcal = dto.getEKcal();
		 tfEKcal.setText("" + ekcal);
		 tfEName.setText(dto.getEname());
		 int totalkcal = dto.getTotalKcal();
		 tfTKcal.setText("" + totalkcal);
	}
	
public static Connection getCon() {
	Connection conn = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	String url = "jdbc:mysql://jspdb1.hosting.paran.com:3306/mes2012_db";
	String user = "mes2012";
	String password = "m201212";
	try {
		conn = DriverManager.getConnection(url, user, password);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return conn;
}//getCon

private KcalDto getDto() {
			
	String totalkcal = tfTotalKcal.getText();
	int total = Integer.parseInt(totalkcal);
	
	Date currentTime = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
	String dTime = formatter.format ( currentTime );

	KcalDto dto = new KcalDto();
	dto.setH_day(dTime);
	dto.setTotalkcal(total);
	return dto;
}// getDto

private boolean foodCh(String fname) {
	boolean ok = false;
	String sql = "select count(*) from foodkcal where fname = ?";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
		con = getCon();
		ps = con.prepareStatement(sql);
		
		ps.setString(1, fname);
		rs = ps.executeQuery();
		if(rs.next()) {
			int cnt = rs.getInt(1);						
			if(cnt == 1) {									
				ok=true;									
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//finally
	return ok;
}
}



