package BabyProductsRental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JTextField;

public class DAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	String sql = "";
	VO vo = null;
	VOreturn VOreturn = null;
	VOInsert voInsert = null;

	public void getConn() {
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {

		}
	}

	// DB에 연결된 접속을 끊어주는 작업을 위한 메서드
	public void close() {
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

	// 회원가입 메서드
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

		} finally {
			close();
		}
		return cnt;
	}

	// 물품 찾는 메서드
	public ArrayList<VO> select_P() {
		ArrayList<VO> arr = new ArrayList<VO>();
		try {
			getConn();
			sql = "Select pname, pnumber, bigctg, smallctg, currentprice, rstate from production";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String pname = rs.getString(1);
				String pnumber = rs.getString(2);
				String bigctg = rs.getString(3);
				String smallctg = rs.getString(4);
				String currentprice = rs.getString(5);
				String rstate = rs.getString(6);

				vo = new VO(pname, pnumber, bigctg, smallctg, currentprice, rstate);

				arr.add(vo);

			}

		} catch (Exception e) {

			System.out.println("try문에서 에러발생");
			e.printStackTrace();
		} finally {
			close();
		}
		return arr;
	}

	// 물품 지우는거
	public int delete_P(String pnumber) {

		try {
			getConn();
			sql = "delete from production where pnumber=?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, pnumber);
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("try문에 에러가 발생했습니다.");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 물품 삽입 메서드
	public void insert_P(String tf_id, String textField, String textField_1, String textField_2, String textField_3,
			String textField_4, String textField_5, String textField_6, String textField_7, String textField_8) {
		try {

			getConn();
			sql = "insert into production values(?,?,?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, tf_id);
			psmt.setString(2, textField);
			psmt.setString(3, textField_1);
			psmt.setString(4, textField_2);
			psmt.setString(5, textField_3);
			psmt.setString(6, textField_4);
			psmt.setString(7, textField_5);
			psmt.setString(8, textField_6);
			psmt.setString(9, textField_7);
			psmt.setString(10, textField_8);

			cnt = psmt.executeUpdate();
		} catch (Exception e) {

		} finally {
			close();
		}

	}

	// 대여 찾는 메서드
	public ArrayList<VO> select_R() {
		ArrayList<VO> arr = new ArrayList<VO>();
		try {
			getConn();
			sql = "Select customer_id, production_pnumber, rstart, rfinish, latepayment, tpmoney,epayback from rent";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				String ID = rs.getString(1);
				String pnumber = rs.getString(2);
				String rstart = rs.getString(3);
				String rfinish = rs.getString(4);
				String latepayment = rs.getString(5);
				String tpmoney = rs.getString(6);
				String epayback = rs.getString(7);

				vo = new VO(ID, pnumber, rstart, rfinish, latepayment, tpmoney, epayback);

				arr.add(vo);

			}

		} catch (Exception e) {

			System.out.println("try문에서 에러발생");
			e.printStackTrace();
		} finally {
			close();
		}
		return arr;
	}

	// 반납 찾는 메서드
	public ArrayList<VOreturn> select_T() {
		ArrayList<VOreturn> arr = new ArrayList<VOreturn>();
		try {
			getConn();
			sql = "Select rnumber, deposit, rmonth, rmoney, tpmoney,latepayment ,epayback  from rent where rback ='반납신청' or rback ='반납완료'";
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

				VOreturn = new VOreturn(rnumber, deposit, rmonth, rmoney, tpmoney, latepayment, epayback);

				arr.add(VOreturn);

			}

		} catch (Exception e) {

			System.out.println("try문에서 에러발생");
			e.printStackTrace();
		} finally {
			close();
		}
		return arr;
	}

	public String select_rnumber(String rnumber) {
		ArrayList<VOreturn> arr = new ArrayList<VOreturn>();
		try {
			getConn();
			sql = "select rnumber from rent where to_date(rfinish) - to_date(rbackdate) >=15";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			while (rs.next()) {
				rnumber = rs.getString(1);
			}

		} catch (Exception e) {

			System.out.println("try문에서 에러발생");
			e.printStackTrace();
		} finally {
			close();
		}
		return rnumber;
	}

	public String select_rmoney(String rnumber) {
		String rmoney = null;
		try {
			getConn();
			sql = "select rmoney from rent where rnumber = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, rnumber);
			rs = psmt.executeQuery();
			while (rs.next()) {
				rmoney = rs.getString(1);

			}

		} catch (Exception e) {

			System.out.println("try문에서 에러발생");
			e.printStackTrace();
		} finally {
			close();
		}
		return rmoney;
	}

	public String loginMoney(String id) {

		String getMoney = null;
		try {
			getConn();
			sql = "select MONEY from customer where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				getMoney = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getMoney;

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
		}
		return cnt;
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
		}
		return address;
	}
	public ArrayList<VO> select_Main() {
		ArrayList<VO> arr = new ArrayList<VO>();
		try {
			getConn();
			sql = "Select customer_id,production_pnumber,rmoney,rstart,rfinish,epayback,rback from rent wher";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String pname = rs.getString(1);
				String pnumber = rs.getString(2);
				String bigctg = rs.getString(3);
				String smallctg = rs.getString(4);
				String currentprice = rs.getString(5);
				String rstate = rs.getString(6);

				vo = new VO(pname, pnumber, bigctg, smallctg, currentprice, rstate);

				arr.add(vo);

			}

		} catch (Exception e) {

			System.out.println("try문에서 에러발생");
			e.printStackTrace();
		} finally {
			close();
		}
		return arr;
	}


}
