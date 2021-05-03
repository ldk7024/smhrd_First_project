package BabyProductsRental;

public class VOreturn {
	String rnumber;
	String deposit;
	String rmonth;
	String rmoney;
	String tpmoney;
	String latepayment;
	String rfinish;
	String rbackdate;
	String epayback;
	
	public VOreturn(String rnumber) {
		super();
		this.rnumber = rnumber;
	}

	
	

	public String getRnumber() {
		return rnumber;
	}




	public void setRnumber(String rnumber) {
		this.rnumber = rnumber;
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




	public String getTpmoney() {
		return tpmoney;
	}




	public void setTpmoney(String tpmoney) {
		this.tpmoney = tpmoney;
	}




	public String getLatepayment() {
		return latepayment;
	}




	public void setLatepayment(String latepayment) {
		this.latepayment = latepayment;
	}




	public String getRfinish() {
		return rfinish;
	}




	public void setRfinish(String rfinish) {
		this.rfinish = rfinish;
	}




	public String getRbackdate() {
		return rbackdate;
	}




	public void setRbackdate(String rbackdate) {
		this.rbackdate = rbackdate;
	}




	public String getEpayback() {
		return epayback;
	}




	public void setEpayback(String epayback) {
		this.epayback = epayback;
	}




	public VOreturn(String rnumber, String deposit, String rmonth, String rmoney, String tpmoney, String latepayment,
			String epayback) {
		super();
		this.rnumber = rnumber;
		this.deposit = deposit;
		this.rmonth = rmonth;
		this.rmoney = rmoney;
		this.tpmoney = tpmoney;
		this.latepayment = latepayment;
		this.epayback = epayback;
	}
	
}
