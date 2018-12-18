package co.kr.team.main;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import co.kr.team.main.*;

public class MemberInfo extends JFrame implements ActionListener {

		JPanel mainP;
		JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13;
		JTextField tfId, tfPwd, tfName, tfAge, tfHp1, tfHp2, tfHp3, tfEmail1,
				tfEmail2, tfAddr, tfHeight, tfWeight, tfHopeWeight, tfWaist;
		JRadioButton rbSex1, rbSex2;
		JButton btnUpdate, btnDelete, btnMyinfo;
		MainFrame m;

		public MemberInfo() {
			setTitle("회원정보");
			mainP = new JPanel(new GridLayout(14, 1));
			add(mainP);

			p1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
			p2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
			p3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
			p4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
			p5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
			p6 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
			p7 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
			p8 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
			p9 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
			p10 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
			p11 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
			p12 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
			p13 = new JPanel();

			mainP.add(p1);
			mainP.add(p2);
			mainP.add(p3);
			mainP.add(p4);
			mainP.add(p5);
			mainP.add(p6);
			mainP.add(p7);
			mainP.add(p8);
			mainP.add(p9);
			mainP.add(p10);
			mainP.add(p11);
			mainP.add(p12);
			mainP.add(p13);

			// p1 내용
			p1.add(new JLabel("I              D : "));
			p1.add(tfId = new JTextField(10));


			// p2 내용
			p2.add(new JLabel("비밀번호 : "));
			p2.add(tfPwd = new JTextField(14));

			// p3 내용
			p3.add(new JLabel("이         름 : "));
			p3.add(tfName = new JTextField(8));

			// p4 내용
			p4.add(new JLabel("성         별 : "));
			rbSex1 = new JRadioButton("남");
			rbSex2 = new JRadioButton("여");
			ButtonGroup bg = new ButtonGroup(); // Group 으로 묶은다음에 붙여아 하나씩 선택됨.
			bg.add(rbSex1);
			bg.add(rbSex2);
			p4.add(rbSex1);
			p4.add(rbSex2);

			p5.add(new JLabel("나         이 : "));
			p5.add(tfAge = new JTextField(3));

			p6.add(new JLabel("핸  드  폰 : "));
			p6.add(tfHp1 = new JTextField(4));
			p6.add(new JLabel("-"));
			p6.add(tfHp2 = new JTextField(4));
			p6.add(new JLabel("-"));
			p6.add(tfHp3 = new JTextField(4));

			p7.add(new JLabel("Email       : "));
			p7.add(tfEmail1 = new JTextField(10));
			p7.add(new JLabel("@"));
			p7.add(tfEmail2 = new JTextField(14));

			p8.add(new JLabel("주         소 : "));
			p8.add(tfAddr = new JTextField(40));

			p9.add(new JLabel("신         장 : "));
			p9.add(tfHeight = new JTextField(3));
			p9.add(new JLabel("cm"));

			p10.add(new JLabel("체         중 : "));
			p10.add(tfWeight = new JTextField(3));
			p10.add(new JLabel("kg"));

			p11.add(new JLabel("희망체중 : "));
			p11.add(tfHopeWeight = new JTextField(3));
			p11.add(new JLabel("kg"));

			p12.add(new JLabel("허리둘레 : "));
			p12.add(tfWaist = new JTextField(3));
			p12.add(new JLabel("inch"));

			btnMyinfo = new JButton("내 정보 불러오기");
			btnUpdate = new JButton("정보수정");
			btnDelete = new JButton("회원탈퇴");
			btnMyinfo.addActionListener(this);
			btnUpdate.addActionListener(this);
			btnDelete.addActionListener(this);
			p13.add(btnMyinfo);
			p13.add(btnUpdate);
			p13.add(btnDelete);

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(550, 500);
			setVisible(true);

		}// joinDiet

		public static void main(String[] args) {
			new MemberInfo();
		}// main

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnMyinfo) {
				callInfo();
			}
			if(e.getSource()==btnUpdate) {
				boolean b=  checkData();
				if(b) {
					boolean ok = updateInfo();
					if(ok) {
						JOptionPane.showMessageDialog(this, "회원정보 수정에 성공하셨습니다.^^");
						tfId.setEditable(true);
					}else {
						JOptionPane.showMessageDialog(this, "수정 실패!");
					}
				}
			}
			if(e.getSource()==btnDelete) {
				boolean ok = deleteInfo();
				if(ok) {
					JOptionPane.showMessageDialog(this, "회원 탈퇴가 완료되었습니다.lol \n 이용해주셔서 감사합니다.");
					tfId.setEditable(true);
					clearView();
				}else {
					JOptionPane.showMessageDialog(this, "회원탈퇴 실패!");
				}
			}
		}// actionPerformed

		private  boolean deleteInfo() {
			String id = m.textField_1.getText();
			boolean ok = JoinDao.deleteMem(id);										// DB 처리
			return ok;			
		}

		private boolean updateInfo() {
			JoinDto dto = getDto();
			boolean ok = JoinDao.updateMem(dto);

			return ok;
		}

		private void callInfo() {
			String myId = m.textField_1.getText();
			JoinDto dto = JoinDao.selectMem(myId);
			if(dto!=null) {
				setData(dto);
			}
			System.out.println(dto);
	
		}

		private void setData(JoinDto dto) {
			tfId.setText(dto.getId());
			tfPwd.setText(dto.getPwd());
			tfName.setText(dto.getName());
			String sex = dto.getSex();
			if(sex.equals("남")) {
				rbSex1.setSelected(true);
			}else {
				rbSex2.setSelected(true);
			}
			int age = dto.getAge();
			tfAge.setText(""+age);
			
			String hp = dto.getHp();
			String[] arrHp = hp.split("-");
			tfHp1.setText(arrHp[0]);
			tfHp2.setText(arrHp[1]);
			tfHp3.setText(arrHp[2]);
			
			String email = dto.getEmail();
			String[] arrEmail = email.split("@");
			tfEmail1.setText(arrEmail[0]);
			tfEmail2.setText(arrEmail[1]);
			
			tfAddr.setText(dto.getAddr());
			
			int height = dto.getHeight();
			tfHeight.setText(""+height);
			
			int weight = dto.getWeight();
			tfWeight.setText(""+weight);
			
			int hopeWeight = dto.getHopeweight();
			tfHopeWeight.setText(""+hopeWeight);
			
			int waist = dto.getWaist();
			tfWaist.setText(""+waist);
		}

		private boolean checkData() {
			boolean ok = false;
			String id = tfId.getText();
			if(id.length()==0) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요!");
				tfId.requestFocus();															//아이디에 커서를 둔다
				return false;
			}
			
			String pwd = tfPwd.getText();
			if(pwd.length()==0) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요!");
				tfPwd.requestFocus();															
				return false;
			}
			
			String name = tfName.getText();
			if(name.length()==0) {
				JOptionPane.showMessageDialog(this, "이름을 입력해주세요!");
				tfName.requestFocus();															
				return false;
			}
			
			boolean sex = rbSex1.isSelected() | rbSex2.isSelected();
			if(!sex) {
				JOptionPane.showMessageDialog(this, "성별을 선택해주세요!");
				return false;
			}
		
			String strAge = tfAge.getText();
			int age = 0;
			try {
				age = Integer.parseInt(strAge);
			}catch(NumberFormatException e) {
				JOptionPane.showConfirmDialog(this,"나이를 숫자로 입력해주세요!", "메시지", 2, 1);
				tfAge.setText("");
				tfAge.requestFocus();
				return false;
			}
			
			String hp1 = tfHp1.getText();
			if(hp1.length()==0) {
				JOptionPane.showMessageDialog(this, "핸드폰 번호 앞자리 3자리를 입력해주세요!");
				tfHp1.requestFocus();	
				return false;
			}else if(hp1.length()>3) {
				JOptionPane.showMessageDialog(this, "핸드폰 번호 앞자리는 3글자까지만 입력해주세요!");
				tfHp1.requestFocus();	
				return false;
			}
			String hp2 = tfHp2.getText();
			if(hp2.length()==0) {
				JOptionPane.showMessageDialog(this, "핸드폰 번호 중간자리 4자리를 입력해주세요!");
				tfHp2.requestFocus();	
				return false;
			}else if(hp2.length()>4) {
				JOptionPane.showMessageDialog(this, "핸드폰 번호 중간자리는 4글자까지만 입력해주세요!");
				tfHp2.requestFocus();	
				return false;
			}
			String hp3 = tfHp3.getText();
			if(hp3.length()==0) {
				JOptionPane.showMessageDialog(this, "핸드폰 번호 뒷자리 4자리를 입력해주세요!");
				tfHp3.requestFocus();	
				return false;
			}else if(hp3.length()>4) {
				JOptionPane.showMessageDialog(this, "핸드폰 번호 뒷자리는 4글자까지만 입력해주세요!");
				tfHp3.requestFocus();	
				return false;
			}
			
			String email1 = tfEmail1.getText();
			if(email1.length()==0) {
				JOptionPane.showMessageDialog(this, "Email 앞자리를 입력해주세요!");
				tfEmail1.requestFocus();	
				return false;
			}
			String email2 = tfEmail2.getText();
			if(email2.length()==0) {
				JOptionPane.showMessageDialog(this, "Email 뒷자리를 입력해주세요!");
				tfEmail2.requestFocus();	
				return false;
			}
			String email = tfEmail1.getText() + tfEmail2.getText();
			if(email.length()>30) {
				JOptionPane.showMessageDialog(this, "Email은 30글자내로 입력하세요!");
				tfEmail1.setText("");
				tfEmail1.requestFocus();	
				return false;
			}
		
			String addr = tfAddr.getText();
			if(addr.length()==0) {
				JOptionPane.showMessageDialog(this, "주소를 입력하세요!");
				tfAddr.requestFocus();
				return false;
			}else if(addr.length()>50) {
				JOptionPane.showMessageDialog(this, "주소는 50글자 내로 입력하세요!");
				tfAddr.requestFocus();
				return false;
			}
			
			String strHeight = tfHeight.getText();
			int height = 0;
			try {
				height = Integer.parseInt(strHeight);
			}catch(NumberFormatException e) {
				JOptionPane.showConfirmDialog(this,"신장을 숫자로 입력해주세요!", "메시지", 2, 1);
				tfHeight.setText("");
				tfHeight.requestFocus();
				return false;
			}
			
			String strWeight = tfWeight.getText();
			int weight = 0;
			try {
				weight = Integer.parseInt(strWeight);
			}catch(NumberFormatException e) {
				JOptionPane.showConfirmDialog(this,"체중을 숫자로 입력해주세요!", "메시지", 2, 1);
				tfWeight.setText("");
				tfWeight.requestFocus();
				return false;
			}
			
			String strHopweight = tfHopeWeight.getText();
			int hopeweight = 0;
			try {
				hopeweight = Integer.parseInt(strHopweight);
			}catch(NumberFormatException e) {
				JOptionPane.showConfirmDialog(this,"희망체중을 숫자로 입력해주세요!", "메시지", 2, 1);
				tfHopeWeight.setText("");
				tfHopeWeight.requestFocus();
				return false;
			}
			
			String strWaist = tfWaist.getText();
			int waist = 0;
			try {
				waist = Integer.parseInt(strWaist);
			}catch(NumberFormatException e) {
				JOptionPane.showConfirmDialog(this,"허리둘레를 숫자로 입력해주세요!", "메시지", 2, 1);
				tfWaist.setText("");
				tfWaist.requestFocus();
				return false;
			}		
			ok=true;
			return ok;
		}

		private void clearView() {
			
			tfId.setText("");
			tfPwd.setText("");
			tfName.setText("");
			tfAge.setText("");
			tfHp1.setText("");
			tfHp2.setText("");
			tfHp3.setText("");
			tfEmail1.setText("");
			tfEmail2.setText("");
			tfAddr.setText("");
			tfHeight.setText("");
			tfWeight.setText("");
			tfHopeWeight.setText("");
			tfWaist.setText("");
		
		}

		private JoinDto getDto(){
		// ID, PWD, NAME, SEX, AGE, HP, EMAIL, ADDR, HEIGHT, WEIGHT, HOPEWEIGHT, WAIST
			String id = tfId.getText();
			String pwd = tfPwd.getText();
			String name = tfName.getText();
			String sex = null;
			if(rbSex1.isSelected()) {
				sex="남";
			}else { sex="여";}
			String strAge = tfAge.getText();
			int age = Integer.parseInt(strAge);
			String hp = tfHp1.getText() + "-" + tfHp2.getText() + "-" + tfHp3.getText();
			String email = tfEmail1.getText() + "@" + tfEmail2.getText();
			String addr = tfAddr.getText();
			String srtHeight = tfHeight.getText();
			int height = Integer.parseInt(srtHeight);
			String strWeight = tfWeight.getText();
			int weight = Integer.parseInt(strWeight);
			String srtHopeweight = tfHopeWeight.getText();
			int hopeweight = Integer.parseInt(srtHopeweight);
			String strWaist = tfWaist.getText();
			int waist = Integer.parseInt(strWaist);
			
			//DTO를 만들어서 11개의 값들을 셋팅한다.
			JoinDto dto = new JoinDto();
			dto.setId(id);
			dto.setPwd(pwd);
			dto.setName(name);
			dto.setSex(sex);
			dto.setAge(age);
			dto.setHp(hp);
			dto.setEmail(email);
			dto.setAddr(addr);
			dto.setHeight(height);
			dto.setWeight(weight);
			dto.setHopeweight(hopeweight);
			dto.setWaist(waist);
			System.out.println("dto="+dto);
			
			
			return dto;
		} //getDto

		// 데이터베이스 연결 메소드
		public Connection getCon() {
			Connection con = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String url = "jdbc:oracle:thin:@172.16.0.101:1522:orcl";
			String user = "scott";
			String password = "tiger";
			try {
				con = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}// getCon

	}// end
