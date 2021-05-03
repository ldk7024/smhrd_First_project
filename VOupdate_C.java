package BabyProductsRental;

public class VOupdate_C {
	private String id;
	private String pw;
	private String phonenumber;
	private String address;
	private String account;
	
	public VOupdate_C(String id, String pw, String phonenumber, String address, String account) {
		super();
		this.id = id;
		this.pw = pw;
		this.phonenumber = phonenumber;
		this.address = address;
		this.account = account;
	}

// ------------------------------------------------------------------------------------------ //	
	
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
}
