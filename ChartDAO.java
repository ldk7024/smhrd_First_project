package BabyProductsRental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChartDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	String sql = "";
	chartVO cvo = null;
	VO_S vo_S = null;

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

	public VO_S loginselect(String id, String pw) {
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
			// TODO: handle exception
		}finally {
			close();
		}
		return vo_S;

	}

	public ArrayList<chartVO> rankSmallCTG() {
		ArrayList<chartVO> al = new ArrayList<chartVO>();

		try {
			getConn();
			sql = "SELECT SMALLCTG, SUM(RCOUNT) AS ranking FROM production GROUP BY SMALLCTG";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String head = rs.getString(1);
				String rank = rs.getString(2);
				cvo = new chartVO(head, rank);
				al.add(cvo);
			}

		} catch (Exception e) {
		}finally {
			close();
		}
		return al;
	}

	public String loginMoney(String id) {

		String getMoney = null;
		try {
			getConn();
			sql = "select MONEY from customer where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				getMoney = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return getMoney;

	}
	
	public String returnCustomerName(String id) {
		String name = null;
		try {
			getConn();
			sql = "select NAME from CUSTOMER where ID= ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
			}

		} catch (Exception e) {
		}finally {
			close();
		}
		return name;
	}
	public String returnCustomerAddress(String id) {
		String address = null;
		try {
			getConn();
			sql = "select ADDRESS from CUSTOMER where ID= ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				address = rs.getString(1);
			}

		} catch (Exception e) {
		}finally {
			close();
		}
		return address;
	}
	
	
	public int updateMoney(String id, String totalMinus) {
		int cnt = 0;
		try {
			getConn();
			sql = "update CUSTOMER set MONEY=? where ID=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, totalMinus);
			psmt.setString(2, id);
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
		}finally {
			close();
		}
		return cnt;
	}
}
