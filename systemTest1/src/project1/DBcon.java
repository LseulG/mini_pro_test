package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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

	//LocalDate currDate = LocalDate.now();
	LocalDate currDate = LocalDate.of(2018, 11, 1);
	String dateCode = "181101";

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
					System.out.println("���� ���� �ڵ�:"+user);
					break;
				} else {
					this.logCnt = 0;
				}
			}
			System.out.println("login query ����");
		} catch (SQLException e) {
			System.out.println("login query ����");
			e.printStackTrace();
		}
	}

	public Integer getLogCnt() {
		return logCnt;	 // �α��� ���� ���� ��ȯ
	}
	public String getUser() {
		return user; 	// �α��� ���� ��ȯ
	}

	
	// ������ - �����ȸ (��ü ���� ��� ��ȸ)
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

	// �ǸŰ��� - �Ǹŵ�� - ���� (��ǰ ��ü�� �÷� combobox list�� �߰�)
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
	public void salesStatusSearch(JTable table, Object date) {
		this.table = table;
		
		String query = "select sa_no, sa_group, sales.p_code, p_price, sa_qty, sa_price\r\n" + 
				"from sales, product\r\n" + 
				"where sales.p_code = product.p_code\r\n" + 
				"and sa_date = '"+ date +"' and s_code = '"+ user +"' \r\n" + 
				"order by sa_no"; 

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			totalPrice = 0;

			while (rs.next()) {
				String salesNumber = rs.getString(1);
				groupInt = rs.getInt(2);
				String productCode = rs.getString(3);
				String productPrice = rs.getString(4);
				String productQty = rs.getString(5);
				int salesPrice = rs.getInt(6);

				String groupStr;
				if (groupInt == 1) {
					groupStr = "�Ǹ�";
				} else {
					groupStr = "��ǰ";
				}
				this.no = productCode.substring(0, 7);
				this.color = productCode.substring(7, 9);
				this.size = productCode.substring(9);
				totalPrice += salesPrice;

				Object data[] = { salesNumber, groupStr, no, color, size, productPrice, productQty, salesPrice };
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
	
	// �Ǹŵ�� - ��ȸbtn 
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
	
	// �Ǹŵ�� - ���btn
	int n = 100;	//***
	public void pro_reg(JTable totalTable, JTable salesTable, String group, String productPrice, String s_qty, String s_price) {
		this.table = salesTable;
		if (group.equals("�Ǹ�")) {
			this.groupInt = 1;
		} else {
			this.groupInt = 2;
			s_price = "-"+s_price;
			productPrice = "-"+productPrice;
		}
		this.code = no + color + size ;
		
		System.out.println("�ܰ�:"+productPrice);

		
//		sa_no_seq3.nextval
		String query = "insert into sales values('"+ dateCode+user+n +"',\r\n" + 
				"to_date('"+currDate+"','yyyy-mm-dd'),\r\n" + n +
				",'"+ user +"',"+ groupInt +",'"+ code +"',"+ productPrice+"*"+s_qty +","+s_qty+ "," + s_price + ")";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			salesStatusSearch(table,currDate);
				
			clear(totalTable);
			Object data[] = { currDate, totalPrice };
			DefaultTableModel model = (DefaultTableModel) totalTable.getModel();
			model.addRow(data);

			n++; //***
			System.out.println("pro_reg ����");
		} catch (SQLException e) {
			System.out.println("pro_reg ����");
			e.printStackTrace();
		}
	}
	
	// �Ǹ���Ȳ - �Ǹŵ�� - ����btn
	public void salesDelete(String salesNum) {
		//String salesCode = sdf.format(currDate2) + user;
		String salesCode = dateCode + user;
		
		System.out.println(salesNum);
		
		if (salesNum.length() == 1) {
			salesCode = salesCode + "00" + salesNum;
		} else if (salesNum.length() == 2) {
			salesCode = salesCode + "0" + salesNum;
		} else {
			salesCode = salesCode + salesNum;
		}
		
		System.out.println("����:" + salesCode);
		
		String query = "delete from sales where sa_code = '" + salesCode + "'";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			System.out.println("salesDelete ����");
		} catch (SQLException e) {
			System.out.println("salesDelete ����");
			e.printStackTrace();
		}
	}
	
	// �ǸŰ��� - �Ǹ���Ȳ - ��ȸbtn
	public void searchStatus(JTable table, String date) {
		this.table = table;
		int totalSalesPrice = 0;
		
		String query = "select to_char(sa_date,'yyyy-mm-dd'), to_char(sa_date,'day'), sum(sa_qty), sum(ps_price), sum(sa_price)\r\n" + 
				"from sales where s_code = '"+ user +"'\r\n" + 
				"and sa_code like '"+ date +"%'\r\n" + 
				"group by sa_date order by sa_date";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
						
			while (rs.next()) {
				totalSalesPrice += rs.getInt(5);
				
				Object data[] = { rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), totalSalesPrice};
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(data);
			}
			System.out.println("searchStatus ����");
		} catch (SQLException e) {
			System.out.println("searchStatus ����");
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
	
	/*************************************************************************/

	public void insertProduct(String p_code, String p_no, String p_color, String p_size, String p_price) {

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

	public void searchProduct(String p_no) {
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

	public void updatePrice(String c_price, String p_no) {
		String query = "UPDATE PRODUCT SET P_PRICE = " + c_price + "WHERE P_NO = " + p_no;

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getStoreNameCombobox(JComboBox storeComboBox) {
		String query = "select distinct sr.s_name from store sr, stock sc "
				+ "where sr.s_code = sc.s_code and sc.p_qty > 0";
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				storeComboBox.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchStock(JComboBox colorComboBox,JComboBox getStoreComboBox,String p_no) {
		String query = "select distinct pro.p_color from product pro,stock sc,store sr\r\n" + 
				"Where pro.p_code = sc.p_code and\r\n" + 
				"sr.s_code = sc.s_code and\r\n" + 
				"pro.p_no ="+p_no+ "\r\n"+
				"and sr.s_name ='"+getStoreComboBox.getSelectedItem()+"'";
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				colorComboBox.addItem(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchSize(String s_name,String p_no,String p_color) {
		String S_query = "select sc.p_qty from product pro,stock sc,store sr\r\n" + 
				"Where pro.p_code = sc.p_code and\r\n" + 
				"sr.s_code=sc.s_code and sr.s_name = '���ھƱ���' and pro.p_no = 1811001 \r\n" + 
				"and pro.p_color = 'BK' and pro.p_size = 'S'";
		String M_query = "select sc.p_qty from product pro,stock sc,store sr\r\n" + 
				"Where pro.p_code = sc.p_code and\r\n" + 
				"sr.s_code=sc.s_code and sr.s_name = '���ھƱ���' and pro.p_no = 1811001 \r\n" + 
				"and pro.p_color = 'BK' and pro.p_size = 'M'";
		String L_query = "select sc.p_qty from product pro,stock sc,store sr\r\n" + 
				"Where pro.p_code = sc.p_code and\r\n" + 
				"sr.s_code=sc.s_code and sr.s_name = '���ھƱ���' and pro.p_no = 1811001 \r\n" + 
				"and pro.p_color = 'BK' and pro.p_size = 'L'";
		String XL_query = "select sc.p_qty from product pro,stock sc,store sr\r\n" + 
				"Where pro.p_code = sc.p_code and\r\n" + 
				"sr.s_code=sc.s_code and sr.s_name = '���ھƱ���' and pro.p_no = 1811001 \r\n" + 
				"and pro.p_color = 'BK' and pro.p_size = 'XL'";
		try {
			if(s_name.equals("S")) {

			}else if(s_name.equals("M")) {

			}else if(s_name.equals("L")) {

			}else if(s_name.equals("XL")) {

			}
			pstmt = con.prepareStatement(S_query);
			rs = pstmt.executeQuery();




		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}