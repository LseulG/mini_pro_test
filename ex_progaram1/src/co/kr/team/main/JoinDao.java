package co.kr.team.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinDao {
	// DAO : Data Access Object = DB 처리 클래스
	

	
		
	public static JoinDto selectMem(String myId) {
		JoinDto dto = null;
		String sql = "select * from joindiet where id=?";					// id로 검색을 하겠다.
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//ID, PWD, NAME, SEX, AGE, HP, EMAIL, ADDR, HEIGHT, WEIGHT, HOPEWEIGHT, WAIST
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, myId);
			rs = ps.executeQuery();
			if(rs.next()) {
			dto = new JoinDto();
			dto.setId(rs.getString("id"));
			dto.setPwd(rs.getString("pwd"));
			dto.setName(rs.getString("name"));
			dto.setSex(rs.getString("sex"));
			dto.setAge(rs.getInt("age"));
			dto.setHp(rs.getString("hp"));
			dto.setEmail(rs.getString("email"));
			dto.setAddr(rs.getString("addr"));
			dto.setHeight(rs.getInt("height"));
			dto.setWeight(rs.getInt("weight"));
			dto.setHopeweight(rs.getInt("hopeweight"));
			dto.setWaist(rs.getInt("waist"));
			}//if
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbclose(con, ps, rs); 
		}
		return dto;
	}//select
	
	public static boolean updateMem(JoinDto dto) {
		boolean ok = false;
		// update 테이블명 set 컬럼 = 값 where 컬럼 = 값
		//    ID, PWD, NAME, SEX, AGE, HP, EMAIL, ADDR, HEIGHT, WEIGHT, HOPEWEIGHT, WAIST            아이디는 PK 이기 때문에 고칠수 없음.
		String sql = "update joindiet set pwd=?, name=?, sex=?, age=?, hp=?, email=?,addr=?, height=?, weight=?, hopeweight=?, waist=? where id=?";
																																			
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getCon();
			ps = con.prepareStatement(sql);
			// ? 채우기
			ps.setString(1, dto.getPwd());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getSex());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getHp());
			ps.setString(6, dto.getEmail());
			ps.setString(7, dto.getAddr());
			ps.setInt(8, dto.getHeight());
			ps.setInt(9, dto.getWeight());
			ps.setInt(10, dto.getHopeweight());
			ps.setInt(11, dto.getWaist());
			ps.setString(12, dto.getId());
			
			// 실행
			int res = ps.executeUpdate();
			if(res==1) {									// 1: 1개를 수정했습니다.
				ok = true;								// ok 를 true 로 바꾼다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbclose(con, ps);							// DB 관련 객체들
		}//finally
		return ok;
	}
	
	

		
		public static boolean deleteMem(String id) {
			boolean ok = false;
			Connection con = null;
			PreparedStatement ps = null;
			String sql = "delete from joindiet where id = ?";
			try {
				con=getCon();
				ps=con.prepareStatement(sql);
				ps.setString(1, id);
				int res = ps.executeUpdate();
				if(res==1) {
					ok=true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ok;
	}

		private static void dbclose(Connection con, PreparedStatement ps) {
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
		}// dbclose
		
		private static void dbclose(Connection con, PreparedStatement ps, ResultSet rs) {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}//if
			dbclose(con, ps);
		}//dbclose

		
	//데이터베이스 연결 메소드
	public static Connection getCon() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "";
		String user = "";
		String password = "";
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}//getCon


}
