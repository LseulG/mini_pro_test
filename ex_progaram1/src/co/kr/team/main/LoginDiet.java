package co.kr.team.main;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import co.kr.team.bimando.Bimando;

public class LoginDiet extends JInternalFrame implements ActionListener{
	
	JPanel p;
	JPanel p1,p2,p3,p4,p5,p6,p7;
	JTextField tfId;
	JPasswordField tfPwd;
	JButton btnLogin, btnJoin;
	MainFrame m;
	
	
	public LoginDiet(MainFrame m) {
		this.m = m;
		setTitle("LOGIN");
		
		p = new JPanel(new GridLayout(7, 1));
		add(p);
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
		p4 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		p.add(p6);
		p.add(p7);

		
		p3.add(new JLabel("    I     D     : "));
		p3.add(tfId=new JTextField(14));
		
		p4.add(new JLabel("비밀번호 : "));
		p4.add(tfPwd=new JPasswordField(14));
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		p5.add(btnLogin);
		
		btnJoin = new JButton("회원가입");
		btnJoin.addActionListener(this);
		p5.add(btnJoin);
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		//new loginDiet(m);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLogin) {
			String id = tfId.getText();
			String pwd = tfPwd.getText();
			boolean loginOk = loginOk();
			boolean idOk = loginIdOk();
			if(id.length()==0) {
				JOptionPane.showMessageDialog(this, "아이디를 입력해주세요.");
				return;
			}else if(pwd.length()==0) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요.");
				return;
			}
			if(idOk!=true){
				JOptionPane.showMessageDialog(this, "등록되지 않은 아이디입니다!");
				return;
			}if(!loginOk){
				JOptionPane.showMessageDialog(this, "비밀번호가 틀렸습니다!");
				return;
			}if(loginOk) {
				JOptionPane.showMessageDialog(this, "로그인이 완료되었습니다.^^");
				//new joinDto(id);
				//new Bimando(id);
				m.textField_1.setText(id);
				dispose(); //로그인 후 창 닫힘
			   
			  return;
			}
			
		}//btnLogin
		
		if(e.getSource()==btnJoin) {
			JOptionPane.showMessageDialog(this, "회원가입 화면으로 넘어갑니다^^");
			new JoinDiet();
		}//btnJoin

	}//actionPerformed
	
	
	private boolean loginOk() {
		String id = tfId.getText();
		String pwd = tfPwd.getText();
		boolean ok = false;
		String sql = "select count(*) from joindiet where id = ? and pwd = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				int cnt = rs.getInt(1);						// 1은 첫번째 결과 컬럼
				if(cnt == 1) {								
					ok=true;									// ok = true => 사용 가능
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
	}//loginOk
	
	

	private boolean loginIdOk() {
		String id = tfId.getText();
		boolean ok = false;
		String sql = "select count(*) from joindiet where id = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				int cnt = rs.getInt(1);						// 1은 첫번째 결과 컬럼
				if(cnt == 1) {									
					ok=true;									// ok = true => 사용 가능
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
	}//loginIdOk

	// 데이터베이스 연결 메소드
	public Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://jspdb1.hosting.paran.com:3306/mes2012_db";
		String user = "mes2012";
		String password = "m201212";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}// getCon
}
