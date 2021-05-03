package BabyProductsRental;

public class productionVO {
	String pnumber;
	String pname;
	String currentprice;
	String monthmoney;
	String pdetail;
	String bigctg;
	String smallctg;
	String rcount;
	String rstate;
	String customer_id;
	
	public productionVO(String pnumber, String pname, String currentprice, String monthmoney, String pdetail,
			String bigctg, String smallctg, String rcount, String rstate, String customer_id) {
		super();
		this.pnumber = pnumber;
		this.pname = pname;
		this.currentprice = currentprice;
		this.monthmoney = monthmoney;
		this.pdetail = pdetail;
		this.bigctg = bigctg;
		this.smallctg = smallctg;
		this.rcount = rcount;
		this.rstate = rstate;
		this.customer_id = customer_id;
	}
	public productionVO(String pnumber, String pname,  String monthmoney, String pdetail, String smallctg) {
		super();
		this.pnumber = pnumber;
		this.pname = pname;
		this.monthmoney = monthmoney;
		this.pdetail = pdetail;
		this.smallctg = smallctg;

	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCurrentprice() {
		return currentprice;
	}

	public void setCurrentprice(String currentprice) {
		this.currentprice = currentprice;
	}

	public String getMonthmoney() {
		return monthmoney;
	}

	public void setMonthmoney(String monthmoney) {
		this.monthmoney = monthmoney;
	}

	public String getPdetail() {
		return pdetail;
	}

	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}

	public String getbigctg() {
		return bigctg;
	}

	public void setbigctg(String bigctg) {
		this.bigctg = bigctg;
	}

	public String getSmallctg() {
		return smallctg;
	}

	public void setSmallctg(String smallctg) {
		this.smallctg = smallctg;
	}

	public String getRcount() {
		return rcount;
	}

	public void setRcount(String rcount) {
		this.rcount = rcount;
	}

	public String getRstate() {
		return rstate;
	}

	public void setRstate(String rstate) {
		this.rstate = rstate;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	
	
}
