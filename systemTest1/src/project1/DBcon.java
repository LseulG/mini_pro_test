package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBcon {
	JTable table; // stock_select
	String no, color, size; // stock_select, getPrice
	String user, code; // login
	int logCnt; // login
	int statusCnt = 1;
	int price, qty, groupInt; // pro_select
	int totalPrice = 0;

	LocalDate currDate = LocalDate.now();

	// DB ����
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public DBcon() {
		connect();
	}

	// DB ����
	public void connect() {
		String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
		String ID = "project2";
		String PW = "pro2";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, ID, PW);
			System.out.println("DB����");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB���� ����");
			e.printStackTrace();
		}
	}

	// DB ���� ����
	// +) �α׾ƿ�, â�ݱ� �� �� ����
	public void disconn() {
		try {
			System.out.println("DB ����");
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("DB ���� ����");
		}
	}

	// �α��� - �α��� üũ
	public void loginCheck(String id, String pw, String radio) {
		String query;
		if (radio.equals("����")) {
			query = "select m_id, m_pw from manager";
		} else { // radio = ����
			query = "select h_id, h_pw from head";
		}

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (id.equals(rs.getString(1)) && pw.equals(rs.getString(2))) {
					this.logCnt = 1;

					query = "select s_code from store where m_id='" + id + "'";
					pstmt = con.prepareStatement(query);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						String s_user = rs.getString(1); // �α��� ������ ���� �ڵ� user�� �Է�
						this.user = s_user;
					}
					System.out.println(user);
					break;
				} else {
					this.logCnt = 2;
				}
			}
			System.out.println("login query ����");
		} catch (SQLException e) {
			System.out.println("login query ����");
			e.printStackTrace();
		}
	}

	// �α��� ���� ���� ��ȯ
	public Integer getLogCnt() {
		return logCnt;
	}

	// �����ȸ - ��ü ���� ��� ��ȸ
	public void searchStock(JTable table, String no) {
		this.table = table;
		this.no = no;

		String query = "select p_no, p_price, p_color, p_size, store.s_code, s_name, s_phone, stock.p_qty\r\n"
				+ "from product, stock, store\r\n" + "where product.p_code=stock.p_code\r\n"
				+ "and store.s_code=stock.s_code\r\n" + "and p_no='" + no + "'\r\n" + "order by store.s_code";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int p_price = rs.getInt(2);
				String color = rs.getString(3);
				String size = rs.getString(4);
				String s_no = rs.getString(5);
				String s_name = rs.getString(6);
				String phone = rs.getString(7);
				String qty = rs.getString(8);

				this.price = p_price;
				Object data[] = { color, size, s_no, s_name, phone, qty };
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(data);
			}
			System.out.println("searchStock ����");
		} catch (SQLException e) {
			System.out.println("searchStock ����");
			e.printStackTrace();
		}
	}

	public Integer getPrice() {
		return price; // �ش� ǰ�� �ǸŴܰ� ��ȯ
	}

	// SalesReg - ��ǰ ��ü�� �÷� combobox list�� �߰�
	public void combo_color(JComboBox<String> combo) {
		String query = "select distinct p_color from product";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				combo.addItem(rs.getString(1));
			}
			System.out.println("combo_color ����");
		} catch (SQLException e) {
			System.out.println("combo_color ����");
			e.printStackTrace();
		}
	}

	// �Ǹŵ�� - �Ǹ���Ȳ ���̺�
	public void salesStatusSearch(JTable table) {
		this.table = table;
		
		String query = "select day_seq, sa_group, product.p_code, p_price ,sa_qty, sa_price \r\n" + 
				"from SAL_S1101201812 , product\r\n" + 
				"where SAL_S1101201812.p_code=product.p_code\r\n" + 
				"order by sa_seq"; 
		// SAL_S1101201812 : SAL_ �����ڵ�<user> ����<currDate.getYear()>
		// ��<currDate.getMonthValue()>
		// where sa_date=currDate

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String day_seq = rs.getString(1);
				groupInt = rs.getInt(2);
				String p_code = rs.getString(3);
				String p_price = rs.getString(4);
				String p_qty = rs.getString(5);
				int sa_price = rs.getInt(6);

				String groupStr;
				if (groupInt == 1) {
					groupStr = "�Ǹ�";
				} else {
					groupStr = "��ǰ";
				}
				this.no = p_code.substring(0, 7);
				this.color = p_code.substring(7, 9);
				this.size = p_code.substring(9);
				totalPrice += sa_price;

				Object data[] = { day_seq, groupStr, no, color, size, p_price, p_qty, sa_price };
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(data);
			}
			System.out.println("salesStatusSearch ����");
		} catch (SQLException e) {
			System.out.println("salesStatusSearch ����");
			e.printStackTrace();
		}
	}
	public Integer getTotalPrice() {
		return totalPrice; // ���Ǹűݾ�
	}
	
	// �Ǹŵ�� - ��ȸ
	public void pro_select(String no, String color, String size) {
		String query = "select p_price, p_qty, product.p_code from product, stock\r\n"
				+ "where product.p_code=stock.p_code \r\n" + "and s_code='" + this.user + "'\r\n" + "and p_no='" + no
				+ "' and p_color='" + color + "' and p_size='" + size + "'";

		this.no = no;
		this.color = color;
		this.size = size;
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				this.price = rs.getInt(1);
				this.qty = rs.getInt(2);
				this.code = rs.getString(3);
			}
			System.out.println("pro_select ����");
		} catch (SQLException e) {
			System.out.println("pro_select ����");
			e.printStackTrace();
		}
	}

	public Integer getQty() {
		return qty; // �ش� ǰ�� �ǸŴܰ� ��ȯ
	}
	
	// �Ǹŵ�� - ���
	// +) insert 
	public void pro_reg(JTable table, String group, String s_qty, String s_price) {
		this.table = table;
		if (group.equals("�Ǹ�")) {
			this.groupInt = 1;
		} else {
			this.groupInt = 2;
		}
		int daycnt = 1;
		this.code = no + color + size ;
		
		String query = "insert into SAL_S1101201812 values(sa12_sequence.nextval,\r\n" + 
				"to_date('2018-12-02','yyyy-mm-dd'),\r\n" + daycnt +
				",'"+ user +"',"+ groupInt +",'"+ code +"',"+s_qty+","+s_price+")";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			salesStatusSearch(table);

			System.out.println("pro_reg ����");
		} catch (SQLException e) {
			System.out.println("pro_reg ����");
			e.printStackTrace();
		}
	}

	// JTable �ʵ� �ʱ�ȭ
	public void clear(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	public void Insertpro(String p_code, String p_no, String p_color, String p_size, String p_price) {

		String query = "INSERT INTO PRODUCT VALUES(UPPER('" + p_code + "')," + p_no + ",UPPER('" + p_color
				+ "'),UPPER('" + p_size + "')," + p_price + ")";
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			JOptionPane.showMessageDialog(null, "�ԷµǾ����ϴ�.");

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�Է¿���.");
		}
	}

	public void SearchPro(String p_no) {
		String query = "SELECT DISTINCT P_PRICE FROM PRODUCT WHERE P_NO =" + p_no;
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int str = rs.getInt(1);
				this.price = str;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void UpdatePrice(String c_price, String p_no) {
		String query = "UPDATE PRODUCT SET P_PRICE = " + c_price + "WHERE P_NO = " + p_no;

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}