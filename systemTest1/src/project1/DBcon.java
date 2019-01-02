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

	// DB 연동
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public DBcon() {
		connect();
	}

	// DB 연결
	public void connect() {
		String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
		String ID = "project2";
		String PW = "pro2";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, ID, PW);
			System.out.println("DB접속");

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB접속 오류");
			e.printStackTrace();
		}
	}

	// DB 연결 해제
	// +) 로그아웃, 창닫기 할 때 종료
	public void disconn() {
		try {
			System.out.println("DB 종료");
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("DB 종료 오류");
		}
	}

	// 로그인 - 로그인 체크
	public void loginCheck(String id, String pw, String radio) {
		String query;
		if (radio.equals("매장")) {
			query = "select m_id, m_pw from manager";
		} else { // radio = 본사
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
						String s_user = rs.getString(1); // 로그인 유저의 매장 코드 user에 입력
						this.user = s_user;
					}
					System.out.println(user);
					break;
				} else {
					this.logCnt = 0;
				}
			}
			System.out.println("login query 성공");
		} catch (SQLException e) {
			System.out.println("login query 오류");
			e.printStackTrace();
		}
	}

	public Integer getLogCnt() {
		return logCnt;	 // 로그인 성공 여부 반환
	}
	public String getUser() {
		return user; 	// 로그인 유저 반환
	}

	
	
	// 재고조회 - 전체 매장 재고 조회
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
			System.out.println("searchStock 성공");
		} catch (SQLException e) {
			System.out.println("searchStock 오류");
			e.printStackTrace();
		}
	}

	public Integer getPrice() {
		return price; // 해당 품번 판매단가 반환
	}

	// 판매등록 - 상품 전체의 컬러 combobox list에 추가
	public void combo_color(JComboBox<String> combo) {
		String query = "select distinct p_color from product";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				combo.addItem(rs.getString(1));
			}
			System.out.println("combo_color 성공");
		} catch (SQLException e) {
			System.out.println("combo_color 오류");
			e.printStackTrace();
		}
	}

	// 판매등록 - 판매현황 테이블
	public void salesStatusSearch(JTable table) {
		this.table = table;
		
		String query = "select sa_no, sa_group, sales.p_code, p_price, sa_qty, sa_price\r\n" + 
				"from sales, product\r\n" + 
				"where sales.p_code = product.p_code\r\n" + 
				"and sa_date = '18/11/01' and s_code = '"+ user +"' \r\n" + 
				"order by sa_no"; 

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String salesNumber = rs.getString(1);
				groupInt = rs.getInt(2);
				String productCode = rs.getString(3);
				String productPrice = rs.getString(4);
				String productQty = rs.getString(5);
				int salesPrice = rs.getInt(6);

				String groupStr;
				if (groupInt == 1) {
					groupStr = "판매";
				} else {
					groupStr = "반품";
				}
				this.no = productCode.substring(0, 7);
				this.color = productCode.substring(7, 9);
				this.size = productCode.substring(9);
				totalPrice += salesPrice;

				Object data[] = { salesNumber, groupStr, no, color, size, productPrice, productQty, salesPrice };
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(data);
			}
			System.out.println("salesStatusSearch 성공");
		} catch (SQLException e) {
			System.out.println("salesStatusSearch 오류");
			e.printStackTrace();
		}
	}
	public Integer getTotalPrice() {
		return totalPrice; // 총판매금액
	}
	
	// 판매등록 - 조회
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
			System.out.println("pro_select 성공");
		} catch (SQLException e) {
			System.out.println("pro_select 오류");
			e.printStackTrace();
		}
	}

	public Integer getQty() {
		return qty; // 해당 품번 판매단가 반환
	}
	
	// 판매등록 - 등록
	// +) insert 
	public void pro_reg(JTable table, String group, String s_qty, String s_price) {
		this.table = table;
		if (group.equals("판매")) {
			this.groupInt = 1;
		} else {
			this.groupInt = 2;
			s_price = "-"+s_price;
		}
		this.code = no + color + size ;
		
		System.out.println(groupInt);
		
//		String query = "insert into sales values('"+ "181101"+user+"088" +"',sa_no_seq3.nextval,\r\n" + 
		String query = "insert into sales values('"+ "181101"+user+"089" +"',\r\n" + 
				"to_date('2018-11-01','yyyy-mm-dd'),\r\n" + "89" +
				",'"+ user +"',"+ groupInt +",'"+ code +"',"+s_qty+","+s_price+")";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			salesStatusSearch(table);

			System.out.println("pro_reg 성공");
		} catch (SQLException e) {
			System.out.println("pro_reg 오류");
			e.printStackTrace();
		}
	}

	// JTable 필드 초기화
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

			JOptionPane.showMessageDialog(null, "입력되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "입력오류.");
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
			JOptionPane.showMessageDialog(null, "변경되었습니다.");

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
				"sr.s_code=sc.s_code and sr.s_name = '뉴코아광명' and pro.p_no = 1811001 \r\n" + 
				"and pro.p_color = 'BK' and pro.p_size = 'S'";
		String M_query = "select sc.p_qty from product pro,stock sc,store sr\r\n" + 
				"Where pro.p_code = sc.p_code and\r\n" + 
				"sr.s_code=sc.s_code and sr.s_name = '뉴코아광명' and pro.p_no = 1811001 \r\n" + 
				"and pro.p_color = 'BK' and pro.p_size = 'M'";
		String L_query = "select sc.p_qty from product pro,stock sc,store sr\r\n" + 
				"Where pro.p_code = sc.p_code and\r\n" + 
				"sr.s_code=sc.s_code and sr.s_name = '뉴코아광명' and pro.p_no = 1811001 \r\n" + 
				"and pro.p_color = 'BK' and pro.p_size = 'L'";
		String XL_query = "select sc.p_qty from product pro,stock sc,store sr\r\n" + 
				"Where pro.p_code = sc.p_code and\r\n" + 
				"sr.s_code=sc.s_code and sr.s_name = '뉴코아광명' and pro.p_no = 1811001 \r\n" + 
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