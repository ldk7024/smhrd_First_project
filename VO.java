package BabyProductsRental;

public class VO {
	String id;
	String pw;
	String name;
	String phonenumber;
	String address;
	String account;
	String money;
	String pname;
	String pnumber;
	String bigctg;
	String smallctg;
	String currentprice;
	String monthmoney;
	String pdetail;
	String rstate;
	String rstart;
	String rfinish;
	String latepayment;
	String tpmoney;
	String epayback;
	String deposit;
	String rmonth;
	String rmoney;
	String rnumber;
	String recount;
	String coustomer_id;
	
	
	
	public VO(String pnumber,String pname,String currentprice, String monthmoney, String pdetail, String bigctg, 
			String smallctg, String recount, String rstate,  String coustomer_id) {
		super();
		this.pname = pnumber;
		this.pnumber = pname;
		this.bigctg = currentprice;
		this.smallctg = monthmoney;
		this.currentprice = pdetail;
		this.monthmoney = bigctg;
		this.pdetail = smallctg;
		this.rstate = recount;
		this.recount = rstate;
		this.coustomer_id = coustomer_id;
	}
	public VO(String id, String pnumber, String rstart, String rfinish, String latepayment, String tpmoney,
			String epayback) {
		super();
		this.id = id;
		this.pnumber = pnumber;
		this.rstart = rstart;
		this.rfinish = rfinish;
		this.latepayment = latepayment;
		this.tpmoney = tpmoney;
		this.epayback = epayback;
	}
	public VO(String pname, String pnumber, String bigctg, String smallctg, String currentprice, String rstate) {
		super();
		this.pname = pname;
		this.pnumber = pnumber;
		this.bigctg = bigctg;
		this.smallctg = smallctg;
		this.currentprice = currentprice;
		this.rstate = rstate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPnumber() {
		return pnumber;
	}
	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
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
	public String getRstate() {
		return rstate;
	}
	public void setRstate(String rstate) {
		this.rstate = rstate;
	}
	public String getRstart() {
		return rstart;
	}
	public void setRstart(String rstart) {
		this.rstart = rstart;
	}
	public String getRfinish() {
		return rfinish;
	}
	public void setRfinish(String rfinish) {
		this.rfinish = rfinish;
	}
	public String getLatepayment() {
		return latepayment;
	}
	public void setLatepayment(String latepayment) {
		this.latepayment = latepayment;
	}
	public String getTpmoney() {
		return tpmoney;
	}
	public void setTpmoney(String tpmoney) {
		this.tpmoney = tpmoney;
	}
	public String getEpayback() {
		return epayback;
	}
	public void setEpayback(String epayback) {
		this.epayback = epayback;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getRmonth() {
		return rmonth;
	}
	public void setRmonth(String rmonth) {
		this.rmonth = rmonth;
	}
	public String getRmoney() {
		return rmoney;
	}
	public void setRmoney(String rmoney) {
		this.rmoney = rmoney;
	}
	public String getRnumber() {
		return rnumber;
	}
	public void setRnumber(String rnumber) {
		this.rnumber = rnumber;
	}
	public String getRecount() {
		return recount;
	}
	public void setRecount(String recount) {
		this.recount = recount;
	}
	public String getCoustomer_id() {
		return coustomer_id;
	}
	public void setCoustomer_id(String coustomer_id) {
		this.coustomer_id = coustomer_id;
	}
	
}
