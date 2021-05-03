package BabyProductsRental;

public class VO_C {
	private String id;
	private String pw;
	private String name;
	private String phonenumber;
	private String address;
	private String account;
	private String money;
	private String pname;
	private String pnumber;
	private String bigctg;
	private String smallctg;
	private String currentprice;
	private String rstate;

//	public VO() {
//	}

	public VO_C(String pname, String pnumber, String bigctg, String smallctg, String currentprice, String rstate) {
		this.pname = pname;
		this.pnumber = pnumber;
		this.bigctg = bigctg;
		this.smallctg = smallctg;
		this.currentprice = currentprice;
		this.rstate = rstate;
	}

	public VO_C(String id, String pw, String name, String phonenumber, String address, String account, String money) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phonenumber = phonenumber;
		this.address = address;
		this.account = account;
		this.money = money;
	}
	


	public VO_C(String pw, String address, String phonenumber, String account) {
		super();
		this.pw = pw;
		this.address = address;
		this.phonenumber = phonenumber;
		this.account = account;
	}

	public VO_C(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public VO_C(String id) {
		this.id = id;
	}

	
// --------------------------------------------------------------------------- //	

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

	public String getRstate() {
		return rstate;
	}

	public void setRstate(String rstate) {
		this.rstate = rstate;
	}

}
