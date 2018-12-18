package co.kr.team.sports;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
public class SportsDao {
	
	private static void dbclose(Connection con, PreparedStatement ps) {
		if(ps !=null) {
		 try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		 	}
		}//if
		if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//if
	}//dbclose
	private static void dbclose(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//if
		dbclose(con, ps);
	}//dbclose
	
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "";
		String user = "";
		String password = "";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		}//getCon
	
	/*public static boolean insertVal(SportsDto2 dto) {
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into pi_sports(H_DAY,ID, SPORTS)"+
		"values(?,?,?)";
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			//? 13개를 채우자
			ps.setString(1,dto.getH_day());
			ps.setString(2,dto.getId());
			ps.setDouble(11,dto.getSports());
			int res = ps.executeUpdate();//실행
			if(res==1)ok = true;
			//if문에서 { } 을 빼면 한줄만 적용된다
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbclose(con, ps);
		}//finally
		return ok;
	
	}*/
	
	public static SportsDto selectVal(String motion) {
		SportsDto dto = null;
		String sql = "select firstval,upval from sportkcal where motion = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, motion);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new SportsDto();
				/*String id = rs.getString("id");
				dto.setId(id);  이러한 두줄짜리를 밑에 한줄로 줄인 거다 */
				dto.setFirstval(rs.getDouble("firstval"));
				dto.setUpval(rs.getDouble("upval"));
			}//if
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbclose(con, ps, rs);
		}//finally
		return dto;
	}//selectId
	
	/*public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",
				Locale.KOREA);
		Date currentTime = new Date();
		String dTime = formatter.format(currentTime);
	}// main
*/	
	 
	public static boolean insertVal(SportsDto2 dto) {
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into pi_sports(H_DAY, ID, SPORTS) values(?,?,?)";
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			//? 13개를 채우자
			ps.setString(1,dto.getH_day());
			ps.setString(2,dto.getId());
			ps.setDouble(3,dto.getSports());
			
			int res = ps.executeUpdate();//실행
			if(res==1)ok = true;
			//if문에서 { } 을 빼면 한줄만 적용된다
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbclose(con, ps);
		}//finally
		return ok;
}//insertVal
	
	public static boolean idOk(String id) {
		boolean ok = false;
		String sql = "select count(*) from sportskcal where id = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			rs = ps.executeQuery();
			rs.next();
			int cnt = rs.getInt(1);//1은 첫번째 결과 컬럼
			if(cnt != 1) {//1이면 같은 아이디가 있다는 뜻 (중복되었다)
				  //1이 아니면 중복되지 않았다는 뜻	
				ok = true;// ok = true 는 사용 가능의 뜻 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbclose(con, ps, rs);
		}//finally
		return ok;
	}//idOK
	
	public static Vector selsportsList() {
		Vector vRows = new Vector();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select *  from sportkcal where codenum != '0000 ' and (codenum like '1___') ";
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {//한칸씩 내려가되 있으면 true, 없으면 false
				Vector v = new Vector();
				v.add(rs.getString("motion"));
				vRows.add(v);//<=요거 빼먹으면 안되 안되~
			}//while
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbclose(con, ps, rs);
		}//finally
		return vRows;
	}//memList
	

	
	
	public static Vector selsportsList2() {
		Vector vRows = new Vector();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select *  from sportkcal where codenum != '0000 ' and (codenum like '2___') ";
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {//한칸씩 내려가되 있으면 true, 없으면 false
				Vector v = new Vector();
				v.add(rs.getString("motion"));
				vRows.add(v);//<=요거 빼먹으면 안되 안되~
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbclose(con, ps, rs);
		}//finally
		return vRows;
	}//memList2
	
	public static Vector selsportsList3() {
		Vector vRows = new Vector();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select *  from sportkcal where codenum != '0000 ' and (codenum like '3___') ";
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {//한칸씩 내려가되 있으면 true, 없으면 false
				Vector v = new Vector();
				v.add(rs.getString("motion"));
				vRows.add(v);//<=요거 빼먹으면 안되 안되~
			}//while
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbclose(con, ps, rs);
		}//finally
		return vRows;
	}//memList3

	
}//end
