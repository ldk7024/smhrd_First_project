package BabyProductsRental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO_C {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	String sql = "";
	VO_C vo_C = null;
	VOreturn_C VOreturn_C = null;
	VOupdate_C VOupdate_C = null;
	VO_S vo_S = null;
	// JDBC 연결 메서드
	public void getConn() {
		try {
			String url = "jdbc:oracle:thin:@222.102.104.14:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("굿");

			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
//			System.out.println("노노");
			e.printStackTrace();
		}
	}public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 고객정보 임의설정 삽입 메서드
	public int insert_C(String id, String pw, String name, String phonenumber, String address, String account,
			String money) {

		try {

			getConn();
			sql = "insert into customer values(?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			psmt.setString(4, phonenumber);
			psmt.setString(5, address);
			psmt.setString(6, account);
			psmt.setString(7, money);

			cnt = psmt.executeUpdate();
		} catch (Exception e) {

		}finally {
			close();
		}
		return cnt;
	}

	// 로그인 메서드
	public VO_S loginselect( String id, String pw ) {
		try {
			getConn();

			sql = "select id, pw from customer where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String getid = rs.getString(1);
				String getpw = rs.getString(2);

				vo_S = new VO_S(getid, getpw);
				// VO/DTO : 파일간의 데이터를공유할 때 하나하나의 변수를 보내는 게 아니라
//	                    묶어서 데이터를 전송할 수 있는 객체
			}
		} catch (Exception e) {
			System.out.println("JDBC오류");
		}
		finally {
			close();
		}
		return vo_S;

	}

	// 원차트 메서드
//	public ArrayList<chartVO> rankSmallCTG() {
//		ArrayList<chartVO> al = new ArrayList<chartVO>();
//
//		try {
//			getConn();
//			sql = "SELECT SMALLCTG, SUM(RCOUNT) AS ranking FROM production GROUP BY SMALLCTG";
//			psmt = conn.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			while (rs.next()) {
//				String head = rs.getString(1);
//				String rank = rs.getString(2);
//				cvo = new chartVO(head, rank);
//				al.add(cvo);
//			}
//
//		} catch (Exception e) {
//		}
//		return al;
//	}
	
	// 고객 회원가입 생성 메서드
	public int insert_Create(String id, String pw, String name, String phonenumber, String address, String bankaccount,
			int money) {
		try {
			getConn();
			sql = "insert into customer values( ?, ?, ?, ?, ?, ?, 0)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			psmt.setString(4, phonenumber);
			psmt.setString(5, address);
			psmt.setString(6, bankaccount);

			cnt = psmt.executeUpdate();

			if (conn != null) {
				System.out.println("DB연결성공");
			} else {
				System.out.println("DB연결실패");
			}

		} catch (Exception e) {
			System.out.println("try문에서 에러가 발생했습니다.");
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;

	}

	// 예치금출력 메서드
	public String loginMoney(String id) {

		String getMoney = null;
		try {
			getConn();
			sql = "select money from customer where id = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);

			rs = psmt.executeQuery();

			System.out.println(rs);

			while (rs.next()) {
				getMoney = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return getMoney;

	}

	// 테이블 출력 메서드
	public ArrayList<VOreturn_C> select_T() {
		ArrayList<VOreturn_C> arr = new ArrayList<VOreturn_C>();
		try {
			getConn();
			sql = "Select rnumber, deposit, rmonth, rmoney, tpmoney,latepayment ,epayback  from rent where rback ='반납신청'";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				String rnumber = rs.getString(1);
				String deposit = rs.getString(2);
				String rmonth = rs.getString(3);
				String rmoney = rs.getString(4);
				String tpmoney = rs.getString(5);
				String latepayment = rs.getString(6);
				String epayback = rs.getString(7);

				VOreturn_C = new VOreturn_C(rnumber, deposit, rmonth, rmoney, tpmoney, latepayment, epayback);

				arr.add(VOreturn_C);

			}

		} catch (Exception e) {

			System.out.println("try문에서 에러발생");
			e.printStackTrace();
		}finally {
			close();
		}
		return arr;
	}
	
	// 고객 회원정보 수정 메서드
	public int update_customer( String id, String pw, String address, String phonenumber, String account  ) {
		try {
			getConn();
			sql = "update CUSTOMER set pw = ?, address = ?, phonenumber = ?, account = ? where id = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, pw);
			psmt.setString(2, address);
			psmt.setString(3, phonenumber);
			psmt.setString(4, account);
			psmt.setString(5, id);

			cnt = psmt.executeUpdate();

			if (conn != null) {
				System.out.println("DB연결성공");
			} else {
				System.out.println("DB연결실패");
			}

		} catch (Exception e) {
			System.out.println("try문에서 에러가 발생했습니다.");
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;

	}
	
	// 회원정보수정에 대한 데이터 Select문으로 가져오기
	public VO_C select_C(String id) {
	      try {
	         getConn();
	         sql = "select pw, address,phonenumber,account from CUSTOMER where id = ?";
	         psmt = conn.prepareStatement(sql);

	         psmt.setString(1, id);
	         
	         rs = psmt.executeQuery();
	         
	         while (rs.next()) {
	            String pw = rs.getString(1);
	            String phonenumber = rs.getString(2);
	            String address = rs.getString(3);
	            String account = rs.getString(4);

	            vo_C = new VO_C( pw, phonenumber, address, account );

	         }

	      } catch (Exception e) {

	         System.out.println("try문에서 에러발생");
	         e.printStackTrace();
	      } finally {
	    	  
	      }
		return vo_C;
	   }
	
	
}
