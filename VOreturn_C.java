package BabyProductsRental;

public class VOreturn_C {
	  String rnumber; // 대여번호
	   String deposit; // 보증금
	   String rmonth;  // 대여개월수
	   String rmoney;  // 대여금액
	   String tpmoney; // 총결제금액
	   String latepayment; // 연체여부
	   
	   
	   
	   
	   
	   
	   
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

	   public String getEpayback() {
	      return epayback;
	   }

	   public void setEpayback(String epayback) {
	      this.epayback = epayback;
	   }

	   String epayback;
	   
	   //
	   public VOreturn_C(String rnumber, String deposit, String rmonth, String rmoney, String tpmoney, String latepayment,
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

