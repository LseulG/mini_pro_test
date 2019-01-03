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
	int loginCount; // checkLogin,getLoginCount
	String loginUser; // checkLogin,getUser,searchSalesStatus,searchProduct
	
	String productNo, productColor, productSize; // searchSalesStatus
	int productPrice, stockQuantity; // searchProduct, registerSales
	String productCode; // searchProduct, registerSales

	int dayTotalPrice = 0; 
	int monthTotalPrice = 0;
	
	JTable tableSave; // 테이블 저장소
	
	int statusCnt = 1;

	//LocalDate currDate = LocalDate.now();
	LocalDate currDate = LocalDate.of(2018, 11, 1);
	String currDateCode = "181101"; // salesDelete : SA_CODE

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

	// DB 연결 해제 - 로그아웃, 창닫기 할 때 종료
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

	// 로그인 
	// 로그인 체크
	public void checkLogin(String id, String pw, String divRadioResult) {
		String query;		
		
		if (divRadioResult.equals("매장")) {
			// 매장 테이블 검색
			query = "select m_id, m_pw from manager";
		} else { 
			// 본사 테이블 검색
			query = "select h_id, h_pw from head";
		}
		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (id.equals(rs.getString(1)) && pw.equals(rs.getString(2))) {
					// 로그인 성공
					this.loginCount = 1; 

					// 로그인 유저의 매장 코드 검색
					query = "select s_code from store where m_id='" + id + "'";
					pstmt = con.prepareStatement(query);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						this.loginUser = rs.getString(1); // 로그인 유저의 매장 코드 user에 입력
					}
					System.out.println("접속 매장:"+loginUser);
					break;
				} else {
					// 로그인 실패
					this.loginCount = 0;
				}
			}
			System.out.println("login query 성공");
		} catch (SQLException e) {
			System.out.println("login query 오류");
			e.printStackTrace();
		}
	}
	public Integer getLoginCount() {
		return loginCount;	 // 로그인 성공 여부 LoginView에 반환
	}
	public String getLoginUser() {
		return loginUser; 	// 로그인 유저 MainFrame에 반환
	}

	/****************************************************************/
	
	// 판매관리 - 판매등록 - 색상 콤보박스
	// 등록된 상품의 모든 컬러를 콤보박스 리스트에 연동
	public void listColorCombo(JComboBox<String> colorCombo) {
		String query = "select distinct p_color from product";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				colorCombo.addItem(rs.getString(1)); // 콤보박스 아이템에 추가
			}
			System.out.println("listColorCombo 성공");
		} catch (SQLException e) {
			System.out.println("listColorCombo 오류");
			e.printStackTrace();
		}
	}

	// 판매관리 - 판매등록 - 판매현황 테이블 
	// 해당 날짜의 판매 현황을 테이블에 추가
	// 판매등록-판매테이블.
	public void searchSalesStatus(JTable statusTable, Object date) {
		this.tableSave = statusTable;
		String salesDivText;
		
		String query = "select sa_no, sa_group, sales.p_code, p_price, sa_qty, sa_price\r\n" 
				+ "from sales, product\r\n" 
				+ "where sales.p_code = product.p_code\r\n" 
				+ "and sa_date = '"+ date +"' and s_code = '"+ loginUser +"' \r\n" 
				+ "order by sa_no"; 

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			dayTotalPrice = 0;

			while (rs.next()) {
				String salesNumber = rs.getString(1);
				int salesDivCode = rs.getInt(2);
				String productCode = rs.getString(3);
				String productPrice = rs.getString(4);
				String salesQuantity = rs.getString(5);
				int salesPrice = rs.getInt(6);

				if (salesDivCode == 1) {
					// 1:판매
					salesDivText = "판매";
				} else {
					// 2:반품
					salesDivText = "반품";
				}
				
				this.productNo = productCode.substring(0, 7);
				this.productColor = productCode.substring(7, 9);
				this.productSize = productCode.substring(9);
				
				dayTotalPrice += salesPrice;

				// 조회 결과 테이블에 추가
				Object newData[] = { salesNumber, salesDivText, productNo, productColor, productSize, productPrice, salesQuantity, salesPrice };
				DefaultTableModel newModel = (DefaultTableModel) statusTable.getModel();
				newModel.addRow(newData);
			}
			System.out.println("salesStatusSearch 성공");
		} catch (SQLException e) {
			System.out.println("salesStatusSearch 오류");
			e.printStackTrace();
		}
	}
	public Integer getDayTotalPrice() {
		return dayTotalPrice; // 일 총판매금액 SalesReg에 반환
	}
	
	// 판매관리 - 판매등록 - 조회 버튼
	// 상품 조회 및 판매단가,재고수량,코드 저장
	public void searchProduct(String productNo, String productColor, String productSize) {
		String query = "select p_price, p_qty, product.p_code from product, stock\r\n"
				+ "where product.p_code=stock.p_code \r\n" 
				+ "and s_code='" + this.loginUser + "'\r\n" + "and p_no='" + productNo
				+ "' and p_color='" + productColor + "' and p_size='" + productSize + "'";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				this.productPrice = rs.getInt(1);
				this.stockQuantity = rs.getInt(2);
				this.productCode = rs.getString(3);
			}
			System.out.println("searchProduct 성공");
		} catch (SQLException e) {
			System.out.println("searchProduct 오류");
			e.printStackTrace();
		}
	}
	public Integer getProductPrice() {
		return productPrice; // 판매단가 SalesReg, StockSearch에 반환
	}
	public Integer getStockQuantity() {
		return stockQuantity; // 재고수량 SalesReg에 반환
	}
	
	// 판매관리 - 판매등록 - 등록 버튼
	// 상품 판매,반품 데이터 삽입
	int n = 100;	//***
	public void registerSales(JTable totalTable, String salesDiv, String salesQuantity, String salesPrice) {
		int salesDivCode;		
		
		if (salesDiv.equals("판매")) {
			// 판매:1
			salesDivCode = 1;
		} else {
			// 반품:2
			salesDivCode = 2;
			salesQuantity = "-"+salesQuantity;
			salesPrice = "-"+salesPrice;
			productPrice = 0 - productPrice;
		}
		System.out.println("판매단가:"+productPrice);
	
//		sa_no_seq3.nextval
		String query = "insert into sales values('"+ currDateCode+loginUser+n +"',\r\n" 
				+ "to_date('"+currDate+"','yyyy-mm-dd'),\r\n" + n + ",'"
				+ loginUser +"',"+ salesDivCode +",'"+ productCode +"',"
				+ productPrice+"*"+salesQuantity +","+salesQuantity+ "," + salesPrice + ")";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			searchSalesStatus(tableSave,currDate);
				
			clear(totalTable);
			Object newData[] = { currDate, dayTotalPrice };
			DefaultTableModel newModel = (DefaultTableModel) totalTable.getModel();
			newModel.addRow(newData);

			n++; //***
			System.out.println("registerSales 성공");
		} catch (SQLException e) {
			System.out.println("registerSales 오류");
			e.printStackTrace();
		}
	}
	
	// 판매관리 - 판매등록 - 삭제 버튼
	// 선택한 행 데이터 삭제
	public void salesDelete(JTable totalTable, String salesNum, int salesPrice) {
		String salesCode = currDateCode + loginUser;
		
		if (salesNum.length() == 1) {
			salesCode = salesCode + "00" + salesNum;
		} else if (salesNum.length() == 2) {
			salesCode = salesCode + "0" + salesNum;
		} else {
			salesCode = salesCode + salesNum;
		}
		
		dayTotalPrice -= salesPrice;
		
		// 판매현황 테이블 데이터 삭제
		String query = "delete from sales where sa_code = '" + salesCode + "'";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			clear(totalTable);
			Object newData[] = { currDate, dayTotalPrice };
			DefaultTableModel newModel = (DefaultTableModel) totalTable.getModel();
			newModel.addRow(newData);
			
			System.out.println("salesDelete 성공");
		} catch (SQLException e) {
			System.out.println("salesDelete 오류");
			e.printStackTrace();
		}
	}
	
	/****************************************************************/
	
	// 판매관리 - 판매현황 - 조회 버튼
	// 선택한 월의 날짜별 데이터 조회
	public void searchStatus(JTable dayTable, String selectedDate) {
		this.tableSave = dayTable;
		this.monthTotalPrice = 0;
		
		String query = "select to_char(sa_date,'yyyy-mm-dd'), to_char(sa_date,'day'), \r\n"
				+"sum(sa_qty), sum(ps_price), sum(sa_price)\r\n" + 
				"from sales where s_code = '"+ loginUser +"'\r\n" + 
				"and sa_code like '"+ selectedDate +"%'\r\n" + 
				"group by sa_date order by sa_date";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
						
			while (rs.next()) {
				String date = rs.getString(1);
				String day = rs.getString(2);
				int salesQuantity = rs.getInt(3);
				int totalProductPrice = rs.getInt(4);
				int totalSalesPrice = rs.getInt(5);				
				this.monthTotalPrice += rs.getInt(5);
				
				Object newData[] = { date,day,salesQuantity,totalProductPrice,totalSalesPrice,monthTotalPrice};
				DefaultTableModel newModel = (DefaultTableModel) dayTable.getModel();
				newModel.addRow(newData);
			}
			System.out.println("searchStatus 성공");
		} catch (SQLException e) {
			System.out.println("searchStatus 오류");
			e.printStackTrace();
		}
	}
	public Integer getMonthTotalPrice() {
		return monthTotalPrice; // 월별 총판매금액 SalesStatus에 반환
	}
	
	/****************************************************************/
	
	// 재고관리 - 재고조회 - 조회 버튼
	// 해당 품번 재고 조회
	public void searchStock(JTable stockTable, String productNo) {
		this.tableSave = stockTable;

		String query = "select p_no, p_price, p_color, p_size, store.s_code, s_name, s_phone, stock.p_qty\r\n"
				+ "from product, stock, store\r\n" + "where product.p_code=stock.p_code\r\n"
				+ "and store.s_code=stock.s_code\r\n" + "and p_no='" + productNo + "'\r\n" + "order by store.s_code";

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				this.productPrice = rs.getInt(2);
				String productColor = rs.getString(3);
				String productSize = rs.getString(4);
				String storeCode = rs.getString(5);
				String storeName = rs.getString(6);
				String phone = rs.getString(7);
				String stockQuantity = rs.getString(8);
				
				Object newData[] = { productColor, productSize, storeCode, storeName, phone, stockQuantity };
				DefaultTableModel newModel = (DefaultTableModel) stockTable.getModel();
				newModel.addRow(newData);
			}
			System.out.println("searchStock 성공");
		} catch (SQLException e) {
			System.out.println("searchStock 오류");
			e.printStackTrace();
		}
	}
	
	//매장내 전체재고 조회 
	//public void searchStock(JTable table) {} 	

	// JTable 필드 초기화
	public void clear(JTable table) {
		DefaultTableModel newModel = (DefaultTableModel) table.getModel();
		while (newModel.getRowCount() > 0) {
			newModel.removeRow(0);
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
				this.productPrice = str;
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