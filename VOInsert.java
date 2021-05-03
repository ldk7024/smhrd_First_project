package BabyProductsRental;

public class VOInsert {
	String pnumber; 
    String pname;  
    int currentprice;
    int monthmoney;
    String pdetail;      
    String bigctg; 
    String smallctg;  
    int rcount;
    String rstate;
    String customer_id;
	public VOInsert(String pnumber, String pname, int currentprice, int monthmoney, String pdetail, String bigctg,
			String smallctg, int rcount, String rstate, String customer_id) {
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
	public int getCurrentprice() {
		return currentprice;
	}
	public void setCurrentprice(int currentprice) {
		this.currentprice = currentprice;
	}
	public int getMonthmoney() {
		return monthmoney;
	}
	public void setMonthmoney(int monthmoney) {
		this.monthmoney = monthmoney;
	}
	public String getPdetail() {
		return pdetail;
	}
	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}
	public String getBigctg() {
		return bigctg;
	}
	public void setBigctg(String bigctg) {
		this.bigctg = bigctg;
	}
	public String getSmallctg() {
		return smallctg;
	}
	public void setSmallctg(String smallctg) {
		this.smallctg = smallctg;
	}
	public int getRcount() {
		return rcount;
	}
	public void setRcount(int rcount) {
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
