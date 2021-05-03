package BabyProductsRental;

import java.util.ArrayList;

public class 물품조회select {
	public void select_PP() {
		DAO dao = new DAO();
		ArrayList<VO> arr = dao.select_P();
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.println("ID : "+arr.get(i).getPname());
			System.out.println("PW : "+arr.get(i).getPnumber());
			System.out.println("TEL : "+arr.get(i).getBigctg());
			System.out.println("EMAIL : "+arr.get(i).getSmallctg());
			System.out.println("ADDRESS : "+arr.get(i).getCurrentprice());
			System.out.println("ADDRESS : "+arr.get(i).getRstate());
			
		}
		
		
	}
}
