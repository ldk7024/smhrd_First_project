package BabyProductsRental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class productionDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String sql = "";
	chartVO pvo = null;

	public void getConn() {
		try {
			String url = "jdbc:oracle:thin:@222.102.104.14:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("±Â");

			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
//			System.out.println("³ë³ë");
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


	public ArrayList<productionVO> mainTableSelect() {
		ArrayList<productionVO> al = new ArrayList<productionVO>();

		try {
			getConn();
			String sql = "select * from production where rstate='F'";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {

				String pnumber = rs.getString(1);
				String pname = rs.getString(2);
				String monthmoney = rs.getString(4);
				String pdetail = rs.getString(5);
				String smallctg = rs.getString(7);

				productionVO vo = new productionVO(pnumber, pname, monthmoney, pdetail, smallctg);
				al.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return al;
	}

	public ArrayList<productionVO> allSelectProduct() {
		ArrayList<productionVO> al = new ArrayList<productionVO>();

		try {
			getConn();
			String sql = "select * from production";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {

				String pnumber = rs.getString(1);
				String pname = rs.getString(2);
				String currentprice = rs.getString(3);
				String monthmoney = rs.getString(4);
				String pdetail = rs.getString(5);
				String bigctg = rs.getString(6);
				String smallctg = rs.getString(7);
				String rcount = rs.getString(8);
				String rstate = rs.getString(9);
				String customer_id = rs.getString(10);

				productionVO vo = new productionVO(pnumber, pname, currentprice, 
						monthmoney, pdetail, bigctg , smallctg, rcount, rstate,customer_id);
				al.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return al;
	}
	
	public productionVO selectByID(String id) {
		productionVO vo = null;
		try {
			getConn();
			String sql = "select * from production where pnumber = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {

				String pnumber = rs.getString(1);
				String pname = rs.getString(2);
				String currentprice = rs.getString(3);
				String monthmoney = rs.getString(4);
				String pdetail = rs.getString(5);
				String bigctg = rs.getString(6);
				String smallctg = rs.getString(7);
				String rcount = rs.getString(8);
				String rstate = rs.getString(9);
				String customer_id = rs.getString(10);

				vo = new productionVO(pnumber, pname, currentprice, 
						monthmoney, pdetail, bigctg , smallctg, rcount, rstate,customer_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	public productionVO selectByName(String name) {
		productionVO vo = null;
		try {
			getConn();
			String sql = "select * from production where pname = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			while (rs.next()) {

				String pnumber = rs.getString(1);
				String pname = rs.getString(2);
				String currentprice = rs.getString(3);
				String monthmoney = rs.getString(4);
				String pdetail = rs.getString(5);
				String bigctg = rs.getString(6);
				String smallctg = rs.getString(7);
				String rcount = rs.getString(8);
				String rstate = rs.getString(9);
				String customer_id = rs.getString(10);

				vo = new productionVO(pnumber, pname, currentprice, 
						monthmoney, pdetail, bigctg , smallctg, rcount, rstate,customer_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	
	public ArrayList<productionVO> all_desc() {
		ArrayList<productionVO> al = new ArrayList<productionVO>();

		try {
			getConn();
			String sql = "select * from production order by rcount desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {

				String pnumber = rs.getString(1);
				String pname = rs.getString(2);
				String currentprice = rs.getString(3);
				String monthmoney = rs.getString(4);
				String pdetail = rs.getString(5);
				String bigctg = rs.getString(6);
				String smallctg = rs.getString(7);
				String rcount = rs.getString(8);
				String rstate = rs.getString(9);
				String customer_id = rs.getString(10);

				productionVO vo = new productionVO(pnumber, pname, currentprice, 
						monthmoney, pdetail, bigctg , smallctg, rcount, rstate,customer_id);
				al.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

}
