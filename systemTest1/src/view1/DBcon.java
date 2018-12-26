package view1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DBcon {
	JTable table;
	String code, price;
	
	// db 연동
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public DBcon() {
		connect();
	}
	
	public void connect() {
		String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
		String ID = "project1";
		String PW = "pro1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, ID, PW);
			System.out.println("DB접속");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB접속 오류");
			e.printStackTrace();
		}
	}
	
	public void stock_select(JTable table, String code) {
		this.table = table;
		this.code = code;
		//품번, 단가/ 색상, 사이즈, 매장코드, 매장명, 전화번호, 재고
		String query = "select p_no, p_price, p_color, p_size, store.s_code, s_name, s_phone, stock.p_qty\r\n" + 
				"from product, stock, store\r\n" + "where product.p_code=stock.p_code\r\n" + 	
				"and store.s_code=stock.s_code\r\n"+ "and p_no='"+code+"'\r\n" + "order by store.s_code";
		
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String p_price=rs.getString(2);
				String color=rs.getString(3);
				String size=rs.getString(4);
				String s_code=rs.getString(5);
				String s_name=rs.getString(6);
				String phone=rs.getString(7);
				String qty=rs.getString(8);
				
				System.out.println(color+size+s_code+s_name+phone+qty);
				this.price = p_price;
				Object data[] = {color,size,s_code,s_name,phone,qty};	
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.addRow(data);
			}
			
		} catch (SQLException e) {
			System.out.println("stock_select 오류");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				System.out.println("DB 종료 오류");
			}
		}
	}
	
	public String getPrice() {
		return price;
	}
	
	public void clear(JTable table) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		while(model.getRowCount()>0) {
			model.removeRow(0);
		}		
	}
}
